<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out 기본객체</title>
</head>
<body>
	<h1>정적 텍스트</h1>
	<%=1 + 2 + 3%>
	<br />
	<%
		out.println(1 + 2 + 3);
	out.println("<br/>");
	%>

	<p>jsp의 모든 텍스트는 아웃 객체가 출력합니다.</p>

	<%
		boolean someBool = true;

	if (someBool) {
		// 중간에 html 집어 넣으면 얘가 못읽어서 %로 닫아주고 열어주고 쇼를 했다.
		// But, out.객체를 이용하면 그런 뻘짓을 안해도 된다.
		out.println("<p>참일 때 출력해야하는 텍스트</p>");
	} else {
		out.println("<p>거짓일 때 출력해야하는 텍스트</p>");
	}
	%>
</body>
</html>