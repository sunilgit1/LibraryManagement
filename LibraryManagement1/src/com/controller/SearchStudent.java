package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.JDBCAdmin;
import com.userBeans.LibraryBeans;

//import library.model.dto.LibraryBean;


public class SearchStudent extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		RequestDispatcher rd=req.getRequestDispatcher("AdminHeader.jsp");
		  rd.include(req, resp);
		
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			PrintWriter out=resp.getWriter();
			
		 String fname=req.getParameter("fname");
			
		  System.out.println("calling the model to get data");
		  JDBCAdmin database=new JDBCAdmin();
		  LibraryBeans student=database.search(fname);
			
		  if(student!=null)
			{
		
			  out.print("<html>"
						+"<body>"
						//+"<link rel=\"stylesheet\" type=\"text/css\" href=\"userstyle.css\"/>"
						+"<br/>"
						+ "<h2 align=\"center\" ><b><u><i><font color=\"#F52887\">Detail Of Students</h2></font></u>"
						+"<center>"
						//+"<div id=\"updatepass\">"
						+ "<table align=\"center\" cellpadding=\"10\" width=\"60%\">"
						+"<br/>"
						+ "<tr>"
						+ "<td><font size=4px color=\"#571B7E\"><b><i>UserId</td>"
						+ "<td><font size=4px color=\"#571B7E\"><b><i>FirstName</td>"
						+ "<td><font size=4px color=\"#571B7E\"><b><i>LastName</td>"
						+ "<td><font size=4px color=\"#571B7E\"><b><i>Gmail</td>"
						
						+"<tr><td>"+student.getUid()+"</td><td>"+student.getFname()+"</td><td>"
							+student.getLname()+"</td><td>"+student.getGmail()+"</td></tr>"
						+"</table>"
						+"</body>"
						+"</html>");
			
			
			}
		  else {
			  out.print("<br/><font color=\"red\"><h2 align=\"center\">Sorry....<br/> Student not found</h2>");
			}
				
			/*System.out.println("forward the request to the search Student page");
			req.setAttribute("studentdata", student);
			RequestDispatcher rd1=req.getRequestDispatcher("SearchStudent.jsp");
			rd1.forward(req, resp);*/
		}
		else
		{
			req.setAttribute("ErrMsg", "invalid session");
			RequestDispatcher rd1 = req.getRequestDispatcher("errrespadmin");
			rd1.forward(req, resp);
		}
	}
}
