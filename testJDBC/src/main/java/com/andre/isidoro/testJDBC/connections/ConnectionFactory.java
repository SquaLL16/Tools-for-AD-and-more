package com.andre.isidoro.testJDBC.connections;

import com.andre.isidoro.testJDBC.connections.MysqlConnection.MysqlConnectionBuilder;

public class ConnectionFactory {

	
	public static Connection makeConnection(String connectionName, String dbAddress, String dbPort,  String dbName) {
	//	if(ConnectionTypes.MYSQL.getConnectionTypeName().equals(connectionName)) {
		
			return new MysqlConnectionBuilder(dbName).dbAddress(dbAddress).dbPort(dbPort).createMysqlConnection();
	//	}
	}
}
