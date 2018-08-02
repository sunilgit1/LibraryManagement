package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogOut extends HttpServlet
{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws IOException,ServletException 
	{
		System.out.println("in lgout page");
		HttpSession session=req.getSession(false);
		
		if(session!=null)
		{
			session.invalidate();
		}
		resp.sendRedirect("index.jsp");
	}
}
