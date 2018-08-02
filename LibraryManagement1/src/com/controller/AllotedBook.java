package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.JDBCLib;
import com.userBeans.LibraryBeans;

public class AllotedBook extends HttpServlet
{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws IOException,ServletException 
	{
		HttpSession session = req.getSession(false);
		if (session != null)
		{
		
		System.out.println("calling the model to get data");
		JDBCLib database=new JDBCLib();
		List<LibraryBeans>list=database.allotedbook();
		
		System.out.println("forward the request to the Allotedbook page");
		req.setAttribute("data", list);
		RequestDispatcher rd=req.getRequestDispatcher("BookAlloted.jsp");
		rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("ErrMsg", "invalid session");
			RequestDispatcher rd1 = req.getRequestDispatcher("errresplib");
			rd1.forward(req, resp);
		}
	}
}
