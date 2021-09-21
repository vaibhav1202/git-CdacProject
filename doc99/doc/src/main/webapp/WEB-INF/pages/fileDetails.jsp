<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="static/styles/style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;1,200;1,400&display=swap" rel="stylesheet">
</head>
<body>
	<table>
	<tr>
	<th>name</th>
	<th>url</th>
	<th>size</th>
	</tr>
	<c:forEach var="files" items="${files}">
	<tr>
	<td>${files.name }</td>
	<td>${files.url }</td>
	<td>${files.size }</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>