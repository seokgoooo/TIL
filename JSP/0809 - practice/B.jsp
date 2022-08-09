<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>B</h1>
	<%
		Object result = request.getAttribute("result");
	%>
	<p><%=result%></p>
</body>
</html>