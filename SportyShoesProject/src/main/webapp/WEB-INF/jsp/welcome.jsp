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
<h1 style="text-align:center">Sporty Shoes</h1>
<h4>Welcome ${Name}</h4>
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
<h2></h2>
<sf:form action="/addcart" method="post" modelAttribute="cart">
Enter the Product Id  <sf:input type="text" path="ProductId"/>
Quantity <sf:input type="text" path="quantity" />
<input type="submit" value="Add to Cart">
</sf:form>
<h4>${message}</h4>
<h4></h4>
<sf:form action="/viewcart" method="post" modelAttribute="cart">
<input type="submit" value="View Cart">
</sf:form>
<h4></h4>
<sf:form action="/logoutuser" method="get" modelAttribute="login">
<input type="submit" value="Log out">
</sf:form>
</body>
</html>