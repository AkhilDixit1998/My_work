package com.akhil.institutemanagement.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.akhil.institutemanagement.common.driverDetails;

public class EditBatchesSql {
	
	
	static public Connection myConnection(String batchName,String instructorName,String dateFrom,String dateTo,String batchDays,String batchCode) throws SQLException ,ClassNotFoundException
	{
		
		String driverName=driverDetails.driverName;
		String dbURL=driverDetails.dbURL;
		String userId=driverDetails.userId;
		String password=driverDetails.password;
		Class.forName(driverName);
 		String query="insert into batches(batchName,instructorName,batchFrom,batchTo,days,batchCode)"+"values('"+batchName+"','"+instructorName+"','"+dateFrom+"','"+dateTo+"','"+batchDays+"','"+batchCode+"');";
		Connection connection=DriverManager.getConnection(dbURL, userId, password);
		
		Statement statement=connection.createStatement();
		statement.executeUpdate(query);
		
		return connection;
	
	}
}
