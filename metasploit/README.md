# Metasploit

## Overview

## Installation

	sudo apt update
	sudo apt install metasploit-framework

## Commands

	msfconsole : starts metasploit framework console

	back : move back in context. Unuses a module.
	unset <variable> : returns variable to default value
	use <module_index> : loads module to execute

Module Commands

	options: Show module options ands vars
	set <var> <value>: set a value to a specific value


## Use Guide

Usually you want to set the RHOST and LHOST options in the exploits

## Cookbook

Show post modules

	show post
	grep <pattern> show post

Run post module

	The exploit needs to be started in a session (use background in meterpreter or ctr+z in a normal shell)
	use <path_to_post>
	run session=<id_of_session_running_exploit>

Search exploits for specific version

	search <exploit> <version>
	example: search sudo 1.8.31

Open shell from meterpreter

	shell

Run Local Exploit Suggester

	This requires a session with a connection already established
	search local_exploit_suggester
	use <id_of_exploit>
	set <session_id_with_connection>
	run