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
<jsp:include page="UserHeader1.jsp"/>
<center>
<div id="updatepass">
<table align ="center"  width="370px"  cellpadding="3px">
<b ><font color="red" ><h2 >Update Password</h2></font></b>
<hr size="2px" color="black" width="400px"></br>
<form action="http://localhost:8080/LibraryManagement1/updatepass" method="post">
<tr>
<td><b><i>User Id</td>
<td><input type="number" name="uid" placeholder="enter the userid" required class=f5></td>
</tr>
<tr>
<td><b><i>Curr-Passsword</td>
<td><input type="password" name="cpass" placeholder="enter the curr-pass" required class=f5></td>
</tr>
<tr>
<td><b><i>NewPassword</td>
<td><input type="password" name="npass" placeholder="enter the new pass" required class=f5></td>
</tr>
<tr>
<td><b><i>Re-Password</td>
<td><input type="password" name="rpass" placeholder="enter the re-pass" required class=f5></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="update" class=f2>
<input type="submit" value="reset" class=f2>
</td>
</tr>
</form>
</table>
</div>
</body>
</html>