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
<sf:form action="/submit" method="post" modelAttribute="signup">
First Name<sf:input path="firstName"/>
Last Name <sf:input path="lastName"/>
UserName <sf:input path="username"/>
Age <sf:input path="age"/>
Password<sf:input path="password" type="password"/>
<input type="submit" value="Sign Up"/>
</sf:form>

</body>
</html>