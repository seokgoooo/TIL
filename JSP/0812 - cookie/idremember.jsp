<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID remember</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies) {
		if (c.getName().equals("rememberme")) {
			request.setAttribute("idvalue", URLDecoder.decode(c.getValue(), "utf-8"));
		}
		if (c.getName().equals("login")) {
			request.setAttribute("loginvalue", URLDecoder.decode(c.getValue(), "utf-8"));
		}
	}
	%>
	<c:choose>
		<c:when test="${ not empty loginvalue }">
			<%
				request.getRequestDispatcher("/WEB-INF/testlogin.jsp").forward(request, response);
			%>
		</c:when>
		<c:otherwise>
			<form action="./Login" method="post">
				<input type="text" name="id" value="${ idvalue }" /> <input
					type="password" name="password" /> <input type="checkbox"
					name="rememberme" /> <input type="submit" />
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>