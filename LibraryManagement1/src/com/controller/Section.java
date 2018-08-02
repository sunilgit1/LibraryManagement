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

import com.model.JDBCUser;
import com.userBeans.LibraryBeans;



public class Section extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		//PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			String section=req.getParameter("section");
			
			JDBCUser database=new JDBCUser();
			List<LibraryBeans> list=database.section(section);
			
			/*req.setAttribute("data", list);
			RequestDispatcher rd=req.getRequestDispatcher("Section.jsp");
			rd.forward(req, resp);*/
			
			out.print("<br><h2 align='center'><b><u><i><font color='red'>Section " + section + "</h2>");
						
			out.print( "<center><table align='center' border='1px' cellpadding='10px' width='50%'>"
					+ "				<tr>" + "<th ><font size='4px' color='#571B7E'><b><i>Book ID</th>"
					+ "					<th ><font size='4px' color='#571B7E'><b><i>Book Name</th>"
					+ "					<th ><font size='4px' color='#571B7E'><b><i>Book Author</th>"
					+ "					<th ><font size='4px' color='#571B7E'><b><i>Edition</th>"
					+ "					<th ><font size='4px' color='#571B7E'><b><i>No. of Books</th>" + "				</tr>");

			if (list != null) {
				for (LibraryBeans bean : list) {
					out.print("				<tr>" + "					<td>" + bean.getBookid() + "</td>"
							+ "					<td>" + bean.getBookName() + "</td>" + "					<td>"
							+ bean.getBookAuthor() + "</td>" + "					<td>" + bean.getEdition() + "</td>"
							+ "					<td>" + bean.getnOfBooks() + "</td>" + "				</tr>");

				}
			}
			out.print("</table> </fieldset>");
			
			
		
	}
}
}
