package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.JDBCLib;
import com.userBeans.LibraryBeans;


public class BookTaken extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		if (session != null) {
			String userId = req.getParameter("userid");
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			
			JDBCLib database=new JDBCLib();
			List<LibraryBeans> list=database.taken(Integer.parseInt(userId));
			
			RequestDispatcher rd1=req.getRequestDispatcher("UserHeader1.jsp");
			  rd1.include(req, resp);
			
			if (list != null) {
				out.print("<html>"
						+ "<body>"
						+"<link rel=\"stylesheet\" type=\"text/css\" href=\"userstyle.css\"/>"
						+"<br/>"
						+ "<h2 align=\"center\" ><b><u><i><font color=\"red\">No Of Books Taken</h2>"
						+"<center>"
						+"<div id=\"updatepass\">"
						+ "<table align=\"center\" cellpadding=\"10\" width=\"60%\">"
						+ "<tr>"
						+ "<td><font size=4px color=\"#571B7E\"><b><i>BookName</td>"
						+ "<td><font size=4px color=\"#571B7E\"><b><i>BookTakenDate</td>"
						+ "<td><font size=4px color=\"#571B7E\"><b><i>BookReturnDate</td></tr>");
						
				for (LibraryBeans bean : list)
					out.print("<tr>"
							+ "<td>"+bean.getBookName()+"</td><td>"+bean.getBook_taken_date()+"</td><td>"
							+bean.getBook_return_date()+"</td>"
									+ "</tr>");
				//out.print("</table>");
			}
		} else {
			req.setAttribute("ErrMsg", "Session Invalid");
			RequestDispatcher dispatcher = req.getRequestDispatcher("errresp");
			dispatcher.forward(req, resp);
		}
	}
}
