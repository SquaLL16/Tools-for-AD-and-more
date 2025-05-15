# activedirectory Powershell Module

## Overview

The ActiveDirectory PowerShell module is a group of PowerShell cmdlets for administering an Active Directory environment from the command line. It consists of 147 different cmdlets.

## Usage

    Import-Module ActiveDirectory


## cmdlets

### Get-ADDomain

Will print out helpful information like the domain SID, domain functional level, any child domains, and more.

    Get-ADDomain

### Get-ADUser

Print information about AD user:

    Get-ADUser

We can use filters.
Filter by users with the ServicePrincipalName property populated:

    Get-ADUser - Filter {ServicePrincipalName -ne "$null"} -Properties ServicePrincipalName


### Get-ADTrust

Verifies domain trust relationships

    Get-ADTrust -Filter *


### Get-ADGroup

Gather AD group information:

    Get-ADGroup -Filter * | select name

Get informatioon of a specific group:

    Get-ADGroup -Identity "<group_name>"


### Get-ADGroupMember

Gets list of group members

    Get-ADGroupMember -Identity "<group_name>"