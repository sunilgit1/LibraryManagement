package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogOut extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			session.invalidate();
			/*req.setAttribute("ErrMsg", "Logout successful");
			RequestDispatcher dispatcher = req.getRequestDispatcher("ErrResp");
			dispatcher.forward(req, resp);*/
			
		}
		resp.sendRedirect("index.jsp");
	}
}
