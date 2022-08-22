<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
	<form>
		<input type="text" name="id" id="textid" />
		<button id="btnchk">아이디 중복확인</button>
		<input type="submit" />
	</form>
</body>
<script>
	let elem = document.getElementById("btnchk");
	elem.addEventListener("click", function(e) {
		e.preventDefault();
		e.stopPropagation();
		let textid = document.getElementById("textid").value;

		if (!textid) {
			return;
		}

		/* 
		AJAX (비동기) 로 요청을 날려보자
		AJAX에는 XMLHttpRequest 객체가 필요하다. 근데 사용법이 어렵다
		그래서 Fetch API를 사용해보자
		 */

		fetch("http://localhost:8080/api/idcheck?id=" + textid)
		.then((resp) => resp.text())
		.then((json) => {
			let result = JSON.parse(json);
			if (result.duplicate) {
				alert("중복");
			} else {
				alert("사용 가능");
			}
		})
		.catch((e) => console.log(e));
	});
</script>
</html>