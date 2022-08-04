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
<h1 text-align="center">Products</h1>
<table border="2">
	<tr>
		<th> Product ID </th>
		<th> Brand </th>
		<th> Size </th>
		<th> Price </th>
	</tr>
 <c:forEach items="${shoes}" var="s">
 	<tr>
 		<td>${s.productId}</td> 
 		<td>${s.brand}</td>
 		<td>${s.size} </td>
 		<td>${s.price} </td>
 	</tr>

 </c:forEach>
</table>
<h4></h4>
<sf:form action="/shoe" method="get" modelAttribute="shoe">
<input type="submit" value="Add Product">
</sf:form>
<h4></h4>
<sf:form action="/sort" method="post" modelAttribute="shoe">
<input type="submit" value="Sort By Brand">
</sf:form>
<h4>${message}</h4>
<sf:form action="/adminhome" method="get" modelAttribute="admin">
<input type="submit" value="Back to Home">
</sf:form>
</body>
</html>