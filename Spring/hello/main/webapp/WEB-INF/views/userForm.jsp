<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보 입력</title>
</head>
<body>
	<f:form modelAttribute="user" method="POST">
		<f:errors path="name" />
		<f:input type="text" path="name" />
		<f:errors path="age" />
		<f:input type="number" path="age" />
		<input type="submit" />
	</f:form>
</body>
</html>