# PowerView

## Overview

PowerView is series of functions that performs network and Windows domain enumeration and exploitation.

## Functions

### Find-DomainUserLocation

```powershell
#Enumerate domain machines of the current/specified domain where specific users are logged into
Find-DomainUserLocation -Domain <DomainName> | Select-Object UserName, SessionFromName
```

### Get-Domain

```powershell
#Retrieves information about the current Active Directory domain
Get-Domain

#Enumerate Other Domains
Get-Domain -Domain <domain_name>
```

### Get-DomainComputer

 Retrieves a list of all computers in the current domain.

```powershell
Get-DomainComputer -Properties OperatingSystem, Name, DnsHostName | Sort-Object -Property DnsHostName

#Enumerate Live machines
Get-DomainComputer -Ping -Properties OperatingSystem, Name, DnsHostName | Sort-Object -Property DnsHostName
```

### Get-DomainController

Enumerate domain controllers (DCs) within an Active Directory environment

```powershell
Get-DomainController
Get-DomainController -Domain <DomainName>
```

### Get-DomainGPO

Enumerates the group policies

```powershell
Get-DomainGPO -Properties DisplayName | Sort-Object -Property DisplayName
#Enumerate all GPOs to a specific computer
Get-DomainGPO -ComputerIdentity <ComputerName> -Properties DisplayName | Sort-Object -Property DisplayName
```

### Get-DomainGPOLocalGroup

Return all GPOs in a domain that modify local group memberships through Restricted Groups or Group Policy Preferences

```powershell
Get-DomainGPOLocalGroup | Select-Object GPODisplayName, GroupName
```

### Get-DomainGroup

Enumerates the groups of a domain

```powershell
#Save all Domain Groups to a file:
Get-DomainGroup | Out-File -FilePath .\DomainGroup.txt

#Return members of Specific Group (eg. Domain Admins & Enterprise Admins)
Get-DomainGroup -Identity '<GroupName>' | Select-Object -ExpandProperty Member
```

### Get-DomainGroupMember

Retrieves domain group specific information

```powershell
Get-DomainGroupMember -Identity "Domain Admins" -Recurse
```

### Get-NetLoggedon

Enumerates users loggedon a machine

```powershell
Get-NetLoggedon -ComputerName <ComputerName>
```

### Get-NetSession

Enumerate Session Information for a machine

```powershell
Get-NetSession -ComputerName <ComputerName>
```


### Get-DomainPolicy

Retrieves Group Policy settings related to the domain, specifically the Default Domain Policy and Default Domain Controllers Policy

```powershell
Get-DomainPolicy

#Will show us the policy configurations of the Domain about system access or kerberos
Get-DomainPolicy | Select-Object -ExpandProperty SystemAccess
Get-DomainPolicy | Select-Object -ExpandProperty KerberosPolicy
```

### Get-DomainUser

Retrieves information about a domain user.

```powershell
#Save all Domain Users to a file
Get-DomainUser | Out-File -FilePath .\DomainUsers.txt
#We can find users with SPN set:
Get-DomainUser -SPN -Properties samaccountname,ServicePrincipalName
```

### Get-DomainTrustMapping

Enumerates the domain trust mappings

    Get-DomainTrustMapping



### Set-DomainUserPassword

The Set-DomainUserPassword cmdlet is used in PowerShell to change or set the password for a user account in an Active Directory domain.
We can specify as which user we want to run the cmdlet as, but if we want to do it as the user we are logged in as, we only need to specify the target user:

    $SecPassword = ConvertTo-SecureString '<new_password>' -AsPlainText -Force
    Set-DomainUserPassword -Identity <User_which_password_is_gonna_change> -AccountPassword $SecPassword

For example:

    $SecPassword = ConvertTo-SecureString 'Password123!' -AsPlainText -Force
    Set-DomainUserPassword -Identity Jacob.Surname -AccountPassword $SecPassword

### Test-AdminAccess

Test for local admin access on either the current machine or a remote one:

    Test-AdminAccess -ComputerName <hostname>
