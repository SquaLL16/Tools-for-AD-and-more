# dnsrecon

## Overview

dnsrecon is a tool used for DNS enumeration. It helps gather information about a domain's DNS records, including looking for subdomains, identifying DNS servers, checking for DNS misconfigurations, and performing various DNS queries.

## Options

    -d <target_ip>: Specifies the target domain or ip address
    -t <query_type>: Specifies the query type


## Query types

### axfr

An AXFR is a type of DNS query used to request a zone transfer from a DNS server. A zone transfer is typically used to replicate DNS records between DNS servers.

Zone transfers usually occur between authoritative DNS servers for a given domain to ensure that all DNS records (like A, MX, TXT, NS, etc.) are synchronized across multiple servers.

A properly configured DNS server will allow zone transfers between trusted servers only. However, if a DNS server is misconfigured or vulnerable, it might allow unauthorized users to perform a zone transfer and obtain a complete list of domain records.

## Usage

Try to do a dns zone transfer

    dnsrecon -d <target_ip> -t axfr