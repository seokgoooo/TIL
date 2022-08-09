<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>국가 목록</title>
</head>
<body>
	<%
		//  자바랑 DB랑 HTML이랑 왔다리 갔다리 한 페이지에 다 적으려다 보니 코드가 난잡하고 유지보수할 때 답이 안나온다
	// 그래서 부분 부분 별로 나눠보자
	// selectworld.jsp / viewcountry.jsp 
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	out.println("<ul>");
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT name FROM country");

		while (rs.next()) {
			String name = rs.getString("name");
			out.println("<li>" + name + "</li>");
		}
	} finally {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	out.println("</ul>");
	%>

</body>
</html>