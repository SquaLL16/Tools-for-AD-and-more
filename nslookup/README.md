# nslooup

## Overview

nslookup is a command-line tool used to query Domain Name System (DNS) servers to obtain domain name or IP address mapping information.


## Usage

Look up the IP address for a domain name

    nslookup example.com

Reverse DNS Lookup

    nslookup 192.0.2.1

Query a specific dns server (like a domain controller):

    nslookup example.com <dns_server_ip>
