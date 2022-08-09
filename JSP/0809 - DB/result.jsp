<%@page import="java.util.List"%>
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
		List<String> listName = (List<String>) request.getAttribute("name");
	List<Integer> listPopulation = (List<Integer>) request.getAttribute("population");
	%>

	<ul>
		<li>Name Population</li>
		<%
			for (int i = 0; i < listName.size(); i++) {
		%>

		<li><%=listName.get(i)%> <%=listPopulation.get(i)%></li>

		<%
			}
		%>
	</ul>
</body>
</html>