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
<h4> Enter the below details</h4>
<sf:form action="/adminsubmit" method="post" modelAttribute="admin">
Admin Id <sf:input path="aName"/>
Password<sf:input path="aPassword" type="password"/>
<input type="submit" value="Create"/>
</sf:form>

</body>
</html>