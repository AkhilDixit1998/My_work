package com.akhil.institutemanagement.batches;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akhil.institutemanagement.dao.batchDAO;

/**
 * Servlet implementation class deleteBatches
 */
@WebServlet("/deleteBatches")
public class deleteBatches extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String batchCode=request.getParameter("batch_code");
		
		
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		PrintWriter out=response.getWriter();
		out.println(request.getParameter("hidden-batch-code"));
		batchDAO b=new batchDAO();
		try {
			connection=b.myConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query="delete from batches where batchCode=?";
				try {
					pstmt=connection.prepareStatement(query);
					pstmt.setString(1, batchCode);
					
				int i=	pstmt.executeUpdate();
				
				if(i>0)
				{
					
				}
				System.out.println("In print "+i);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		
	}

}
