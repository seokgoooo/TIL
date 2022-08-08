<%@page import="javax.swing.ImageIcon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String[] result = request.getParameterValues("num");

	for (int i = 0; i < result.length; i++) {
		if (result[i].equals("1")) {
			out.println("<img src=\"./images/4.png\" />");
		} else if (result[i].equals("2")) {
			out.println("<img src=\"./images/5.png\" />");
		} else if (result[i].equals("3")) {
			out.println("<img src=\"./images/6.png\" />");
		}
	}
	%>

</body>
</html>