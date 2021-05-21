<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result/memberUpdateOutput.jsp</title>
</head>
<body>
	<h3>수정결과</h3>
	<p>${member.name }님의 정보가 수정되었습니다.</p>
	<p>${member.id } | ${member.mail }</p>
	<a href = "index.jsp">돌아가기</a>
</body>
</html>