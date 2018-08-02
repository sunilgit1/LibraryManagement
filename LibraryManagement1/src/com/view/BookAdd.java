package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userBeans.LibraryBeans;

public class BookAdd extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		System.out.println("view page got the massage");
		LibraryBeans student=(LibraryBeans)req.getAttribute("data");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		if(student!= null)
		{
			String htmlrsp="<html"
					+"<body>"
					+"<font color=\"red\" size=\"5px\">"
					+"<h3 align =\"center\">Book Added</h3>"
					+"</font>"
					+"</body>"
					+"</html>";

			
			out.print(htmlrsp);
		}
		else
		{
			String htmlrsp1="<html"
					+"<body>"
					+"<font color=\"red\" size=\"5px\">"
					+"<h3 align =\"center\">Book not Added</h3>"
					+"</font>"
					+"</body>"
					+"</html>";

			
			out.print(htmlrsp1);
		}
	}
}
