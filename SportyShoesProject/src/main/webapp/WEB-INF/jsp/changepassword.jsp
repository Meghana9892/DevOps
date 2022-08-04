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
<sf:form action="/password" method="post" modelAttribute="admin">
Admin Id <sf:input path="aName" type="text"/>
New Password <sf:input path="aPassword" type="password"/>
<input type="submit" value="Change" name="submit"/>
</sf:form>
<h4>${message}</h4>
<sf:form action="/adminhome" method="get" modelAttribute="admin">
<input type="submit" value="Back to Home">
</sf:form>
</body>
</html>