# xfreerdp

## Overview

xfreerdp is an X11 Remote Desktop Protocol (RDP) client which is part of the FreeRDP project. An RDP server is built-in to many editions of Windows. Alternative servers included xrdp and VRDP (VirtualBox).

## Installation

	sudo apt-get install freerdp2-x11

## Command Options

	/v:{target_IP} : Specifies the target IP of the host we would like to connect to.
	/cert:ignore : Specifies to the scrips that all security certificate usage should be ignored.
	/u:Administrator : Specifies the login username to be "Administrator".
	/p <password> : Specifies the password for the user


## Usage

Simple login

```shell
xfreerdp /v:<ip> /u:<username> /p:<password>
```

Login and setup a drive:

```shell
xfreerdp /v:<ip> /u:<username> /p:<password> /drive:<remote_path_to_drive>,"<local_path_to_be_staged"
#example
xfreerdp /v:127.0.0.1:13389 /u:hporter /p:Gr8hambino! /drive:home,"/home/tester/tools"
```


