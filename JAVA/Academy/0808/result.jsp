<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
	<%
		String a = request.getParameter("name");
	String b = request.getParameter("age");

	out.println("이름 : " + a + " 나이 : " + b + "님 환영합니다.");
	%>

</body>
</html>