<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/login.jsp</title>
</head>
<body>
<div class="container">
	<h1>알림</h1>
	<c:choose>
		<c:when test="${not empty sessionScope.id }">
			<p>
				<strong>${sessionScope.id }</strong>님 로그인 되었습니다.
				<a href="${requestScope.url }">확인</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				아이디 혹은 비밀 번호가 틀려요
				<a href="loginform.do?url=${requestScope.encodedUrl }">다시 시도</a>
			</p>
		</c:otherwise>
	</c:choose>
</div>	
</body>
</html>





