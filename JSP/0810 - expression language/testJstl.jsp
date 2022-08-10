<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl 1.2 jar를 library에 집어넣고 tablig을 해줘야 사용가능하다. prefix 는 이 library를 c라고 부른다는 명령어 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- for는 forEach로 사용할 수 있고 if 까지 사용가능하다 -->
	<c:forEach var="i" begin="1" end="10">
		<c:if test="${ i % 2 == 0 }">
			<p>${ i }</p>
		</c:if>
	</c:forEach>
	<hr>

	<!-- if else가 없기 때문에 이를 대신해줄 choose when 을 사용한다 -->
	<c:choose>
		<c:when test="true">
			<p>첫번째 조건이 참일때</p>
		</c:when>
		<c:when test="false">
			<p>두번째 조건이 참일때</p>
		</c:when>
		<c:otherwise>
			<p>모든 조건이 참이 아닐때</p>
		</c:otherwise>
	</c:choose>
</body>
</html>