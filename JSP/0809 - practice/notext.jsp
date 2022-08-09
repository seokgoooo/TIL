
<%
	int result = 1 + 1;
// 이 페이지에서 viewPage 로 result 를 보여주는 방법
// 1. parameter로 넘겨서 request.getParameter로 얻는다.
// response.sendRedirect("./viewPage.jsp?result=" + result);

// 2. application에 setAttribute
application.setAttribute("result", result);
// response.sendRedirect("./viewPage.jsp");

// 3. 두개의 jsp 흐름을 하나로 합치는 forward 이용
request.setAttribute("result", result);
request.getRequestDispatcher("/WEB-INF/viewPage.jsp").forward(request, response);
%>