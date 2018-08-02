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


public class LogInHtml extends HttpServlet
{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uid=req.getParameter("uid");
		String pass=req.getParameter("pass");
		
		PrintWriter out=resp.getWriter();
		
		System.out.println("calling the model to get data");
		JDBCUser database=new JDBCUser();
		LibraryBeans student=database.login(Integer.parseInt(uid), pass);
		
		System.out.println(student.getUid());
		String url = null;
		if (student != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("UserInfo", student);
			if (student.getType().equals("U")) 
				url= "homepage";
			else if (student.getType().equals("L")) 
				url = "LibHeader.jsp";
			else if (student.getType().equals("A")) 
				url = "AdminHeader.jsp";
			
		System.out.println("forward the request to the home page");
		//req.setAttribute("data", student);
		RequestDispatcher rd=req.getRequestDispatcher(url);
		rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("ErrMsg", "Invalid usr name or password");
			RequestDispatcher rd1 = req.getRequestDispatcher("errresp");
			rd1.forward(req, resp);
		}
		
		
	}
}
