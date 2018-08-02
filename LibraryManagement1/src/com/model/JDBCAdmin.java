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

public class JDBCAdmin 
{

	public int createAdmin(LibraryBeans bean)
	{
		LibraryBeans student=new LibraryBeans();
		
		try 
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query=" insert into admin_details values(?,?,?,?,?) ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, bean.getAid());
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
	
	public LibraryBeans search(String fname)
	{
		LibraryBeans student=new LibraryBeans();
		
		try 
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query=" select * from user_details where firstname like ? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, "%"+fname+"%");
			ResultSet rs=pstmt.executeQuery();
			
			 if(rs.next())
				{
				 	int rno=rs.getInt("uid");
					String fname1=rs.getString("firstname");
					String lname=rs.getString("lastname");
					String gmail=rs.getString("gmail");
					
					student.setUid(rno);;
					student.setFname(fname1);
					student.setLname(lname);
					student.setGmail(gmail);
					
					
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
	
	public LibraryBeans adminlogin(int aid,String password)
	{
		LibraryBeans student=new LibraryBeans();
		
		try {
			Driver drf = new Driver();
			DriverManager.registerDriver(drf);
			System.out.println("load the driver");
			
			String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query = " select * from admin_details "
					+" where aid=? and password=? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			System.out.println("query insert");
			pstmt.setInt(1,aid);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				int aid1 = rs.getInt("aid");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				
				student.setUid(aid1);
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
	
	public List<LibraryBeans> viewuser()
	{
		List<LibraryBeans> list=new ArrayList<LibraryBeans>();
		
		try {
			 
			Driver drf = new Driver(); 
			DriverManager.registerDriver(drf);
			
			String dburl="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			
			String query="select * from user_details ";
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next())
			{	
				LibraryBeans s=new LibraryBeans();
				
				 s.setUid(rs.getInt("uid"));
				 s.setFname(rs.getString("firstname"));
				 s.setLname(rs.getString("lastname"));
				 s.setGmail(rs.getString("gmail"));
				
				list.add(s);
				//System.out.println(s);
				 
				 
		}
		}
			catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
}
