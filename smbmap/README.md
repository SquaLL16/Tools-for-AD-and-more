# smbmap

## Overview

SMBMap allows users to enumerate samba share drives across an entire domain. List share drives, drive permissions, share contents, upload/download functionality, file name auto-download pattern matching, and even execute remote commands. This tool was designed with pen testing in mind, and is intended to simplify searching for potentially sensitive data across large networks.

https://github.com/ShawnDEvans/smbmap

## Options

	-H <HOST> : IP of target to enumerate
	-A <pattern> : Define a file name pattern (regex) that auto downloads a file on a match (requires -r)

	-r <sharename> : shows the contents of share


	--no-banner : Removes the banner from the top of the output
	--download '<sharename>\\<dirname>\\<filename>' : Downloads the file
	--depth <depth_level> : Depth of recursive


## Cookbook

If we are getting this error:

	Something weird happened: SMB SessionError: code: 0xc0000022 - STATUS_ACCESS_DENIED

We might want to try using a filler username:

	smbmap -H nest.htb --no-banner -u 'asdasd'

List smb share contents

	smbmap -H nest.htb --no-banner -u 'asdasda' -r 'Data' --depth 100

Download all xml files found

	smbmap -H nest.htb --no-banner -u 'asdasda' -r 'Data' --depth 100 -A xml