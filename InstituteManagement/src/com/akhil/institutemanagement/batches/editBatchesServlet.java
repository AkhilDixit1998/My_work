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
 * Servlet implementation class editBatchesServlet
 */
@WebServlet("/editBatch")
public class editBatchesServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String batchName=request.getParameter("batch_name");
		String instructorName=request.getParameter("instructor_name");
		String batchTimingsFrom=request.getParameter("batch_timings_from");
		String batchTimingsTo =request.getParameter("batch_timings_to");
		String batchDays=request.getParameter("batchDays");
		String batchCode=request.getParameter("batch_code");
		String numberOfStudents=request.getParameter("student_strength");
		String batchPerformance=request.getParameter("batch_performance");
		
		
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
		
		String query="update batches set batchName=? , instructorName=? , batchFrom=? ,batchTo=? ,days=? ,numberOfStudents=? ,batchPerformance=? ,batchCode=?"
				+ " where batchCode=?";;
				try {
					pstmt=connection.prepareStatement(query);
					pstmt.setString(1, batchName);
					pstmt.setString(2,instructorName);
					pstmt.setString(3, batchTimingsFrom);
					pstmt.setString(4, batchTimingsTo);
					pstmt.setString(5, batchDays);
					pstmt.setString(6, numberOfStudents);
					pstmt.setString(7, batchPerformance);
					pstmt.setString(8, batchCode);
					pstmt.setString(9, batchCode);
					
				int i=	pstmt.executeUpdate();
				System.out.println("In print "+i);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
		
	}

}
