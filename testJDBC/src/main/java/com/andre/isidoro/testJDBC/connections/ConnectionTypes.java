package com.andre.isidoro.testJDBC.connections;

public enum ConnectionTypes {
	MYSQL("mysql");
	
	private String connectionTypeName;
	
	private ConnectionTypes(String connectionTypeName) {
		this.connectionTypeName = connectionTypeName;
	}

	public final String getConnectionTypeName() {
		return connectionTypeName;
	}

	public void setConnectionTypeName(String connectionTypeName) {
		this.connectionTypeName = connectionTypeName;
	}	
}
