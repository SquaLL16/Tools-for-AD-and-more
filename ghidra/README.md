# ghidra

## Overview

Ghidra is a software reverse engineering (SRE) framework created and maintained by the National Security Agency Research Directorate. This framework includes a suite of full-featured, high-end software analysis tools that enable users to analyze compiled code on a variety of platforms including Windows, macOS, and Linux. Capabilities include disassembly, assembly, decompilation, graphing, and scripting, along with hundreds of other features. Ghidra supports a wide variety of processor instruction sets and executable formats and can be run in both user-interactive and automated modes. Users may also develop their own Ghidra extension components and/or scripts using Java or Python.

https://github.com/NationalSecurityAgency/ghidra

## Usage

To start analysing a file, create a new project, then import the file you want to reverse and finally click on the green dragon (code browser).
In the code browser open the file again.

## Scripting

Ghidra has a few options when it comes to extending functionality with custom scripts. Ghidra is written in Java and can be extended by writing Java code that will be loaded directly into the running process or, you can alternatively use a Jython interface to author scripts in Python. Beyond that, Ghidra also has multiple APIs to choose from. For the purpose of this post, we will craft a basic Python Ghidra script.

### Scan for dangerous functions

https://medium.com/@cy1337/vulnerability-analysis-with-ghidra-scripting-ccf416cfa56d
https://secur3.us/GhidraFiles/danger_check.py
