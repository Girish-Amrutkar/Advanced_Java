<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
* {
	border: none;
	font-family: sans-serif;
	font-size: 30px;
	color: white;
}

.table {
	border-radius: 5px;
	background-color: black;
	font-size: 30px;
	color: white;
	text-align: center;
}

th {
	background-color: black;
	padding: 10px;
}

input {
	height: 60px;
	width: 150px;
	font-size: 25px;
	font-weight: bold;
	background-color: black;
	color: white;
	border-radius: 20%;
	text-align: center;
}

td {
	background-color: grey;
	height: 60px;
	width: 150px;
}

#main {
	margin: 100px auto;
	height: 500px;
	width: 350px;
	border: 1px solid;
	border-radius: 0px 30px 0px 30px;
	background-color: maroon;
}
</style>
<body>
	<div align="center" id="main">
		<h2>Add Car Details</h2>
		<form action="add_car" method="post">
			<table border="1px solid">
				<tr>
					<td>ID:</td>
					<td id="inp_id"><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td id="inp_name"><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Brand:</td>
					<td id="inp_brand"><input type="text" name="brand"></td>
				</tr>
				<tr>
					<td>Fuel Type:</td>
					<td id="inp_fuel"><input type="text" name="fuel_type"></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td id="inp_price"><input type="text" name="price"></td>
				</tr>
			</table>
			<input type="submit" value="Add">
		</form>
	</div>
	<%!String message;%>
	<%
	message = (String) request.getAttribute("message");
	%>
	<div align="center">
		<%
		if (message != null) {
		%>
		<h4><%=message%></h4>
		<%
		}
		%>
	</div>
</body>
</html>