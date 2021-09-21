<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="static/styles/style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cosmo/bootstrap.min.css" />
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;1,200;1,400&display=swap" rel="stylesheet">
</head>
<body>
<div class=container>
	<h1>Welcome to User Home Page</h1>
   <form action="logout" method="post">
        <input type="submit" class="btn btn-info" value="Logout" />
    </form>
    <br>
    <form action="files" method="get">
        <input type="submit" class="btn btn-info" value="SHOW FILES" /> 
    </form>
   </div>
</body>
</html>