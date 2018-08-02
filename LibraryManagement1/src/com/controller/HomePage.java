package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.JDBCLib;
import com.model.JDBCUser;
import com.userBeans.LibraryBeans;


public class HomePage extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		if (session != null) {
			LibraryBeans bean = (LibraryBeans) req.getAttribute("data");

			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");

			RequestDispatcher dispatcher = req.getRequestDispatcher("UserHeader1.jsp");
			dispatcher.include(req, resp);
			
			JDBCLib datatabse=new JDBCLib();
			int count= datatabse.alloted("" + bean.getUid());
			
			out.print("<html>"
					+ "<head>"
					+"<title>"
					+ "</title>"
					+"<link rel=\"stylesheet\" type=\"text/css\" href=\"userstyle.css\"/>"
					+ "</head>"
					+ "<body>"
					+"<div id=\"section\">"
			       +" 	<h2><u>Home Page</u></h2>"
					+ "				<table>" + "				<tr>"
					+ "					<td><h4><u>No Of Books Taken</u></h4></td>"
					+ "					<td><a href='taken?userid=" + bean.getUid()+ "'>" + count
					+ "</a></td></table>" 
					+ "					<h3>Sections :-></h3>"
					
					+ "			<div id=\"menu1\">\r\n" + 
					"	<ul>\r\n" + 
					"		<li><a href='Section?section=CS'><b>Computer Science</a></li>\r\n" + 
					"		<li><a href='Section?section=EE'>Electrical Engg</a></li>\r\n" + 
					"		<li><a href='Section?section=ME'>Mechanical Engg</a></li>\r\n" + 
					"		<li><a href='Section?section=CE'>Civil Engg</a></li>\r\n" + 
					"		<li><a href='Section?section=IT'>Information Tech</a></li>\r\n" + 
					"\r\n" + 
					"	</ul>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"</div>"
					+ "</body>"
					+ "</html>");
					
			
			
		
	} else {
		req.setAttribute("ErrMsg", "Session Invalid");
		RequestDispatcher dispatcher = req.getRequestDispatcher("errresp");
		dispatcher.forward(req, resp);
	}
		RequestDispatcher dispatcher1 = req.getRequestDispatcher("footer.jsp");
		dispatcher1.include(req, resp);
		
			
	}
}
