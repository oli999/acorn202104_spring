<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
<div class="container">
	<h1>인덱스 페이지 입니다.</h1>
	<ul>
		<li><a href="member/list.do">회원 목록 보기</a></li>
		<li><a href="todo/list.do">할일 목록 보기</a></li>
		<li><a href="json01.do">json 문자열 응답01</a></li>
		<li><a href="json02.do">json 문자열 응답02</a></li>
		<li><a href="json03.do">json 문자열 응답03</a></li>
		<li><a href="json04.do">json 문자열 응답04</a></li>
		<li><a href="json05.do">json 문자열 응답05</a></li>
		<li><a href="json06.do">json 문자열 응답06</a></li>
		<li><a href="json07.do">json 문자열 응답07</a></li>
		<li><a href="xml01.do">xml 문자열 응답01</a></li>
		<li><a href="xml02.do">xml 문자열 응답02</a></li>
		<li><a href="xml03.do">xml 문자열 응답03</a></li>
	</ul>
	<h2>공지사항</h2>
	<ul>
		<c:forEach var="tmp" items="${notice }">
			<li>${tmp }</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>

