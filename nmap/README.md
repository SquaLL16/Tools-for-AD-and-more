# nmap

## Overview

## Options

	-iL <hosts_file_name>: Specifies a file with a list of hosts to scan
	-n: Avoid dns resolution
	-Pn: Skip the host discovery phase, assumes host is online
	-sS: Perform a stealth (SYN) scan
	-sn: Disables port scanning

	--packet-trace: Shows all packets sent and received


## -Pn 

The -Pn option in Nmap is used to disable host discovery (i.e., skip the step of checking if a host is online before scanning). By default, Nmap performs a host discovery (ping sweep) to check if the target hosts are up before scanning for open ports. This can involve sending ICMP echo requests, TCP SYN packets, or other probes to determine whether the host is reachable.

When you use the -Pn option, Nmap assumes that the target host is up and directly proceeds to the port scanning phase, bypassing the host discovery step. This can be useful in certain scenarios where you already know the host is up, or if you're scanning a host that might block ping or other probes.

## -sS

Stealth scan. This is the most commonly used scan for stealth. It only sends SYN packets to the target ports and waits for a response. If a port is open, the target responds with a SYN-ACK packet, and Nmap doesn't complete the TCP handshake. Instead, it sends a RST (reset) packet to close the connection, making it harder to detect compared to a full connection scan.

Why It’s Silent: The half-open nature of the scan does not complete the TCP handshake, making it difficult for the target to log the connection as a full open connection.

## Usage

Specifiy a list of hosts in a file

	sudo nmap -v -A -iL hosts.txt -oN /home/User/Documents/host-enum

Silent scan:

	nmap -sS -T1 -n 192.168.1.1


Host discovery:

```
sudo nmap 10.129.2.0/24 -sn -oA tnet | grep for | cut -d" " -f5
```


**Scan network with wildcards**

	nmap 172.28.23.*

**Find live host in network**

	nmap -sP 172.28.23.*

**Scan specific port**
	
	nmap -p 61616 172.28.23.67

**Scan all ports**

	nmap -p- 172.28.23.67

**Only show open ports**

	nmap --open 172.28.23.67

**Detect OS**

	nmap -O ip

**Fastest way to scan**

	nmap -T5 iprange

**Detect port service and version**

	nmap -sV 172.28.23.67

**No port scan**

	nmap -sn 

**Generate xml Report and convert it to HTML**

    nmap -T4 -p 1-1000 -oX output.xml scanme.nmap.org
    xsltproc output.xml -o output.html

**Fast Discovery Scan**

	nmap -T5 -sL 172.28.23.*

	if -sL doens't work then

	nmap -T5 -F 172.28.23.*

**Faster Discovery Scan**

	nmap -p- --min-rate=1000 -sV <target_ip>
