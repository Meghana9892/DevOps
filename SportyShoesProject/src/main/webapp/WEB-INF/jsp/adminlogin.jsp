<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body>
<h3>Admin Login</h3>
<sf:form action="/adminlogin" method="post" modelAttribute="admin">
Admin Id <sf:input path="aName" type="text"/>
Password <sf:input path="aPassword" type="password"/>
<input type="submit" value="Login" name="submit"/>
<h4>${message}</h4>
</sf:form>
<h2></h2>
<sf:form action="/adminSignup" method="get" modelAttribute="admin">
Create Admin profile <input type="submit" value="Create" name="submit"/>
</sf:form>
</body>
</html>