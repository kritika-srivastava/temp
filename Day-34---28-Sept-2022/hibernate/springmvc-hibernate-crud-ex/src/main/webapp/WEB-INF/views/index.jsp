<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored ="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hibernate CRUD example using SessionFactory</h1>
	
	<form method="POST" action="addcustomer" modelAttribute="customer">
		
		<input type="text" name="custname" placeholder="customer name">
		<input type="text" name="email" placeholder="customer email">
		<input type="submit" value="Add">
	</form>
	
	<h2>Customer List</h2>
	<c:forEach items="${customerList}" var="customer">
		<li>${customer.custname} ${customer.email}</li>
	</c:forEach>
</body>
</html>