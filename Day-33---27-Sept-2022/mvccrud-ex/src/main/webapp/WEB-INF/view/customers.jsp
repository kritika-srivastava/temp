<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Customers page</h1>

	<form action="addCustomer" modelAttribute="customer">
		<input type="number" name="customerid"> <input type="text"
			name="custname"> <input type="text" name="email"> <input
			type="submit" value="Add">
	</form>

	<table>
		<thead>
			<tr>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Email</th>
			</tr>

		</thead>
		<tbody>

			<c:forEach items="${customerList}" var="cust">
				<tr>
					<td>${cust.customerid}</td>
					<td>${cust.custname}</td>
					<td>${cust.email}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>