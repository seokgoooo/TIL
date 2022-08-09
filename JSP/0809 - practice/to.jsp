<!--
입력값에 따라 페이지 이동
a페이지 : 현재 서버 시간 표시
b페이지 : 현재 서버 날짜 표시
c페이지 : 랜덤 정수 숫자
 -->

<%@page import="java.util.Random"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%
	String alphabet = request.getParameter("alphabet");
if (alphabet.equals("a")) {
	request.setAttribute("result", LocalTime.now());
	request.getRequestDispatcher("A.jsp").forward(request, response);
} else if (alphabet.equals("b")) {
	request.setAttribute("result", LocalDate.now());
	request.getRequestDispatcher("B.jsp").forward(request, response);
} else if (alphabet.equals("c")) {
	Random r = new Random();
	request.setAttribute("result", r.nextInt());
	request.getRequestDispatcher("C.jsp").forward(request, response);
}
%>
