# chisel

## Overview

	Chisel is a fast TCP/UDP tunnel, transported over HTTP, secured via SSH. Single executable including both client and server. Written in Go (golang). Chisel is mainly useful for passing through firewalls, though it can also be used to provide a secure endpoint into your network.

## Installation

	curl https://i.jpillora.com/chisel! | bash

## Usage

Lets consider we want to reflect port 8000

	./chisel server -port 7777 --reverse 
	This will be the server that will listen for the reflection

	./chisel client <server_ip>:7777 R:8000:127.0.0.1:8000


Let's say that in a remote server there is the port 8000 that only accepts 127.0.0.1 connections:

	In our local machine we want to star the server on any available port:
	chisel server --reverse --port 4444

	In the remote server we want to use the chisel client to connect to the server:
	chisel client $localMachineIp:4444 R:8000:127.0.0.1:8000

	Now in the local machine we can connet to this by accessing 127.0.0.1:8000

### Using socks5

To use socks5 to reverse ports with chisel we do

In the remote/tartget host:

	./chisel client <localhost_ip>:<chisel_server_port> R:socks

In the local host:

	./chisel server --reverse --socks5 --port <chisel_server_port>

By default socks5 uses port 1080, so we can proxy our requests through this port:

	Browser requests we can use foxy proxy

	For command line requests we can use proxychains.
		Check if proxychains config /etc/proxychains.conf is using socks 5:
			socks5 127.0.0.1 1080


## More Information

	https://github.com/jpillora/chisel
	https://book.hacktricks.xyz/generic-methodologies-and-resources/tunneling-and-port-forwarding#chisel