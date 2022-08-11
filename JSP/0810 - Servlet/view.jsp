<%@page import="java.util.List"%>
<%@page import="hello.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사람 목록</title>
</head>
<body>
	<%--
	
	 	<%
		List<Persons> list = (List<Persons>) request.getAttribute("persons");
	%>

	<ul>
		<%
			for (int i = 0; i < list.size(); i++) {
		%>

		<li><%=list.get(i).getFirstName()%> <%=list.get(i).getLastName()%>
			<%=list.get(i).getAge()%> <%=list.get(i).getMail()%></li>

		<%
			}
		%>
	</ul> 

이 만큼 긴 코드를 Expression Language를 사용해서 아래와 같이 줄일 수 있다.	
	--%>

	<c:if test="${ not empty list }">
		<ul>
			<c:forEach var="persons" items="${ list }">
				<li>${ persons.lastName }${ persons.firstName }${ persons.age }${ persons.mail }</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>