package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.JDBCAdmin;
import com.userBeans.LibraryBeans;

public class ViewUser extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			JDBCAdmin database=new JDBCAdmin();
			List<LibraryBeans> list=database.viewuser();
			
			RequestDispatcher rd=req.getRequestDispatcher("ViewUser.jsp");
			req.setAttribute("data", list);
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("ErrMsg", "invalid session");
			RequestDispatcher rd1 = req.getRequestDispatcher("errresp");
			rd1.forward(req, resp);
		}
	}
}
