<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500.jsp</title>
</head>
<body>
	<p>
		요청처리중에 오류가 발생했습니다. 조속히 복구 하겠습니다.
		<a href="${pageContext.request.contextPath}/">인덱스로 가기</a>
	</p>
</body>
</html>