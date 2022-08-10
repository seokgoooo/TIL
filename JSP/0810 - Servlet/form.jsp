<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 폼</title>
</head>
<body>
	<form action="${ pageContext.request.contextPath }/param">
		<input type="text" name="name" /> <input type="text" name="age" /> <input
			type="submit" />
	</form>
</body>
</html>