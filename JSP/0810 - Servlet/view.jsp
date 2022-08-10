<%@page import="java.util.List"%>
<%@page import="hello.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사람 목록</title>
</head>
<body>
	<p>아아아아</p>
	<%
		List<Persons> list = (List<Persons>) request.getAttribute("persons");
	%>

	<ul>
		<%
			for (int i = 0; i < list.size(); i++) {
		%>

		<li><%=list.get(i).getFirstName()%></li>

		<%
			}
		%>
	</ul>

</body>
</html>