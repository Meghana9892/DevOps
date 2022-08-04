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
<h1 text-align="center">Purchase Report</h1>
<table border="2">
	<tr>
		<th> Purchase ID </th>
		<th> Purchase Date </th>
		
	</tr>
 <c:forEach items="${report}" var="s">
 	<tr>
 		<td>${s.purchaseid}</td> 
 		<td>${s.purchasedate} </td>
 	</tr>
</c:forEach>
</table>
<h4></h4>
<sf:form action="/searchproduct" method="post" modelAttribute="admin">
Purchase ID<sf:input path="purchaseid"/>
<input type="submit" value="Search">
</sf:form>
<h4></h4>
<table border="2">
	<tr>
		<th> Product ID </th>
		<th> Brand </th>
		<th> Size </th>
		
	</tr>
 <c:forEach items="${shoes}" var="s">
 	<tr>
 		<td>${s.productId}</td> 
 		<td>${s.brand}</td>
 		<td>${s.size} </td>
 		
 	</tr>

 </c:forEach>
</table>
<h4></h4>
<sf:form action="/adminhome" method="get" modelAttribute="admin">
<input type="submit" value="Back to Home">
</sf:form>
</body>
</html>