<%@page import="com.jspiders.cardekhowithservlet.jdbc.CarJDBC"%>
<%@page import="com.jspiders.cardekhowithservlet.object.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
*{
	border: none;
	font-family: sans-serif;
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
	border-radius: 5px;
	text-align: center;
}

td {
	background-color: grey;
	height: 60px;
	width: 150px;
}
</style>
</head>
<body>
	<%
	List<Car> cars = CarJDBC.searchAllCars();
	if (cars != null && cars.size() > 0) {
	%>
	<div align="center" id="">
		<table border="1px solid" class="table">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Fuel Type</th>
				<th>Price</th>
			</tr>
			<%
			for (Car car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getFuel_type()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</table>

	</div>
	<%
	} else {
	%>
	<div align="center">
		<h4>Car Details not available...</h4>
	</div>
	<%
	}
	%>
	<div align="center">
		<form action="delete_car" method="post">
			<br>
			<table border="" class="table">
				<tr>
					<th>ID</th>
					<td><input type="text" name="id"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Delete">
		</form>
	</div>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<h4><%=message%></h4>
	<%
	}
	%>
</body>
</html>