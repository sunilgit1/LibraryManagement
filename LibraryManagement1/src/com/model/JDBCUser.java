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

public class JDBCUser 
{

	public LibraryBeans login(int uid,String password)
	{
		LibraryBeans student=new LibraryBeans();
		
		try {
			Driver drf = new Driver();
			DriverManager.registerDriver(drf);
			System.out.println("load the driver");
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query = " select * from user_details "
					+" where uid=? and password=? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			System.out.println("query insert");
			pstmt.setInt(1,uid);
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
	
	public int adduser(LibraryBeans bean)
	{
		//LibraryBeans student=new LibraryBeans();
		
		try 
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query=" insert into user_details values(?,?,?,?,?) ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,bean.getUid());
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
	
	
	public LibraryBeans searchbook(String bookName)
	{
		LibraryBeans student=new LibraryBeans();
		
		try 
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query=" select * from book_info where bookname like ? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, "%"+bookName+"%");
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				int bid=rs.getInt("bookid");
				String bname=rs.getString("bookname");
				String bauthor=rs.getString("bookauthor");
				int nofbooks=rs.getInt("noofbooks");
				String section=rs.getString("section");
				
				student.setBookid(bid);
				student.setBookName(bname);
				student.setBookAuthor(bauthor);
				student.setnOfBooks(nofbooks);
				student.setSection(section);
				
				
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
	
	public int updatapass(int uid,String currpass,String newpass,String rpass)
	{
		LibraryBeans student=new LibraryBeans();
		
		if(newpass.equals(rpass))
		{
			System.out.println("password matched");
			
			try 
			{
				Driver drf=new Driver();
				DriverManager.registerDriver(drf);
				
				String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
				Connection con=DriverManager.getConnection(url);
				
				String query=" update user_details set password=? where uid=? and password=? ";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, newpass);
				pstmt.setInt(2, uid);
				pstmt.setString(3, currpass);
				
				return pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return uid;
	}
	
	public List<LibraryBeans> section(String section)
	{
		
		List<LibraryBeans> list=new ArrayList<>();
		
		try 
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query = " select * from book_info where section=? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, section);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				do {
					LibraryBeans student=new LibraryBeans();
					
				student.setBookid(rs.getInt("bookid"));
				student.setBookName(rs.getString("bookname"));
				student.setBookAuthor(rs.getString("bookauthor"));
				student.setEdition(rs.getInt("edition"));
				student.setnOfBooks(rs.getInt("noofbooks"));
				student.setSection(rs.getString("section"));
				
				list.add(student);
			}while(rs.next());
			return list;
			
		}else
		{
			return null;
		}
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
		
		
	}
	
	
	
	
}
