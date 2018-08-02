
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
	
	

<div id="container">
<div id="header">
<p>Library Management</p>
</div>
<div id="menu">
	<ul>
		<li><a href=""><b>Home</a></li>
		<li><a href="SearchBook.jsp">Search</a></li>
		<li><a href="UpdatePass.jsp">Update Password</a></li>
		<li><a href="userlogout">LogOut</a></li>

	</ul>
</div>
<div id="section">
<h2><u>Home Page</u></h2>
<h4><u>No Of Books Taken</u></h4>
<h3>Sections :-></h3>
<div id="menu1">
	<ul>
		<li><a href='section?section=CS'><b>Computer Science</a></li>
		<li><a href='section?section=EE'>Electrical Tech</a></li>
		<li><a href='section?section=ME'>Mechanical Engg</a></li>
		<li><a href='section?section=CE'>Civil Engg</a></li>
		<li><a href='section?section=IT'>Information Engg</a></li>

	</ul>
</div>

</div>

<dir id="footer">
<td ><marquee direction="right"><font color="white"><b>&copy; 2017 All Right Reserved</marquee></td>
</div>
</div>

</body>
</html>