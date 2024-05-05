<%@page import="com.jspiders.springmvc.dto.CarDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
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
/* Dark mode CSS */

/* Body */
body {
	background-color: #121212;
	color: #ffffff;
	font-family: Arial, sans-serif;
	padding: 20px;
	margin: 0;
}

/* Main container */
#main {
	text-align: center;
}

/* Form */
form {
	margin-top: 20px;
}

/* Form table */
table {
	border-collapse: collapse;
	width: 80%;
	margin: 0 auto;
	border: 1px solid #757575;
}

table, th, td {
	border: 1px solid #757575;
	color: #ffffff;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #424242;
}

/* Input fields */
input[type="text"] {
	padding: 8px;
	width: 100%;
	border: none;
	background-color: #424242;
	color: #ffffff;
}

/* Update button */
input[type="submit"] {
	padding: 8px 16px;
	background-color: #90caf9;
	color: #121212;
	border: none;
	cursor: pointer;
	margin-top: 10px;
}

input[type="submit"]:hover {
	background-color: #64b5f6;
}

/* Home link */
h3 a {
	color: #90caf9;
	text-decoration: none;
}

h3 a:hover {
	text-decoration: underline;
}

/* Message */
.message {
	color: #90caf9;
	font-size: 18px;
	margin-top: 20px;
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
	<%
	CarDTO car = (CarDTO) request.getAttribute("car");
	%>
	<div align="center" id="main">
		<h3>Update Car Details</h3>
		<form action="update_car" method="post">
			<table border="1px solid">
				<tr>
					<td>ID:</td>
					<td id="inp_id"><input type="text" name="id"
						value="<%=car.getId()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td id="inp_name"><input type="text" name="name"
						value="<%=car.getName()%>"></td>
				</tr>
				<tr>
					<td>Brand:</td>
					<td id="inp_brand"><input type="text" name="brand"
						value="<%=car.getBrand()%>"></td>
				</tr>
				<tr>
					<td>Model:</td>
					<td id="inp_model"><input type="text" name="model"
						value="<%=car.getModel()%>"></td>
				</tr>
				<tr>
					<td>Fuel Type:</td>
					<td id="inp_fuel"><input type="text" name="fuel"
						value="<%=car.getFuel()%>"></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td id="inp_price"><input type="text" name="price"
						value="<%=car.getPrice()%>"></td>
				</tr>
			</table>
			<input type="submit" value="Update">
		</form>
		<h3>
			Go to <a href="home">Home</a>
		</h3>
	</div>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<div align="center">
		<h3><%=message%></h3>
	</div>
	<%
	}
	%>
</body>
</html>