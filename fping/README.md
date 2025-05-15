# fping

## Overview

fping is a command-line tool used for pinging multiple hosts simultaneously in a network. Unlike the traditional ping command, which pings a single host at a time, fping can be used to send ICMP Echo Request packets (ping) to multiple hosts at once, making it ideal for network scanning, monitoring, or simply testing the reachability of multiple systems.

Where fping shines is in its ability to issue ICMP packets against a list of multiple hosts at once and its scriptability. Also, it works in a round-robin fashion, querying hosts in a cyclical manner instead of waiting for multiple requests to a single host to return before moving on. These checks will help us determine if anything else is active on the internal network.

## Options

    -a: Show targets that are alive
    -s: Print stats at the end of the scan
    -g: Generate target list from the CIDR network
    -q: Show per-target results.

## Usage

Basic command

    fping -asgq 172.16.5.0/23 | tee live_hosts

