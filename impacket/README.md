# Impacktek

## Overview

Impacket is a collection of Python classes for working with network protocols. (Speccially good for windows)

https://github.com/fortra/impacket


## Useful scripts in the examples folder

To connect to ms sql

	python3 mssqlclient.py -h

To connect a shell to windows remote host using a user and password

	pytohn3 psexec.py <username>@<target_ip>


## smb server

Start an smb server

	impacket-smbserver -smb2support -user <username> -password <password> <servername> <serverpath_of_files_to_share>

	Example: impacket-smbserver -smb2support -user testuser -password testpassword mysmbserver $(pwd)

Connect to the smb server on a windows machine by doing:

	Win+r to open run
	\\<ip_of_smb_server>\servername