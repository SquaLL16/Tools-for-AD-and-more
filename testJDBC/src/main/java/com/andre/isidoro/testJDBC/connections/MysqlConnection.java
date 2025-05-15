package com.andre.isidoro.testJDBC.connections;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection implements com.andre.isidoro.testJDBC.connections.Connection{
	
	private static final String URL="jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezoneUTC&allowPublicKeyRetrieval=true";
	
	private String dbAddress = "localhost";
	private String dbName = "";
	private String dbPort = "3306";
	
	private MysqlConnection(String dbAddress, String dbName, String dbPort) {
		this.dbAddress = dbAddress;
		this.dbName = dbName;
		this.dbPort = dbPort;
	}

	public static class  MysqlConnectionBuilder{
		private String nestedDBName;
		private String nestedDBAddress;
		private String nestedDBPort;
		
		public MysqlConnectionBuilder(String dbName) {
			this.nestedDBName = dbName;
		}
		
		public MysqlConnectionBuilder dbName(String dbName) {
			this.nestedDBName = dbName;
			return this;
		}
		
		public MysqlConnectionBuilder dbPort(String dbPort) {
			this.nestedDBPort = dbPort;
			return this;
		}
		
		public MysqlConnectionBuilder dbAddress(String dbAddress) {
			this.nestedDBAddress = dbAddress;
			return this;
		}
		
		public MysqlConnection createMysqlConnection() {
			return new MysqlConnection(nestedDBAddress, nestedDBName , nestedDBPort);
		}
	}
	
	@Override
	public void connect(String user, String pass) {
		String connectionURL = String.format(URL, dbAddress , dbPort , dbName);
		System.out.println("Connecting to " + connectionURL);
		try {
			DriverManager.getConnection(connectionURL , user , pass);
		}catch(SQLException e) {
			System.out.println("Failed to connect to " + connectionURL);
			System.out.println( e);
			return;
		}
		System.out.println("Connected");
	}

	
	
}
