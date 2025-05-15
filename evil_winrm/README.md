# Evil-WinRM

## Overview

This shell is the ultimate WinRM shell for hacking/pentesting.

https://github.com/Hackplayers/evil-winrm

## Instalation

Requires ruby to be installed.

	sudo gem install evil-winrm

## Command Options

	-i : Specifies the target ip
	-u : Specifies the user to login
	-p : Specifies the password to login
	-H: Specifies a hash instead of a password to login


## Making evil-winrm work with krb5

https://gist.github.com/zhsh9/f1ba951ec1eb3de401707bbbec407b98

```
sudo python config_krb5.py <domain_name> <domain_controller_ip>
```

this will create a /etc/krb5.conf

Then 
```
export KRB5CCNAME=<tgt>.ccache
```
anf finally

```
evil-winrm -i <ip> -r <domain>
```


## Usage

evil-winrm -i <ip_to_remote_machine> -u 'username' -p 'password'

evil-winrm -i <ip_to_remote_machine> -u 'username' -H 'hash'


Upload and download a file

	upload <path_to_file_on_local> <Absolute_path_on_remote>
	download <absolute_path_on_remote> <absolute_path_local>


