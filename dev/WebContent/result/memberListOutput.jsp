<%@page import="com.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소중한 우리 횐님덜☆</title>
</head>
<body>
	<h3>회원 리스트 조회</h3>
	
	<c:choose>
		<c:when test="${empty list }">
			<p>이게 머선 129...<br>횐님덜이 하나도 없누 ㅠ</p>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${list }" var= "member">
					<li>${member.id } | ${member.name }</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	<a href = "index.jsp">돌아가기</a>
		<%--
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
		
		
		} else {
			for(MemberVO member : list){
				
			}
		}
	--%>

</body>
</html>