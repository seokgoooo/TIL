<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
	List<String> list = new ArrayList<>();
for (int i = 0; i < 100; i++) {
	list.add("book" + i);
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 페이지</title>
</head>
<body>
	<%
		String view = request.getParameter("page");
	int pageView = Integer.parseInt(view);

	String viewPage = request.getParameter("pageper");
	int pagePer = Integer.parseInt(viewPage);

	for (int i = (pagePer * (pageView - 1)); i < pageView * pagePer; i++) {
		out.println(list.get(i));
		out.println("<br/>");
	}
	%>
</body>
</html>