<%@page import="com.userBeans.LibraryBeans" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="LibHeader.jsp"/>
	<%	List <LibraryBeans> list=(List<LibraryBeans>)request.getAttribute("data"); %>
	
	
	<!-- <table>
	
	<tr><th>UserId</th><th>BookID</th><th>Book_Taken_Date</th><th>Book_Return_Date</th></tr> -->
	
		<br>
		<h2 align="center" ><b><u><i><font color="red">Detail Of Books</h2>
		<center>
		<table align="center" cellspacing="10px" width="70%">
		<tr>
		<td><font size=4px color="#571B7E"><b><i>UserId</td>
		<td><font size=4px color="#571B7E"><b><i>BookId</td>
		<td><font size=4px color="#571B7E"><b><i>BookTakenDate</td>
		<td><font size=4px color="#571B7E"><b><i>BookReturnDate</td>
		
		
		
	
	<% 
		for(LibraryBeans s:list)
		{
	%>
		<tr><td><%=s.getUid()%></td><td><%=s.getBookid()%></td><td><%=s.getBook_taken_date()%></td>
		<td><%=s.getBook_return_date() %></td></tr>
	
	<%
		}
	%>
	</form>
	</table>
	
</body>
</html>