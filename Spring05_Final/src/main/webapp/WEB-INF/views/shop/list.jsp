<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/shop/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${empty id }">
			<p>
				<a href="${pageContext.request.contextPath }/users/loginform.do">로그인</a>
				<a href="${pageContext.request.contextPath }/users/signup_form.do">회원가입</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				<strong>${id }</strong> 님 로그인중...
			</p>
		</c:otherwise>
	</c:choose>
	<h1>상품 목록 입니다.</h1>
	<div class="row">
		<c:forEach var="tmp" items="${list }">
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="${pageContext.request.contextPath }/resources/images/image1.png"/>
					<div class="card-body">
						<h3 class="card-title">${tmp.name }</h3>
						<p class="card-text">
							가격 : <strong>${tmp.price }</strong>원 <br/>
							재고 : <strong>${tmp.remainCount }</strong>개
						</p>
						<a href="buy.do?num=${tmp.num }" class="card-link">구입하기</a>
					</div>
				</div>
			</div>		
		</c:forEach>
	</div>
</div>
</body>
</html>





