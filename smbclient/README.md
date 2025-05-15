# smbclient

## Overview

Command-line tool that allows you to access shared files and printers over the Server Message Block (SMB) protocol. It is often used for interacting with SMB shares on Windows and Linux systems. It’s similar to FTP in terms of functionality but specifically designed to work with SMB file shares.

## Usage

List shares with no passord or user:

    smbclient -N -L \\\\<smb_server_ip>

Connect to a share with a username:

    smbclient -U <username> \\\\<smb_server_ip>\\<share_name>

Download entire dir:

```shell
recurse ON
prompt OFF
cd 'path\to\remote\dir'
mget *
```