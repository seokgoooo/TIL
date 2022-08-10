<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${ requestScope.name1 }</p>
	<p>${ requestScope.name2 }</p>
	<p>${ applicationScope.name3 }</p>
	<p>${ requestScope.name4 }</p>
	<p>${ applicationScope.name4 }</p>
	<hr>
	<!-- 변수가 request -> session -> application 등등 범위 작은 순서부터 찾아서 나오면 바로 출력한다-->
	<p>${ name1 }</p>
	<p>${ name2 }</p>
	<p>${ name3 }</p>
	<p>${ name4 }</p>
	<hr>
	<!-- 없는 값을 달라고하면 공백 -->
	<p>${ none }</p>
</body>
</html>