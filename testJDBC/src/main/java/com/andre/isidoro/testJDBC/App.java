package com.andre.isidoro.testJDBC;

import com.andre.isidoro.testJDBC.connections.Connection;
import com.andre.isidoro.testJDBC.connections.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{

	
    public static void main( String[] args )
    {
    	int i = 0;
    	
    	if(args.length != 5) {
    		System.out.println("---- 5 args are required ----");
    		System.out.println("---- user pass connectionType dbAddress dbPort dbName ----");
    		System.out.println("Possble connection types:");
    		System.out.println("/tmysql");
    		System.out.println("connectionType://dbAddress:dbPort/dbName?useSSL=false&serverTimezoneUTC&allowPublicKeyRetrieval=true");
    		
    	}
    	String user = args[i++];
    	String pass = args[i++];
    	String connectionName = args[i++];
        String dbAddress = args[i++];
        String dbPort = args[i++];
        String dbName = args[i++];
        
        
        System.out.println("user =" + user);
        System.out.println("pass =" + pass);
        System.out.println("connectionName =" + connectionName);
        System.out.println("dbAddress =" + dbAddress);
        System.out.println("dbPort =" + dbPort);
        System.out.println("dbName =" + dbName);
        
        Connection connection = ConnectionFactory.makeConnection(connectionName, dbAddress, dbPort, dbName);
        connection.connect(user, pass);
    }
}
