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
import com.userBeans.LibraryBeans;

public class AdminLogin extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();
		
		String aid=req.getParameter("aid");
		String pass=req.getParameter("pass");
		
		System.out.println("calling the model to get data");
			JDBCAdmin database=new JDBCAdmin();
			LibraryBeans student=database.adminlogin(Integer.parseInt(aid), pass);
			
			
			if(student!=null)
			{
			
				HttpSession session=req.getSession(true);
				
			System.out.println("forward the request to the home page");
			RequestDispatcher rd=req.getRequestDispatcher("AdminHeader.jsp");
			req.setAttribute("data", student);
			rd.forward(req, resp);
		}
		else
		{
			
			req.setAttribute("ErrMsg", "<br/><font color=\"red\"><h2 align=\"center\">Invalid usr name or password");
			RequestDispatcher rd1 = req.getRequestDispatcher("errrespadmin");
			rd1.forward(req, resp);
		}
	}
}
