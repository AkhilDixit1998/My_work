package com.akhil.institutemanagement.batches;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akhil.institutemanagement.sql.AddBatchesSQL;

/**
 * Servlet implementation class addBatchesServlet
 */
@WebServlet("/addBatchesServlet")
public class addBatchesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String batchName=request.getParameter("batch_name");
		String instructorName=request.getParameter("instructor_name");
		String batchTimingsFrom=request.getParameter("batch_timings_from");
		String batchTimingsTo =request.getParameter("batch_timings_to");
		String batchDays=request.getParameter("batchDays");
		String batchCode=request.getParameter("batch_code");
		
		
		
		
		PrintWriter out=response.getWriter();
		out.println("BAtch name "+batchName+" instructor name "+instructorName+" batchtimings "+batchTimingsFrom+" batch to "+batchTimingsTo+" batc days "+batchDays);
		
		Statement statement;
		try {
			AddBatchesSQL.myConnection(batchName,instructorName,batchTimingsFrom,batchTimingsTo,batchDays,batchCode);
		
			System.out.println("succesful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
