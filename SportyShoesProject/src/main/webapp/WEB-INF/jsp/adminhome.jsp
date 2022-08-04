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
<h1 style="text-align:center;">Sporty Shoes</h1>
<sf:form action="/changepassword" method="get" modelAttribute="admin">
<input type="submit" value="Change Password">
</sf:form>
<h4></h4>
<sf:form action="/products" method="get" modelAttribute="shoe">
<input type="submit" value="Products">
</sf:form>
<h4></h4>
<sf:form action="/user" method="post" modelAttribute="user">
<input type="submit" value="View User Data">
</sf:form>
<h4></h4>
<sf:form action="/report" method="post" modelAttribute="admin">
<input type="submit" value="View Purchase Report">
</sf:form>
<h4></h4>
<sf:form action="/logout" method="get" modelAttribute="admin">
<input type="submit" value="Log out">
</sf:form>
</body>
</html>