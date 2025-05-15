# JohnTheRipper

## Overview

John the Ripper is a fast password cracker

## Command Options

	-w : Path to which wordlist to use

## Usage

First try to crack the file with the rockyou wordlist.

If it fails, append the --rules flag

	john <file_to_crack> --wordlist=/usr/share/rockyou.txt --rules

If this fails, try the default bruteforce, with no options and no wordlist:

	john <file_to_crack>

## Cracking Files

	pdf2john 	Converts PDF documents for John
	ssh2john 	Converts SSH private keys for John
	mscash2john 	Converts MS Cash hashes for John
	keychain2john 	Converts OS X keychain files for John
	rar2john 	Converts RAR archives for John
	pfx2john 	Converts PKCS#12 files for John
	truecrypt_volume2john 	Converts TrueCrypt volumes for John
	keepass2john 	Converts KeePass databases for John
	vncpcap2john 	Converts VNC PCAP files for John
	putty2john 	Converts PuTTY private keys for John
	zip2john 	Converts ZIP archives for John
	hccap2john 	Converts WPA/WPA2 handshake captures for John
	office2john 	Converts MS Office documents for John
	wpa2john 	Converts WPA/WPA2 handshakes for John


## Cookbook

Select wordlist and crack hash in file

	john -w=<path_to_word_list> <path_to_hash_file>

	Example: john -w=/usr/share/wordlists/rockyou.txt hash.txt

Crack zip password file

	zip2john <file>.zip > fileName.john
	john --show fileName.john

Crak id_rsa private keys

	ssh2john id_rsa > id_rsa.hash
	john id_rsa.hash --wordlist=/usr/share/wordlists/rockyou.txt

Crack .doc files

	office2john <filename>.doc > doc_file_hash

	john doc_file_hash --wordlist=/usr/share/wordlists/rockyou.txt