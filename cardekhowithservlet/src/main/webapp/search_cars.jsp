<%@page import="com.jspiders.cardekhowithservlet.object.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {
	border: none;
	text-align: align;
	font-family: sans-serif;
	font-size: 30px;
	color: white;
}

.table {
	border-radius: 5px;
	background-color: black;
}

th {
	background-color: black;
	padding: 10px;
}

input {
	height: 60px;
	width: 150px;
	font-weight: bold;
	background-color: black;
	border-radius: 20%;
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
</head>
<body>

	<%
	@SuppressWarnings("unchecked")
	List<Car> cars = (List<Car>) request.getAttribute("cars");
	if (cars != null && cars.size() > 0) {
	%>
	<div align="center" id="">
		<table border="1px solid" id="table">
			<tr>
				<th class="title">ID</th>
				<th class="title">Name</th>
				<th class="title">Brand</th>
				<th class="title">Fuel Type</th>
				<th class="title">Price</th>
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
</body>
</html>