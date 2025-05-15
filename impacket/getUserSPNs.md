# impacket GetUserSPNs - GetUserServicePrincipalNames

## Overview

getUserspns is a script in Impacket that can be used to extract Service Principal Names (SPNs) associated with user accounts in an Active Directory environment. SPNs are unique identifiers that are used by Kerberos to associate a service instance with a user account. This tool is useful for enumerating SPNs within a domain, which can help in identifying potentially vulnerable services and accounts for further attacks, such as Kerberos-based attacks (e.g., Kerberos ticket abuse).

### Key Features

Purpose:

The getUserspns script helps retrieve SPNs (Service Principal Names) that are associated with user accounts in the Active Directory environment. This is crucial because SPNs are sometimes misconfigured, allowing attackers to take advantage of the information for various attacks.

Why SPNs Matter:

SPNs allow the Kerberos authentication protocol to uniquely identify services. If misconfigured, SPNs can be leveraged for Kerberos abuse attacks such as Pass-the-Ticket (PTT) or Silver Ticket attacks.
Sometimes, services might be running with higher privileges, and knowing which users are associated with certain services can lead to privilege escalation.

How it Works:

When you run getUserspns, it queries the Active Directory for all user accounts and their associated SPNs. It does this by performing an LDAP query and retrieving the information from the domain controllers.
The tool can display a list of users and the SPNs associated with those users, which could include services like SQL Servers, Web Services, File Shares, or other custom services in the environment.

## Usage

    impacket-GetUserSPNs <domain>/<username>[:password] -dc-ip <DomainControllerIP>

Listing SPN Accounts

    impacket-GetUserSPNs <domain>/<username> -dc-ip <DomainControllerIP> -no-pass

Requesting all tgs tickets

    impacket-GetUserSPNs -request -dc-ip <DomainControllerIP> <domain>/<username>

Reuqest ticker for specific SPN

    impacket-GetUserSPNs  -dc-ip <DomainControllerIP> <domain>/<username> -request-user <spn_name>