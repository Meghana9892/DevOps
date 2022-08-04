<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
    	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body>
<h1 text-align="center">User Details</h1>
<table border="2">
	<tr>
		<th> FirstName </th>
		<th> LastName </th>
		<th> UserName</th>
		<th> Age </th>
		<th>Date of Sign up</th>
		
	</tr>
 <c:forEach items="${users}" var="s">
 	<tr>
 		<td>${s.firstName}</td> 
 		<td>${s.lastName}</td>
 		<td>${s.username} </td>
 		<td>${s.age} </td>
 		<td>${s.date} </td>
 	</tr>

 </c:forEach>
</table>
<h4></h4>
<sf:form action="/search" method="post" modelAttribute="user">
First Name <sf:input path="firstName"/>
<input type="submit" value="Search By Firstname">
</sf:form>
<h4></h4>
<sf:form action="/searchbyage" method="post" modelAttribute="user">
Age <sf:input path="Age"/>
<input type="submit" value="Search By Age">
</sf:form>
<h4></h4>
<sf:form action="/sortuserName" method="post" modelAttribute="user">
<input type="submit" value="Sort By Username">
</sf:form>
<h4></h4>
<sf:form action="/adminhome" method="get" modelAttribute="admin">
<input type="submit" value="Back to Home">
</sf:form>
</body>
</html>