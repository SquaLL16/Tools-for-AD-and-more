# Proxychains

## Overview

One very useful tool in Linux is proxychains, which routes all traffic coming from any command-line tool to any proxy we specify. Proxychains adds a proxy to any command-line tool and is hence the simplest and easiest method to route web traffic of command-line tools through our web proxies.

To use proxychains, we first have to edit /etc/proxychains.conf, comment out the final line and add the following line at the end of it:

	#socks4         127.0.0.1 9050 # comments default proxy
	http 127.0.0.1 8080 # adds our own proxy, like Burp or ZAP

We should also enable Quiet Mode to reduce noise by un-commenting quiet_mode. Once that's done, we can prepend proxychains to any command, and the traffic of that command should be routed through proxychains (i.e., our web proxy). For example, let's try using cURL

	proxychains curl http://SERVER_IP:PORT

This will send the curl traffic to the proxy we defined in the .conf file, for example, if that proxy was zap, it would now capture the traffic from the curl command