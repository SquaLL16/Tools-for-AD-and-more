# ffuf

## Overview

Tools such as ffuf provide us with a handy automated way to fuzz the web application's individual components or a web page. 

## Options

	-fs: filters responses by response size
	-fw: filters responses by number of words
	-fc: filters responses by status code

## Usage

Directory fuzzing

	ffuf -w /opt/useful/SecLists/Discovery/Web-Content/directory-list-2.3-small.txt:FUZZ -u http://SERVER_IP:PORT/FUZZ

Parameter fuzzing

	ffuf -w /opt/useful/SecLists/Discovery/Web-Content/burp-parameter-names.txt:FUZZ -u http://admin.academy.htb:PORT/admin/admin.php?FUZZ=key -fs xxx

Fuzzing a file inclusion on windows

	ffuf -w /usr/share/wordlists/file_inclusion_windows.txt -u http://mailing.htb/download.php?file=FUZZ

Content type header is need when fuzzing a POST

	ffuf -w usernames_to_delete.txt:USERNAME -X POST -d "username=USERNAME&password=admin2" -u http://report.solarlab.htb:6791/login -H "Content-Type: application/x-www-form-urlencoded"

Fuzz a req file:

	Edit the request file and add the word FUZZ to wherever you want.

	Then do: ffuf -w numbers2.txt -request req

	And ffuf will replace the words from the wordlist in the request. You can test it with wireshark
	By default ffuf will do the request in https even if the request file specifies that it is HTTP. If you really want HTTP you need to add the -request-proto http
	
	ffuf -w numbers2.txt -request req -request-proto http

Fuzz multiple fields in file:

	ffuf -w usernames.txt:USERNAME_FUZZ -w passwords.txt:PASSWORD_FUZZ -request req_fuzz -request-proto http
	USERNAME_FUZZ and PASSWORD_FUZZ need to be both in the req_fuzz file


## More Information

https://github.com/ffuf/ffuf/wiki
