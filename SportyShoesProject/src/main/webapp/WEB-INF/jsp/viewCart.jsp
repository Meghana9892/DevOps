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
<h4 style="text-align:center;">Cart</h4>
<table border="2">
	<tr>
		<th> Product ID </th>
		<th> Brand </th>
		<th> Size </th>
		<th> Original Price </th>
		<th> Quantity </th>
		<th> Total </th>
	</tr>
 <c:forEach items="${cart}" var="s">
 	<tr>
 		<td>${s.shoes.productId}</td> 
 		<td>${s.shoes.brand}</td> 
 		<td>${s.shoes.size}</td> 
 		<td>${s.shoes.price}</td> 
 		<td>${s.shoes.quantity} </td>
 		<td>${s.shoes.totalprice} </td>
 	</tr>

 </c:forEach>
</table>
<h2></h2>
<sf:form action="/buy" method="post">
<input type="submit" value="Buy Now">
</sf:form>
<h4></h4>
<sf:form action="/welcome" method="post" modelAttribute="cart">
<input type="submit" value="Back to Home">
</sf:form>
</body>
</html>