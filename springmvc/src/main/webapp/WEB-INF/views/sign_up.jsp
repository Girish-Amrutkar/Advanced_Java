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

/* Form container */
.container {
	text-align: center;
}

/* Form */
form {
	margin-top: 20px;
}

/* Form table */
table {
	border-collapse: collapse;
	width: 50%;
	margin: 0 auto;
}

table, th, td {
	border: 1px solid #757575;
	color: #ffffff;
}

th, td {
	padding: 10px;
	text-align: left;
}

/* Input fields */
input[type="text"], input[type="password"] {
	padding: 8px;
	width: 100%;
	border: none;
	background-color: #424242;
	color: #ffffff;
}

/* Submit button */
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

/* Already registered link */
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
	<div align="center">
		<h3>Sign Up</h3>
		<form action="add_user" method="post">
			<table>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="email" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" required="required"></td>
				</tr>
			</table>
			<input type="submit" value="Sign Up">
		</form>
		<h3>
			Already Registered? <a href="sign_in">Sign In</a>
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