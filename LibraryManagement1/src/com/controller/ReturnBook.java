package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JButton;

import com.model.JDBCLib;
import com.userBeans.LibraryBeans;

public class ReturnBook extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		RequestDispatcher rd=req.getRequestDispatcher("LibHeader.jsp");
		  rd.include(req, resp);
		
		PrintWriter out=resp.getWriter();
		HttpSession session = req.getSession(false);
		if (session != null) {
			
		
		String uid=req.getParameter("uid");
		String bid=req.getParameter("bid");
		String rdate=req.getParameter("rdate");
		
		LibraryBeans bean=new LibraryBeans();
		
		bean.setUid(Integer.parseInt(uid));
		bean.setBookid(Integer.parseInt(bid));
		bean.setBook_return_date(rdate);
		
		System.out.println("get the data to the model");
		JDBCLib database=new JDBCLib();
		int count=database.returnbook(bean);
		
		if(count==1)
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">Book Returned</h2>");
		}
		else 
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">Book Not Taken</h2>");
		}
	
		} 
		else 
		{
			req.setAttribute("ErrMsg", "Session Invalid");
			RequestDispatcher dispatcher = req.getRequestDispatcher("errresplib");
			dispatcher.forward(req, resp);
}
}
}

