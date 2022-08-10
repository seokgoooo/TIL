<%@page import="java.util.List"%>
<%@page import="kr.co.greenart.Country"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 선택한 대륙의 국가들의 이름, 인구를 볼 수 있는 (인구 내림차순) 페이지 --%>
	<%
		List<Country> list = (List<Country>) request.getAttribute("list");
	%>

	<ul>
		<li>Name Population</li>
		<%
			for (int i = 0; i < list.size(); i++) {
		%>

		<li><%=list.get(i).getName()%> <%=list.get(i).getPopulation()%></li>

		<%
			}
		%>
	</ul>
</body>
</html>