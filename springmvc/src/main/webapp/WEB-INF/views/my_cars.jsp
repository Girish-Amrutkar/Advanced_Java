<%@page import="com.jspiders.springmvc.dto.CarDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

/* Table */
table {
	border-collapse: collapse;
	width: 100%;
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

/* Form inside table cells */
form {
	display: inline-block;
}

/* Submit button */
input[type="submit"] {
	padding: 5px 10px;
	background-color: #90caf9;
	color: #121212;
	border: none;
	cursor: pointer;
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
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<div align="center">
		<h3><%=message%></h3>
	</div>
	<%
	}
	@SuppressWarnings("unchecked")
	List<CarDTO> cars = (List<CarDTO>) request.getAttribute("cars");
	if (cars != null) {
	%>
	<div align="center">
		<table border="1px solid">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Brand</td>
				<td>Model</td>
				<td>Fuel</td>
				<td>Price</td>
				<td>Action</td>
			</tr>
			<%
			for (CarDTO car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getModel()%></td>
				<td><%=car.getFuel()%></td>
				<td><%=car.getPrice()%></td>
				<td>
					<form action="delete_car" method="post">
						<input type="text" name="id" value="<%=car.getId()%>"
							hidden="true"> <input type="submit" value="Delete">
					</form>
				</td>
				<td>
					<form action="edit_car" method="post">
						<input type="text" name="id" value="<%=car.getId()%>"
							hidden="true"> <input type="submit" value="Edit">
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</table>
		<h3>
			Go to <a href="home">Home</a>
		</h3>
	</div>
	<%
	}
	%>
</body>
</html>