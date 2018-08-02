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
import com.model.JDBCUser;
import com.userBeans.LibraryBeans;

public class SearchBook extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			PrintWriter out=resp.getWriter();
			
		 String bsearch=req.getParameter("bsearch");
		
		 System.out.println("calling the model to get data");
		 JDBCUser database=new JDBCUser();
		  LibraryBeans student=database.searchbook(bsearch);
		
		  RequestDispatcher rd1=req.getRequestDispatcher("UserHeader1.jsp");
		  rd1.include(req, resp);
		  
		if(student!=null)
		{
			
			out.print("<html>"
					+ "<body>"
					+"<link rel=\"stylesheet\" type=\"text/css\" href=\"userstyle.css\"/>"
					+"<br/>"
					+ "<h2 align=\"center\" ><b><u><i><font color=\"red\">Detail Of Books</h2>"
					+"<center>"
					+"<div id=\"updatepass\">"
					+ "<table align=\"center\" cellpadding=\"10\" width=\"60%\">"
					+ "<tr>"
					+ "<td><font size=4px color=\"#571B7E\"><b><i>BookId</td>"
					+ "<td><font size=4px color=\"#571B7E\"><b><i>BookName</td>"
					+ "<td><font size=4px color=\"#571B7E\"><b><i>BookAuthor</td>"
					+ "<td><font size=4px color=\"#571B7E\"><b><i>NoOfBooks</td>"
					+ "<td><font size=4px color=\"#571B7E\"><b><i>Section</td>"
					+"<tr><td>"+student.getBookid()+"</td><td>"+student.getBookName()+"</td><td>"
					+student.getBookAuthor()+"</td><td>"+student.getnOfBooks()+"</td><td>"+student.getSection()+"</td></tr>"
					+"</table>"
					+"</body>"
					+"</html>");
		
		
		}
		else
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">Sorry....<br/> Book not found</h2>");
		}
		
		/*req.setAttribute("data", student);
		RequestDispatcher rd=req.getRequestDispatcher("SearchBook.jsp");
		rd.forward(req, resp);*/
		}
		else
		{
			req.setAttribute("ErrMsg", "invalid session");
			RequestDispatcher rd1 = req.getRequestDispatcher("errresp");
			rd1.forward(req, resp);
		}
	}
}

