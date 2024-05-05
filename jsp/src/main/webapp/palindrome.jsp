<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="palindrome.jsp">
			<table>
				<tr>
					<th>Enter Your Number</th>
				</tr>
				<tr>
					<th><input type="text" name="num1"
						style="height: 30px; width: 100px; border-radius: 10%"></th>
				</tr>
			</table>
			<input type="submit" value="Verify">
		</form>
	</div>

	<%!int num, originalNum, reversedNum;%>
	<%
	String input1 = request.getParameter("num");
	if (input1 != null) {
		num = Integer.parseInt(input1);
		originalNum = num;
		reversedNum = 0;

		while (num != 0) {
			int digit = num % 10;
			reversedNum = reversedNum * 10 + digit;
			num = num / 10;

		}
		if (originalNum == reversedNum) {
	%>
	<div align="center">
		<h3><%=originalNum%>
			is palindrome Number.
		</h3>
	</div>
	<%
	}
	} else {
	%>
	<div align="center">
		<h3><%=originalNum%>
			is palindrome Number.
		</h3>
	</div>
	<%
	}
	%>
</body>
</html>