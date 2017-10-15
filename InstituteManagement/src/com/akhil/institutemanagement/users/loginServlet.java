package com.akhil.institutemanagement.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	String userId=request.getParameter("userId");
	String pwd=request.getParameter("pwd");
	
	
	if(userId!=null && pwd!=null &&(userId.trim().length()>0 && pwd.trim().length()>0))
	{
	if(userId.equals(pwd))
	{
		HttpSession session=request.getSession(true);
		out.println("<h1>hello "+userId+" "+pwd+" </h1>");	
		RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}
	}
	else
	{
		response.sendRedirect("login.html");
	}
	
	
	}

}
