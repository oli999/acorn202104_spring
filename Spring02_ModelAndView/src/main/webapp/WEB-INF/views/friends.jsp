<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/friends.jsp</title>
</head>
<body>
<div class="container">
	<h1>친구 목록 입니다.</h1>
	<ul>
		<c:forEach var="tmp" items="${names }">
			<li>${tmp }</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>