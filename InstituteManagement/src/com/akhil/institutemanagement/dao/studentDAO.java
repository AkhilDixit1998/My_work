package com.akhil.institutemanagement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.akhil.institutemanagement.common.connectionSql;
import com.akhil.institutemanagement.dto.studentDTO;

public class studentDAO {

	
	Connection connection=null;
	int count=0;
	
	public  ArrayList<studentDTO> getAllStudents() throws ClassNotFoundException, SQLException
	{
		ArrayList<studentDTO> arrayList =new ArrayList<>();
		
		connection=connectionSql.myConnection();
		
		String sql="select * from students;";
		Statement st=connection.createStatement();
		
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			studentDTO dto=new studentDTO();
			dto.setBatchCode(rs.getString(1));
			dto.setStudentName(rs.getString(2));
			dto.setFeesGiven(rs.getString(3));
			arrayList.add(dto);
			count++;
		}
		System.out.println("counter is "+count);
		System.out.println("Arraylist is "+arrayList);
		
		
		return arrayList;
		
		
	}
}
