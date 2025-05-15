# ldapsearch

## Overview

ldapsearch is a command-line tool used to search and query an LDAP (Lightweight Directory Access Protocol) directory.


## Options

    -x: Use simple authentication instead of SASL

## Usage

Search All Entries in a Directory

    ldapsearch -x -b "dc=example,dc=com"

Enumerate Password Policy

    ldapsearch -h 172.16.5.5 -x -b "DC=INLANEFREIGHT,DC=LOCAL" -s sub "*" | grep -m 1 -B 10 pwdHistoryLength

Search for users in a target Windows doman

    ldapsearch -h 172.16.5.5 -x -b "DC=INLANEFREIGHT,DC=LOCAL" -s sub "(&(objectclass=user))" | grep sAMAccountName: | cut -f2 -d" "

