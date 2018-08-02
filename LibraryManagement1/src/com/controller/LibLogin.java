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
import com.userBeans.LibraryBeans;

public class LibLogin extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();
		
		String lid=req.getParameter("lid");
		String pass=req.getParameter("pass");
		
		JDBCLib database=new JDBCLib();
		LibraryBeans student=database.login(Integer.parseInt(lid), pass);
		
		if(student!=null)
		{
			HttpSession session=req.getSession(true);
			
			System.out.println("forward the request to the home page");
			req.setAttribute("data", student);
			RequestDispatcher rd=req.getRequestDispatcher("LibHeader.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("ErrMsg", "<br/><font color=\"red\"><h2 align=\"center\">Invalid usr name or password");
			RequestDispatcher rd1 = req.getRequestDispatcher("errresplib");
			rd1.forward(req, resp);
		}
	}
}
