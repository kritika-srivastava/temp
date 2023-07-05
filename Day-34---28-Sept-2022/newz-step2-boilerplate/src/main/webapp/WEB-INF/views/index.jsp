<%@page language="java" pageEncoding="ISO-8859-1"
	contentType="text/html; ISO-8859-1"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!doctype html>

<html lang="en">
<head>
<title>Newz Application</title>
</head>
<body>
	<div class="container"
		style="width: 80%; margin-left: 10%; background-color: #d0dfff; height: 100vh; text-align: center;">
		<div class="header"
			style="background-color: #c8c8c8; width: 90%; text-align: center; height: 20%; display: inline-block;">
			<h1>Newz Application Assignment</h1>
			<!-- Create a form which will have text boxes for News Name, News Author, description, content along with a Add 
		 button. Handle errors like empty fields.-->

		</div>
		<form action="add" attribute="news">

			<label for="name">Name</label> <br> <input size="50" type="text"
				name="name"> <br> <label for="author">Author</label> <br>
			<input size="50" type="text" name="author"> <br> <label
				for="description">Description</label> <br> <input size="50"
				type="text" name="description"> <br> <label
				for="content">Content</label> <br> <input size="50" type="text"
				name="content"> <br> <br> <input size="20"
				type="submit" value="Send">
		</form>

		<br> <br>

		<table style="width: 80%; text-align: center; padding-left: 10%;">
			<thead>
				<tr>
					<th>NewsId</th>
					<th>Name</th>
					<th>Author</th>
					<th>Description</th>
					<th>Published At</th>
					<th>Content</th>
					<th></th>
					<th></th>
				</tr>

			</thead>
			<tbody>

				<c:forEach items="${newsList}" var="news">
					<tr>
						<td>${news.newsId}</td>
						<td>${news.name}</td>
						<td>${news.author}</td>
						<td>${news.description}</td>
						<td>${news.publishedAt}</td>
						<td>${news.content}</td>



						<td><form action="update">
								<button name="newsId" value="${news.newsId}">Update</button>
							</form></td>

						<td><form action="delete">
								<button name="newsId" value="${news.newsId}">Delete</button>
							</form></td>



					</tr>
				</c:forEach>

			</tbody>

		</table>

	</div>
	<!-- display all existing news in a tabular structure with News Name, News Author, 
	description, content, Publish Date and Action -->



</body>
</html>


