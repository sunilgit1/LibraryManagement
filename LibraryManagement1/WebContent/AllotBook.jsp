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
	<jsp:include page="LibHeader.jsp"/>
<center>
<div id="updatepass">
<table align ="center"  width="370px"  cellpadding="3px">
<b ><font color="red" ><h2 >Allot Book</h2></font></b>
<hr size="2px" color="black" width="400px"></br>
<form action="http://localhost:8080/LibraryManagement1/allotbook" method="Post">
		<table>
			<tr>
				<th>User ID</th>
				<td><input type="text" name="uid" required="required" required class=f5></td>
			</tr>
			<tr>
				<th>Book ID</th>
				<td><input type="text" name="bookid" required="required" required class=f5></td>
			</tr>
			<tr>
				<th>Taken Date</th>
				<td><input type="date" name="takendate" required="required" required class=f5></td>
			</tr>
			<tr>
<td></td>
<td><input type="submit" value="submit"  class=f4>
	<input type="submit" value="reset"  class=f4>
</td>
</tr>
		</table>
	</form>
</body>
</html>