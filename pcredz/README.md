# pcredz

## Overview 

This tool extracts Credit card numbers, NTLM(DCE-RPC, HTTP, SQL, LDAP, etc), Kerberos (AS-REQ Pre-Auth etype 23), HTTP Basic, SNMP, POP, SMTP, FTP, IMAP, etc from a pcap file or from a live interface.

## Installation

	apt install python3-pip && sudo apt-get install libpcap-dev && pip3 install Cython && pip3 install python-libpcap


## Usage

	# extract credentials from a pcap file
	python3 ./Pcredz -f file-to-parse.pcap

	# extract credentials from all pcap files in a folder
	python3 ./Pcredz -d /tmp/pcap-directory-to-parse/

	# extract credentials from a live packet capture on a network interface (need root privileges)
	python3 ./Pcredz -i eth0 -v

## More info

	https://github.com/lgandx/PCredz