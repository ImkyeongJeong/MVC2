<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<br />
		</div>
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="home.do">Home</a></li>
				<!-- id값이 비어있으면 Login만 보여주라 (session변수 이용 세션값은 전역에서 사용할 수 있음) -->
				<c:choose>
					<c:when test = "${empty id}">
						<li><a href="loginForm.do">Login</a></li>
						<li><a href="">Join</a></li>
					</c:when>
					
					<c:otherwise>
						<li><a href="logout.do">LogOut</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="noticeSelectList.do">Notice</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Product</a></li>
				<li><a href="#">Service</a></li>
				<!-- 권한이 'ADMIN'이면 Members메뉴 보여주라 -->
				<c:if test="${author eq 'ADMIN' }">
					<li><a href="#about">Members</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>