<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearch.jsp jyp</title>
</head>
<body>
	<h3>회원정보검색</h3>
	<form action="memberSearch.do" method="post">
		ID: <input type="text" name="id"><br>
		<input type="hidden" name="job" value="search"> <!-- type이 hidden이면 화면에 안 보임 -->
		<input type="submit" value="조회">
	</form>
</body>
</html>