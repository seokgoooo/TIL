<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ pageContext.request.contextPath }/insert">
		<input type="text" name="firstName" />
		<input type="text" name="lastName" />
		<input type="number" name="age" />
		<input type="text" name="mail" />
		
		<input type="submit" />
	</form>
</body>
</html>