<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- error가 발생하면 보여줄 page로 forward -->
<%@ page errorPage="showerror.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러를 발생시킬 페이지</title>
</head>
<body>
	<%
		String name = null;
	System.out.println(name.toString());
	%>
</body>
</html>