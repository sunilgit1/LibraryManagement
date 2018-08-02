
<%@page import="com.userBeans.LibraryBeans" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="userstyle.css"/>
</head>
<body>

<jsp:include page="AdminHeader.jsp"/>

	<%-- <% LibraryBeans student=(LibraryBeans)request.getAttribute("studentdata"); %>
	
	<% 
		if(student!=null)
		{
	%>
		Uid:<%= student.getUid() %>
		FirstName:<%=student.getFname()%>
		LastName:<%=student.getLname()%>
		
		<%
		}
		
	 %>	 --%>

<form action ="http://localhost:8080/LibraryManagement1/searchstudent" method="get">
<center>
<div id="updatepass">
<table align ="center"   width="350px"  cellpadding="2">
<table>
<b ><font color="red" ><h2 align ="center">Search Students</h2></font></b>
<hr size="2px" color="black" width="300px"></table><br>
<tr>
<td>
<input type="text" name="fname" placeholder="Enter the studentname" required class=f5>
<input type="submit" value="search" class=f3>
</td>
</tr>
</table>
</form>
</body>
</html>