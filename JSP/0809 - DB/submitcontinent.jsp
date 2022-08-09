
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<%
	Class.forName("com.mysql.cj.jdbc.Driver");

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
List<String> listName = new ArrayList<>();
List<Integer> listPopulation = new ArrayList<>();

try {
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
	pstmt = conn.prepareStatement("SELECT name, population FROM country WHERE Continent = ? ORDER BY Population DESC");
	pstmt.setString(1, request.getParameter("continent"));
	rs = pstmt.executeQuery();

	while (rs.next()) {
		String name = rs.getString("name");
		int population = rs.getInt("population");
		listName.add(name);
		listPopulation.add(population);
	}
} finally {
	if (rs != null) {
		rs.close();
	}
	if (pstmt != null) {
		pstmt.close();
	}
	if (conn != null) {
		conn.close();
	}
}

request.setAttribute("name", listName);
request.setAttribute("population", listPopulation);
request.getRequestDispatcher("result.jsp").forward(request, response);
%>