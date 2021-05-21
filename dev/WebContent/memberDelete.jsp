<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- id로 삭제할 회원 정보를 조회 -->
	<form action="memberSearch.do" method="post">
		ID: <input type="text" name="id"><br>
		<input type="hidden" name="job" value="delete"> <!-- type이 hidden이면 화면에 안 보임 -->
		<input type="submit" value="조회">
	</form>

	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		
		if(member != null){
			//조회결과반영 %>
		<p>ID: <%=member.getId() %> | 이름: <%=member.getName() %>님 정말 영 가시나여 ㅠ?</p>
		<form action="memberDelete.do" method= "post">
			<input type ="hidden" name="id" value="<%=member.getId() %>">
			<input type = "submit" value="삭제">
		</form>	
	<%		
			
		} else {
			//조회 결과 없음 %>
			<h3>너 이 sekki 누구야</h3>
	<%
		}
	%>
</body>
</html>