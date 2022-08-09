
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	// DB 연결
// SELECT

Class.forName("com.mysql.cj.jdbc.Driver");

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
List<String> list = new ArrayList<>();

try {
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
	stmt = conn.createStatement();
	rs = stmt.executeQuery("SELECT name FROM country");

	while (rs.next()) {
		String name = rs.getString("name");
		list.add(name);
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

// request 객체에 list를 attribute로 설정하기
request.setAttribute("countries", list);
// 다음 페이지로 forward 시키기
request.getRequestDispatcher("viewcountry.jsp").forward(request, response);
%>
