# ldapDomainDump

## Overview

ldapdomaindump is a tool that collects and parses information available via LDAP and outputs it in a human readable HTML format, as well as machine readable json and csv/tsv/greppable files.

## Usage

    ldapdomaindum ldap://<ip_address> -u '<domain>\<username>' -p <password>

With annonymous authentication

    ldapdomaindum ldap://<ip_address> 


## More Information

    https://github.com/dirkjanm/ldapdomaindump