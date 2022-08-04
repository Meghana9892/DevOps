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
<h4>Login</h4>
<h4>${message}</h4>
<sf:form action="/loginuser" method="post" modelAttribute="login">
Username<sf:input path="username" type="text"/>
Password <sf:input path="password" type="password"/>
<input type="submit" value="Login" name="submit"/>
</sf:form>
<h2></h2>
<sf:form action="/signup" method="get" modelAttribute="login">
New User? <input type="submit" value="Sign Up" name="submit"/>
</sf:form>
</body>
</html>