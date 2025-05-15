Test JDBC Connection Tool
====================

This tools connectes to a database using a jdbc driver;


## Build and Run

Build with maven;

Run with jar-with-dependencies. For example

	java -jar testJDBC-0.0.1-SNAPSHOT-jar-with-dependencies.jar [ARGS]
	
	
## Args

5 args are required:
	user pass connectionType dbAddress dbPort dbName
	
	connectionType://dbAddress:dbPort/dbName?useSSL=false&serverTimezoneUTC&allowPublicKeyRetrieval=true
	
## Supported Database Servers:
	mysql
	
## Help:
	Run
		java -jar testJDBC-0.0.1-SNAPSHOT-jar-with-dependencies.jar