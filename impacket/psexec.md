# psexec

## Overview

PsExec is a powerful command-line tool from Microsoft's Sysinternals suite that allows administrators to remotely execute commands on Windows machines. It operates over the network by leveraging Windows Admin Shares and the SMB (Server Message Block) protocol.

## Usage

```shell
psexec.py '[admin_username]:[password]'@[target_ip]

impacket-psexec '<username>@<target_ip>' -hashes <lm_hash>:<nt_hash>
```