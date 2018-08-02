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

public class AddUser extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		 RequestDispatcher rd=req.getRequestDispatcher("AdminHeader.jsp");
		  rd.include(req, resp);
		
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
		
		String uid=req.getParameter("uid");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String gmail=req.getParameter("gmail");
		String pass=req.getParameter("pass");
		
		System.out.println("get the data to the model");
		LibraryBeans bean=new LibraryBeans();
		bean.setUid(Integer.parseInt(uid));
		bean.setFname(fname);
		bean.setLname(lname);
		bean.setGmail(gmail);
		bean.setPassword(pass);
		
		JDBCUser database=new JDBCUser();
		int count=database.adduser(bean);
		
		if(count==1)
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">New User Added</h2>");
		}
		else
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">User Can't Added</h2>");
		}
		
		}
		else
		{
			req.setAttribute("ErrMsg", "invalid session");
			RequestDispatcher rd1 = req.getRequestDispatcher("errrespadmin");
			rd1.forward(req, resp);
		}
	}
}
