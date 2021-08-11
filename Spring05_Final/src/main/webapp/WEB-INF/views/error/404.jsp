<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404.jsp</title>
</head>
<body>
	<p>
		해당 페이지는 존재 하지 않습니다.
		<a href="${pageContext.request.contextPath}/">인덱스로 가기</a>
	</p>
</body>
</html>