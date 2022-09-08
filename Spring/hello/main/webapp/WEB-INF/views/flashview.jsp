<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>포워드 : ${ fowardtest }</p>
	<p>리다이렉트 : ${ redirecttest }</p>
	<!--
	 스프링에서 model 값을 이거 쓸려고 보낸거 아니니? 라고 판단해서	 
	  parameter로 알아서 보내버린다
	그래서 이 값을 쓰려면 param에서 꺼내와야 한다.
	 -->
	<p>파람 : ${ param.redirecttest }</p>

</body>
</html>