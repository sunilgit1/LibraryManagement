package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends HttpServlet
{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws IOException,ServletException 
	{
		System.out.println("in lgout page");
		HttpSession session=req.getSession(false);
		
		if(session!=null)
		{
			session.invalidate();
			/*req.setAttribute("ErrMsg", "Logout successful");
			RequestDispatcher dispatcher = req.getRequestDispatcher("errresp");
			dispatcher.forward(req, resp);*/
		}
		resp.sendRedirect("index.jsp");
		
	}
}
