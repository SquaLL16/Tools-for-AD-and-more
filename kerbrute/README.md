# kerbrute

## Overview

A tool to quickly bruteforce and enumerate valid Active Directory accounts through Kerberos Pre-Authentication

## Installation




## Usage

Test usernames to see if they are on the domain:

    kerbrute userenum --dc <ip_to_domain_controller> -d <full_domain_name> <path_to_file_with_usernames>
        kerbrute userenum --dc 10.10.10.10 -d jab.htb usernames.txt

Do a password spray:

    kerbrute passwordspray -d <domain_name> --dc <domain_controller_ip> <file_with_valid_usernames> <password>
        kerbrute passwordspray -d inlanefreight.local --dc 172.16.5.5 valid_users.txt  Welcome1



## More Information


https://github.com/ropnop/kerbrute