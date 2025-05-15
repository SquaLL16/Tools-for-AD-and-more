# enum4linux-ng

## Overview

tool for enumerating information from Windows and Samba systems, aimed for security professionals and CTF players. The tool is mainly a wrapper around the Samba tools nmblookup, net, rpcclient and smbclient.

## Installation

    sudo apt install enum4linux-ng

## Options

    -A All simple enumeration
    -P Get password policy information via RPC
    -U Get User list
    -oA Writes output to YAML and JSON file


## Usage

Find out password policy

    enum4linux-ng -P <target_ip> -oA <ouput_file>

Do all simple enumeration

    enum4linux-ng -A <target_ip> -oA <ouput_file>

Do a smb null session to get userlists

    enum4linux-ng -U <target-ip>


## More Information

https://github.com/cddmp/enum4linux-ng