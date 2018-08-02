package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrResp extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		String msg = (String)req.getAttribute("ErrMsg");
		/*resp.setContentType("text/html");
		PrintWriter out1 = resp.getWriter();*/
		out.print(msg);
		RequestDispatcher dispatcher = req.getRequestDispatcher("UserLogin.html");
		dispatcher.include(req, resp);
	}
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}*/
	}

