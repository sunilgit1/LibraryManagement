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
<b ><font color="red" ><h2 >Add Book</h2></font></b>
<hr size="2px" color="black" width="400px"></br>
<table>
<form action="http://localhost:8080/LibraryManagement1/addbook" method="post">
<tr >
<td><b><i>Book_ID</i></td>
<td><input type="number" name="bid" placeholder="Enter the BookId" required class=f5></td>
</tr>
<tr>
<td><b><i>Book_Name</td>
<td><input type="text" name="bname" placeholder="Enter the BookName" required class=f5></td>
</tr>
<tr>
<td><b><i>Book_Author</td>
<td><input type="text" name="bauthor" placeholder="Enter the BookAuthor" required class=f5></td>
</tr>
<tr>
<td><b><i>Edition</td>
<td><input type="number" name="edition" placeholder="Enter the Edition" required class=f5></td>
</tr>
<tr>
<td><b><i>No of Books</td>
<td><input type="number" name="nbook" placeholder="Enter the NoOfBooks" required class=f5></td>
</tr>
<tr>
<td><b><i>Section</td>
<td><input type="text" name="section" placeholder="Enter the Section" required class=f5></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="submit"  class=f4>
	<input type="submit" value="reset"  class=f4>
</td>
</tr>
</tr>
</form>
	
	</table>
</body>
</html>