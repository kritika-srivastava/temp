<%@page language="java" pageEncoding="ISO-8859-1"
	contentType="text/html; ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
</head>
<body>

	<!-- Create a form which will have text boxes for News ID, title, author,description, content
		 along with a Send button. Handle errors like empty fields -->
	<h1>News App</h1>

	<form action="saveData" modelAttribute="news">
		<label for="newsId">News Id</label> 
		<br>
		<input type="number" name="newsId" id="newsId"> 
		<br>
		<label for="title">Title</label> 
		<br>
		<input type="text" name="title"> 
		<br>
		<label for="author">Author</label>
		<br>
		<input type="text" name="author"> 
		<br>
		<label for="description">Description</label>
		<br>
		<input type="text" name="description"> 
		<br>
		<label for="content">Content</label>
		<br>
		<input type="text" name="content">
		<br> 
		<br>
		<input type="submit" value="Send">
	</form>
	<!-- display all existing news in a tabular structure with News ID, title, author,description,content
		publishedAt and Action(delete button) -->

	<table style="width:80%" style="text-align:center;padding-left:10%;">
		<thead>
			<tr>
				<th>News ID</th>
				<th>Title ID</th>
				<th>Author</th>
				<th>Description</th>
				<th>Published At</th>
				<th>Content</th>
				<th></th>
			</tr>

		</thead>
		<tbody>

			<c:forEach items="${newsList}" var="news">
				<tr>
					<td>${news.newsId}</td>
					<td>${news.title}</td>
					<td>${news.author}</td>
					<td>${news.description}</td>
					<td>${news.publishedAt}</td>
					<td>${news.content}</td>
					
					<%-- <td><form action="deleteNews" modelAttribute="newsid" >
					<Button for="News" name="${news}">Delete</Button>
					</form></td> --%>
					
					<td><form action="deleteNews" method="get">
							<button name="newsId" value="${news.newsId}">Delete</button>
						</form></td>
					
				
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>