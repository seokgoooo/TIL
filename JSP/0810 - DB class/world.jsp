<%@page import="java.util.List"%>
<%@page import="kr.co.greenart.Country"%>
<%@page import="kr.co.greenart.CountryDAO"%>
<%
	// JAVA 코드만 담는 Class로 만들어서 관리를 해줄 수가 있다.
CountryDAO dao = new CountryDAO();
String continent = request.getParameter("continent");
List<Country> list = dao.getCountryByContinent(continent);

request.setAttribute("list", list);
request.getRequestDispatcher("result.jsp").forward(request, response);
%>