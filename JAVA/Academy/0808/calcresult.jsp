<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산</title>
</head>
<body>
	<%
		String one = request.getParameter("number1");
	String two = request.getParameter("number2");
	int oneToInt = Integer.parseInt(one);
	int twoToInt = Integer.parseInt(two);

	String ex = request.getParameter("operator");
	if (ex.equals("1")) {
		out.println(oneToInt + twoToInt);
	} else if (ex.equals("2")) {
		out.println(oneToInt - twoToInt);
	} else if (ex.equals("3")) {
		out.println(oneToInt * twoToInt);
	} else if (ex.equals("4")) {
		out.println(oneToInt / twoToInt);
	}
	%>
</body>
</html>