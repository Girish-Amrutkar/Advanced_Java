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
/* Center the content */
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
body {
    text-align: center;
    margin: 0 auto;
    padding: 20px;
    background-color: #121212; /* Dark background */
    color: #ffffff; /* Light text color */
}

/* Style the message */
.message {
    color: #90caf9; /* Light blue color */
    font-size: 18px;
    margin-bottom: 20px;
}

/* Style the table */
table {
    border-collapse: collapse;
    width: 80%;
    margin: 0 auto;
}

table, th, td {
    border: 1px solid #757575; /* Darker gray border */
    color: #ffffff; /* Light text color */
}

th, td {
    padding: 8px;
    text-align: left;
}

th {
    background-color: #424242; /* Darker background */
}

/* Style the form */
form {
    margin-top: 20px;
}

/* Style form inputs and labels */
input[type="text"] {
    padding: 8px;
    width: 200px;
    background-color: #424242; /* Darker background */
    color: #ffffff; /* Light text color */
    border: 1px solid #757575; /* Darker gray border */
}

label {
    display: inline-block;
    width: 100px;
    text-align: right;
    margin-right: 10px;
    color: #ffffff; /* Light text color */
}

/* Style the submit button */
input[type="submit"] {
    padding: 8px 16px;
    background-color: #90caf9; /* Light blue color */
    color: #121212; /* Dark text color */
    border: none;
    cursor: pointer;
}

/* Style the home link */
h3 a {
    color: #90caf9; /* Light blue color */
    text-decoration: none;
}

h3 a:hover {
    text-decoration: underline;
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
			</tr>
			<%
			}
			%>
		</table>
		<div>
			<form action="search" method="post">
				<table>
					<tr>
						<td>Lower Range:</td>
						<td><input type="text" name="lowerRange"></td>
					</tr>
					<tr>
						<td>Higher Range:</td>
						<td><input type="text" name="higherRange"></td>
					</tr>
				</table>
				<input type="submit" value="Search">
			</form>
		</div>
		<h3>
			Go to <a href="home">Home</a>
		</h3>
	</div>
	<%
	}
	%>

</body>
</html>