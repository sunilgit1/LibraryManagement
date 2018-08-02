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

public class AllotBook extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		HttpSession session = req.getSession(false);
		if (session != null)
		{
			
			 RequestDispatcher rd=req.getRequestDispatcher("LibHeader.jsp");
			  rd.include(req, resp);
		
		String uid=req.getParameter("uid");
		String bookid=req.getParameter("bookid");
		String takendate=req.getParameter("takendate");
			
			LibraryBeans bean=new LibraryBeans();
			bean.setUid(Integer.parseInt(uid));
			bean.setBookid(Integer.parseInt(bookid));
			bean.setBook_taken_date(takendate);
		
		 System.out.println("calling the model to get data");
		
		JDBCLib databse=new JDBCLib();
		int count =databse.allotbook(bean);
		System.out.println(count);
		if(count==1)
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">New Book Added</h2>");
		}
		else if (count==0)
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">Already Taken This Book</h2>");
		}
		
		else
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">No Books Remaining Come Back Later</h2>");
		}
		
		/*System.out.println("forward the request to the search bookaloot page");
		req.setAttribute("data", student);
		RequestDispatcher rd=req.getRequestDispatcher("/bookallotview");
		rd.forward(req, resp);*/
		}
		else
		{
			req.setAttribute("ErrMsg", "invalid session");
			RequestDispatcher rd1 = req.getRequestDispatcher("errresplib");
			rd1.forward(req, resp);
		}
	}
}
