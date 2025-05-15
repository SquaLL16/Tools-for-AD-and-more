# dig - Domain Information Groper

## Overview

Is a command-line tool is used to query DNS (Domain Name System) servers for information about domain names, IP addresses, mail servers, and other DNS records. It is commonly used for network troubleshooting and obtaining DNS-related information.


## Usage

Query IPv4 record

```
dig <domain>
```
or
```
dig -A <domain>
```

Query Mail Server Record MX

```
dig MX <domain>
```

Query a Name Server record

```
dig ns <domain>
```

Reverse DNS Lookup

```
dig -x <ip>
```