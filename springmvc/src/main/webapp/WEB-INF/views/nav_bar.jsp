<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Navigation Page</title>
<style type="text/css">
/* Dark mode CSS */

/* Body */
body {
	background-color: #121212;
	color: #ffffff;
	font-family: Arial, sans-serif;
	padding: 20px;
	margin: 0;
}

/* Navigation box */
#box {
	text-align: center;
}

/* Navigation links */
nav a {
	color: #90caf9;
	text-decoration: none;
	padding: 10px 20px;
	margin: 0 5px;
	border-radius: 5px;
}

nav a:hover {
	background-color: #424242;
}

/* Title */
h1 {
	color: #90caf9;
}
</style>
</head>
<body>
	<div id="box" align="center">
		<nav>
			<a href="add_page">Add Car(s)</a> <a href="cars">View All Cars</a> <a
				href="my_cars">My Cars</a> <a href="sign_out">Sign Out</a> <a
				href="delete_user">Delete Account</a>

		</nav>
	</div>
</body>
</html>