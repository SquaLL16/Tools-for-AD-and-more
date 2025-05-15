# DomainPasswordSpray

## Overview

DomainPasswordSpray is a tool written in PowerShell to perform a password spray attack against users of a domain. By default it will automatically generate the userlist from the domain. BE VERY CAREFUL NOT TO LOCKOUT ACCOUNTS!

## Usage

Import-Module .\DomainPasswordSpray.ps1

Letting DomainPasswordSpray generate the usersnames:

    Invoke-DomainPasswordSpray -Password Welcome1 -OutFile spray_success -ErrorAction SilentlyContinue


## More Information

https://github.com/dafthack/DomainPasswordSpray