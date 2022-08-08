<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력창</title>
</head>
<body>
	<!-- 
		입력폼. 필수로 값이 들어가야 한다!
		사용자 이름
		사용자 나이
 	-->
	<form action="./result.jsp">
		<input type="text" name="name" required="required">
		<input type="number" name="age" required="required">
		<input type="submit">
	</form>
</body>
</html>