<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>
<!-- EL표현식 : server에서 담은 값 사용 / ${name} : ${id} : ${password}  mybatis는 #{} -->
	<c:forEach items="${students}" var="s">
		${s.studentId} : ${s.name} : ${s.address} <br>
	</c:forEach>
</body>
</html>