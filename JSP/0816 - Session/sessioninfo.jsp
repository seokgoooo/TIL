<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 보기</title>
</head>
<body>
	<!-- 세션은 브라우저마다 다르게 생성된다. -->
	<p>
		세션 아이디 :
		<%=session.getId()%></p>
	<p>
		세션 생성시간 :
		<%=new Date(session.getCreationTime())%></p>
	<p>
		마지막으로 세션에 접근한 시간 :
		<%=new Date(session.getLastAccessedTime())%></p>
</body>
</html>