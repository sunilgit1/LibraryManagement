package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;
import com.userBeans.LibraryBeans;

public class JDBCLib 
{

	public int allotbook(LibraryBeans bean)
	{
		LibraryBeans student=new LibraryBeans();
		
		try 
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query = " select noofbooks from book_info where bookid=? ";
			PreparedStatement pstmt = con.prepareStatement(query);
			               pstmt.setInt(1, bean.getUid());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				if(rs.getInt(1)>0)
				{
					String query1=" insert into book_allot values(?,?,?,?) ";
					PreparedStatement pstmt1=con.prepareStatement(query);
					pstmt1.setInt(1,bean.getUid());
					pstmt1.setInt(2,bean.getBookid());
					pstmt1.setString(3,bean.getBook_taken_date());
					pstmt1.setString(4, null);
					
					int count= pstmt1.executeUpdate();
					
					if(count==1)
					{
						query = " update book_info set noofbooks=noofbooks-1 where bookid=? ";
						PreparedStatement pstmt2 = con.prepareStatement(query);
						pstmt2.setInt(1, bean.getBookid());
						pstmt2.executeUpdate();
						
						return 1;
					}
					else
					{
						return 0;
					}
				}
				else
				{
					return -1;
				}
			}
			else
			{
				return -1;
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
	
	public int addbook(LibraryBeans bean)
	{
		LibraryBeans student=new LibraryBeans();
		
		
		try
		{
			Driver drf = new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query=" insert into book_info values(?,?,?,?,?,?) ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, bean.getBookid());
			pstmt.setString(2, bean.getBookName());
			pstmt.setString(3, bean.getBookAuthor());
			pstmt.setInt(4, bean.getEdition());
			pstmt.setInt(5, bean.getnOfBooks());
			pstmt.setString(6, bean.getSection());
			return pstmt.executeUpdate();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
		
	}
	
	
	public int returnbook(LibraryBeans bean)
	{
		LibraryBeans student=new LibraryBeans();
		
		
		try
		{
			Driver drf = new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query=" update book_allot set bookreturndate=? "
					+" where uid=? and bookid=? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, bean.getBook_return_date());
			pstmt.setInt(2, bean.getUid());
			pstmt.setInt(3, bean.getBookid());
			
			int count=pstmt.executeUpdate();
			
			if (count == 1) {
				query = "update book_info set noofbooks=noofbooks+1 where bookid=?;";
				PreparedStatement stmt1 = con.prepareStatement(query);
				stmt1.setInt(1, bean.getBookid());
				stmt1.executeUpdate();
				return count;
			} else {
				return 0;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
		
	}
	
	public List<LibraryBeans> allotedbook()
	{
		List<LibraryBeans> list=new ArrayList<LibraryBeans>();
		
		try {
			 
			Driver drf = new Driver(); 
			DriverManager.registerDriver(drf);
			
			String dburl="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			
			String query="select * from book_allot ";
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next())
			{	
				LibraryBeans s=new LibraryBeans();
				
				 s.setUid(rs.getInt("uid"));
				 s.setBookid(rs.getInt("bookid"));
				 s.setBook_taken_date(rs.getString("booktakendate"));
				 s.setBook_return_date(rs.getString("bookreturndate"));
				
				list.add(s);
				//System.out.println(s);
				 
				 
		}
		}
			catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	public LibraryBeans login(int lid,String password)
	{
		LibraryBeans student=new LibraryBeans();
		
		try {
			Driver drf = new Driver();
			DriverManager.registerDriver(drf);
			System.out.println("load the driver");
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query = " select * from lib_details "
					+" where lid=? and password=? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			System.out.println("query insert");
			pstmt.setInt(1,lid);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				int uid1 = rs.getInt("uid");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				
				student.setUid(uid1);
				student.setFname(fname);
				student.setLname(lname);
			}
			else
			{
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	public int alloted(String uid)
	{
		LibraryBeans student=new LibraryBeans();
		
		try 
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query=" select count(bookid) from book_allot where uid=? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(uid));
			ResultSet rs=pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
			else
				return 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;		
		
	}
	
	public List<LibraryBeans> taken(int uid)
	{
		List<LibraryBeans> list=new ArrayList<>();
		
		
		try 
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query = " select bookname, booktakendate, bookreturndate "
					+ " from book_info bi, user_details ud, book_allot ba "
					+ " where ud.uid=ba.uid and ba.bookid = bi.bookid and ud.uid = ?";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, uid);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next())
			{
				do {
					LibraryBeans student=new LibraryBeans();
				student.setBookName(rs.getString("bookname"));
				student.setBook_taken_date(rs.getString("booktakendate"));
				student.setBook_return_date(rs.getString("bookreturndate"));
				
				list.add(student);
			}
				while (rs.next());
				return list;
			}
			else
			{
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
			
	}
	
	public int createLib(LibraryBeans bean)
	{
		LibraryBeans student=new LibraryBeans();
		
		try 
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query=" insert into lib_details values(?,?,?,?,?) ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, bean.getLid());
			pstmt.setString(2, bean.getFname());
			pstmt.setString(3, bean.getLname());
			pstmt.setString(4, bean.getGmail());
			pstmt.setString(5, bean.getPassword());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
	

}
