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
<h4>Add Product</h4>
<sf:form action="/addshoe" method="post" modelAttribute="shoe">
Brand<sf:input path="brand"  type="text"/>
Size <sf:input path="size" type="text"/>
Price <sf:input path="price" type="text"/>
<input type="submit" value="Add" /> 
</sf:form>
<h5>${message}</h5>
<sf:form action="/adminhome" method="get" modelAttribute="admin">
<input type="submit" value="Back to Home">
</sf:form>
</body>
</html>