<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시판 글 목록</h1>
	<div>
		<p>글번호</p>
		<p>제목</p>
		<p>글쓴이</p>
	</div>

	<c:forEach var="article" items="${ dto.list }">
		<div>
			<p>${ article.no }</p>
			<p>${ article.title }</p>
			<p>${ article.writer }</p>
		</div>
	</c:forEach>

	<p>${ dto.totalPage }</p>

	<div>
		<a href="/board/write">글쓰기</a>
	</div>
</body>
</html>