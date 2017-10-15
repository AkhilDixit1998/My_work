package mvc_style.studentRecords;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akhil.institutemanagement.dao.studentDAO;
import com.akhil.institutemanagement.dto.studentDTO;

/**
 * Servlet implementation class editStudent
 */
@WebServlet("/editStudent")
public class editStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("helllo edit");
		
		
		ArrayList<studentDTO> arr=new ArrayList<>();
		studentDAO dao=new studentDAO();
		try {
			arr=dao.getAllStudents();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		request.setAttribute("studentArrayList", arr);
		RequestDispatcher rd=request.getRequestDispatcher("editStudent.jsp");
		rd.forward(request, response);
		
	}



}
