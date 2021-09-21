<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<div class=container>
		<div class=login-form>
			<h2> Author Form</h2>
			<form id="loginuser" action="loginuser" method="post">
				<table>
					<tr><td>Email</td> <td><input type="text" name="email"/></td></tr>
					<tr><td>Password</td> <td><input type="text" name="password"/></td></tr>
					<tr><td><input type="submit" value="Login"/></td></tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>