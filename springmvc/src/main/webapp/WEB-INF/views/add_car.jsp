<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
/* CSS for Body */
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
    font-family: Arial, sans-serif;
    background-color: #222;
    color: #fff;
}

/* CSS for Main Container */
#main {
    margin-top: 50px;
    background-color: #333;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(255, 255, 255, 0.1);
}

/* CSS for Form */
form {
    margin-top: 20px;
}

/* CSS for Table */
table {
    width: 100%;
    border-collapse: collapse;
}

table td {
    padding: 10px;
    border-bottom: 1px solid #444;
}

/* CSS for Input Fields */
input[type="text"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #666;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 4px;
    margin-bottom: 8px;
    background-color: #444;
    color: #fff;
}

/* CSS for Submit Button */
input[type="submit"] {
    background-color: #007bff;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #0056b3;
}

/* CSS for Links */
a {
    color: #007bff;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

/* CSS for Message Div */
.message {
    margin-top: 20px;
    background-color: #444;
    color: #fff;
    border: 1px solid #666;
    border-radius: 4px;
    padding: 10px;
    text-align: center;
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
	<div align="center" id="main">
		<h3>Add Car Details</h3>
		<form action="add_car" method="post">
			<table>
				<tr>
					<td>Name:</td>
					<td id="inp_name"><input type="text" name="name"
						required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>Brand:</td>
					<td id="inp_brand"><input type="text" name="brand"
						required="required"></td>
				</tr>
				<tr>
					<td>Model:</td>
					<td id="inp_model"><input type="text" name="model"
						required="required"></td>
				</tr>
				<tr>
					<td>Fuel Type:</td>
					<td id="inp_fuel"><input type="text" name="fuel"
						required="required"></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td id="inp_price"><input type="text" name="price"
						required="required"></td>
				</tr>
			</table>
			<input type="submit" value="Add">
		</form>
		<h3>
			Go to <a href="home">Home Page</a>
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