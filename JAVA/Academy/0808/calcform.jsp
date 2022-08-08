<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./calcresult.jsp">
		<input type="number" name="number1">
		<input type="radio" name="operator" value="1">+
		<input type="radio" name="operator" value="2">-
		<input type="radio" name="operator" value="3">*
		<input type="radio" name="operator" value="4">/
		<input type="number" name="number2">
		<input type="submit">
	</form>
</body>
</html>