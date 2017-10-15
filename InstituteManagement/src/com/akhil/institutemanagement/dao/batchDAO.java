package com.akhil.institutemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.akhil.institutemanagement.common.driverDetails;
import com.akhil.institutemanagement.dto.BatchDTO;

public class batchDAO {

	public Connection myConnection() throws ClassNotFoundException, SQLException
	{
		
		

		String driverName=driverDetails.driverName;
		String dbURL=driverDetails.dbURL;
		String userId=driverDetails.userId;
		String password=driverDetails.password;
		Class.forName(driverName);
		Connection connection=DriverManager.getConnection(dbURL, userId, password);
		
		return connection;
	}
	
	
	public ArrayList<BatchDTO> getBatches() throws SQLException, ClassNotFoundException
	{
		Connection connection=null;
		String query="select * from batches;";
		connection=myConnection();
		Statement st=connection.prepareStatement(query);
		ResultSet rs= st.executeQuery(query);
		
		ArrayList<BatchDTO> arr=new ArrayList<>();
		while(rs.next()){
			BatchDTO batchDTO=new BatchDTO();
			batchDTO.setBatchName(rs.getString(1));
			batchDTO.setInstructorName(rs.getString(2));
			batchDTO.setBatchTimingsFrom(rs.getString(3));
			batchDTO.setBatchTimingsTo(rs.getString(4));
			batchDTO.setBatchDays(rs.getString(5));
			batchDTO.setNumberOfStudents(rs.getString(6));
			batchDTO.setBatchPerformance(rs.getString(7));
			batchDTO.setBatchCode(rs.getString(8));
			
			
			arr.add(batchDTO);
		}
		
		return arr;
		//System.out.println("arraylist is "+arr+"Lenght is "+arr.size());
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		batchDAO b=new batchDAO();
		b.getBatches();
		
	}
	
	
	
	
}
