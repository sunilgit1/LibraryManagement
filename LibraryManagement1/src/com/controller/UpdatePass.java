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

public class UpdatePass extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession session=req.getSession(false);
				
		if(session!=null)
		{
			PrintWriter out=resp.getWriter();
			
			String uid=req.getParameter("uid");
			String cpass=req.getParameter("cpass");
			String npass=req.getParameter("npass");
			String rpass=req.getParameter("rpass");
			
			 RequestDispatcher rd1=req.getRequestDispatcher("UserHeader1.jsp");
			  rd1.include(req, resp);
			
			if(npass.equals(rpass))
			{
				JDBCUser database=new JDBCUser();
				int count=database.updatapass(Integer.parseInt(uid), cpass, npass, rpass);
				
				if(count>0)
				{
					out.print("<br/><font color=\"red\"><h2 align=\"center\">password updated</h2>");
				}
				else
				{
					out.print("<br/><font color=\"red\"><h2 align=\"center\">password not updated</h2>");
				}
			}
			else
			{
				resp.sendError(405, "password not matching");
			}
		}
		else
		{
			req.setAttribute("ErrMsg", "invalid session");
			RequestDispatcher rd1 = req.getRequestDispatcher("errresp");
			rd1.forward(req, resp);
						
		}
	}
}
