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
import com.model.JDBCLib;
import com.userBeans.LibraryBeans;

public class CreateLib extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
		
		String lid=req.getParameter("lid");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String gmail=req.getParameter("gmail");
		String pass=req.getParameter("pass");
		
		LibraryBeans bean=new LibraryBeans();
		bean.setLid(Integer.parseInt(lid));
		bean.setFname(fname);
		bean.setLname(lname);
		bean.setGmail(gmail);
		bean.setPassword(pass);
		
		JDBCLib database=new JDBCLib();
		int count=database.createLib(bean);
		
		if(count==1)
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">Successfully Created Profile</h2>");
		}
		else
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">Profile Not Created</h2>");
		}
		
		}
		else
		{
			req.setAttribute("ErrMsg", "invalid session");
			RequestDispatcher rd1 = req.getRequestDispatcher("errresplib");
			rd1.forward(req, resp);
		}
		
		
		
		
		
	}
}
