<%@ page import="com.userBeans.LibraryBeans" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="section.css"/>
</head>
<body>

<div id="container">
<div id="header">
<p><b>Section Civil Engg</b></p>

</div>

<% List<LibraryBeans> list=(List<LibraryBeans>)request.getAttribute("data");%>
	
	<div id="menu">
	<table width="800px">
	
	<tr>
	<th><font color="white">BookId</th>
	<th><font color="white">BookName</th>
	<th><font color="white">BookAuthor</th>
	<th><font color="white">Edition</th>
	<th><font color="white">NoOfBooks</th>
	</tr>
	<% 
		for(LibraryBeans s:list)
		{
			
	%>
			<tr><td><%=s.getBookid() %></td>
			<td><%=s.getBookName()%></td>
			<td><%=s.getBookAuthor() %></td>
			<td><%=s.getEdition() %></td>
			<td><%=s.getnOfBooks() %></td>
			</tr>
			
		<% 
		}
	%>
	</form>
	</table>
	</div>
	</div>
</body>
</html>