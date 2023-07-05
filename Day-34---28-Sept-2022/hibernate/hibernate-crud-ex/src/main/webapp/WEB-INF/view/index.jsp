<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hibernate CRUD ex</h1>

	<form action="addcustomer" modelAttribute="customer">

		<input type="text" name="custname" placeholder="customer name">
		<input type="text" name="email" placeholder="customer email">
		<input type="button" value="Add">

	</form>

	<h2>Customer List</h2>
	<c:forEach items="${customerList }" var="customer">
		<li>${customer.name } ${customer.email }</li>
	</c:forEach>
</body>
</html>