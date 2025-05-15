# knockpy

## Overview

Knockpy is a portable and modular python3 tool designed to quickly enumerate subdomains on a target domain through passive reconnaissance and dictionary scan.

## Command Options

	-h, --help		show this help message and exit
	-d DOMAIN,		--domain DOMAIN
	--timeout TIMEOUT     custom timeout
	--threads THREADS     custom threads
	--recon               subdomain reconnaissance
	--bruteforce          subdomain bruteforce
	--wordlist WORDLIST   wordlist file to import
                        --bruteforce option required

## Usage

Default subdomain bruteforce

	knockpy -d <domain> --recon --bruteforce


## More Information

https://github.com/guelfoweb/knock