<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/shop/buy.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h1>상품 구매 결과 페이지</h1>
	<p><strong>${id }</strong> 님 상품을 정상적으로 주문 했습니다.</p>
	<a href="list.do">상품 목록보기</a>
</div>
</body>
</html>







