# snmpwalk

## Overview

snmpwalk is a command-line tool used to retrieve a large amount of information from an SNMP-enabled device (e.g., routers, switches, servers, etc.) by walking through the SNMP Management Information Base (MIB). It’s typically used to query SNMP agents to retrieve various data from a device.

## Options

    -v <version>: Specifies the SNMP version
    -c <community_string>: The SNMP community string, which acts like a password. Common values are public (for read-only access) and private (for read-write access).
    -t <int>: Request timeout


## Usage

```
snmpwalk -c public -v1 -t 10 10.10.11.48

snmpwalk -v X -c public <target_ip> NET-SNMP-EXTEND-MIB::nsExtendOutputFull
```