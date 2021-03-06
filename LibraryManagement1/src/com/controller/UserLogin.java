package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.JDBCUser;
import com.userBeans.LibraryBeans;

public class UserLogin extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		
		String uid=req.getParameter("uid");
		String pass=req.getParameter("pass");
		
		PrintWriter out=resp.getWriter();
		
		System.out.println("calling the model to get data");
		JDBCUser database=new JDBCUser();
		LibraryBeans student=database.login(Integer.parseInt(uid), pass);
		
		if (student != null)
		{
			HttpSession session = req.getSession(true);
			
			
			
		System.out.println("forward the request to the home page");
		req.setAttribute("data", student);
		RequestDispatcher rd=req.getRequestDispatcher("homepage");
		rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("ErrMsg", "<br/><font color=\"red\"><h2 align=\"center\">Invalid usr name or password");
			RequestDispatcher rd1 = req.getRequestDispatcher("errresp");
			rd1.forward(req, resp);
		}
		
		
	}
}
