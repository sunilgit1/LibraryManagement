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

public class AddBook extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		 RequestDispatcher rd=req.getRequestDispatcher("LibHeader.jsp");
		  rd.include(req, resp);
		
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession(false);
		if(session!=null)
		{			
		
		String bid=req.getParameter("bid");
		String bname=req.getParameter("bname");
		String bauthor=req.getParameter("bauthor");
		String edition=req.getParameter("edition");
		String nbook=req.getParameter("nbook");
		String section=req.getParameter("section");
		
		LibraryBeans bean=new LibraryBeans();
		bean.setBookid(Integer.parseInt(bid));
		bean.setBookName(bname);
		bean.setBookAuthor(bauthor);
		bean.setEdition(Integer.parseInt(edition));
		bean.setnOfBooks(Integer.parseInt(nbook));
		bean.setSection(section);
		
		System.out.println("get the data to the model");
		JDBCLib database=new JDBCLib();
		int count=database.addbook(bean);
		
		if(count==1)
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">New Book Added</h2>");
		}
		else
		{
			out.print("<br/><font color=\"red\"><h2 align=\"center\">Book Cant Added</h2>");
		}
		}
		else
		{
			req.setAttribute("ErrMsg", "invalid session");
			RequestDispatcher rd1 = req.getRequestDispatcher("errresplib");
			rd1.forward(req, resp);
		}
		
		
	}
}
