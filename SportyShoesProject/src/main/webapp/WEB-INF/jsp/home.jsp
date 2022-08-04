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
<sf:form action="/admin" method="get" modelAttribute="admin">
<input type="submit" value="Admin" name="submit"/>
</sf:form>
<h1></h1>
<sf:form action="/login" method="get" modelAttribute="login">
<input type="submit" value="User" name="submit"/>
</sf:form>
</body>
</html>