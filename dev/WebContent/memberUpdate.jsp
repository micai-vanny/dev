<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdate.jsp</title>
</head>
<body>
	<!-- id로 수정할 회원 정보를 조회 -->
	<form action="memberSearch.do" method="post">
		ID: <input type="text" name="id"><br>
		<input type="hidden" name="job" value="update"> <!-- type이 hidden이면 화면에 안 보임 -->
		<input type="submit" value="조회">
	</form>
	
	<%
		MemberVO member = (MemberVO)request.getAttribute("member");
		if(member != null) {
			// 입력화면 출력%>
			<form action="memberUpdate.do?id=<%= member.getId() %>" method="post">
				아 이 디: <%= member.getId() %><br>
				비밀번호 : <input type="password" name="passwd" value="<%= member.getPasswd()%>"><br>
				이   름 : <input type="text" name="name" value="<%= member.getName()%>"><br>
				메   일 : <input type="text" name="mail" value="<%= member.getMail()%>"><br>
				<input type="submit" value="수정">
			</form>
	<%	} else {
			// 조회 결과가 엄슴니다 sifoot %>
			<h3>있는 걸 찾도록 해</h3>
	<%
		}
	%>
</body>
</html>