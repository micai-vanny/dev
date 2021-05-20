<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInsert.jsp</title>
</head>
<body>
	<h3>회원가입 페이지</h3>
			<!--  ┌>web.xml에 .do로 끝나면 front로 가도록 설정해놈 -->
	<form action="memberInsert.do" method="post">
		아 이 디: <input type= "text" name="id"><br>
		비밀번호 : <input type="password" name="passwd"><br>
		이   름 : <input type="text" name="name"><br>
		메   일 : <input type="text" name="mail"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>