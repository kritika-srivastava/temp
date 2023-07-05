<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvcex2</title>
</head>
<body>
	<h1>Enter username and password here</h1>
	<form action="addUser" modelAttribute="user">
		<input type="text" name="userName" /> 
		<input type="text" name="userPassword" />
		<input type="submit" value="Add">
	</form>
	
	<table>
		<thead>
			<tr>
				<th>Output</th>
				
			</tr>

		</thead>
		<tbody>

			<c:forEach items="${userList}" var="user">
				<tr>
					<td>Welcome <c:out value="${user.userName}" /> to stackroute<td>
			
				</tr>
			</c:forEach>

		</tbody>
</body>
</html>