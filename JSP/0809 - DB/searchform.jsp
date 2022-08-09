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
	<%-- 사용자가 대륙을 선택할 수 있게 --%>
	<%
		List<String> list = (List<String>) request.getAttribute("continent");
	%>

	<form action="submitcontinent.jsp">
		<select name="continent">
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<option><%=list.get(i)%></option>
			<%
				}
			%>
		</select> <input type="submit" />
	</form>

</body>
</html>