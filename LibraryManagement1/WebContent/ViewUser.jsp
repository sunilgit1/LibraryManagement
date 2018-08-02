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
<jsp:include page="AdminHeader.jsp"/>
	<%	List <LibraryBeans> list=(List<LibraryBeans>)request.getAttribute("data"); %>
	
	
		<br>
		<h2 align="center" ><b><u><i><font color="red">Detail Of Users</h2>
		<center>
		<table align="center" cellspacing="10px" width="50%">
		<tr>
		<td><font size=4px color="#571B7E"><b><i>UserId</td>
		<td><font size=4px color="#571B7E"><b><i>FirstName</td>
		<td><font size=4px color="#571B7E"><b><i>LastName</td>
		
	<% 
		for(LibraryBeans s:list)
		{
	%>
		<tr><td><%=s.getUid()%></td><td><%=s.getFname()%></td><td><%=s.getLname()%></td>
	
	<%
		}
	%>
	</form>
	</table>
</body>
</html>