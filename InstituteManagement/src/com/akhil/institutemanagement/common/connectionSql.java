package com.akhil.institutemanagement.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectionSql {

	
	static public Connection myConnection() throws SQLException ,ClassNotFoundException
	{
		
		String driverName=driverDetails.driverName;
		String dbURL=driverDetails.dbURL;
		String userId=driverDetails.userId;
		String password=driverDetails.password;
		Class.forName(driverName);
		Connection connection=DriverManager.getConnection(dbURL, userId, password);
		return connection;
	}
	
}
