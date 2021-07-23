<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
<div class="container">
	<h1>인덱스 페이지 입니다.</h1>
	<ul>
		<li><a href="fortune">오늘의 운세보기</a></li>
		<li><a href="${pageContext.request.contextPath}/fortune">오늘의 운세보기</a></li>
		<li><a href="ramen">오늘의 라면 보기</a></li>
	</ul>
</div>
</body>
</html>


