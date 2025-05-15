# rpcclient

## Overview

rpcclient is a handy tool created for use with the Samba protocol and to provide extra functionality via MS-RPC. It can enumerate, add, change, and even remove objects from AD

## Usage 

First establish a NULL session:

    rpcclient -U "" -N <domain_controller_ip>

Query user domain information

    query user <username>