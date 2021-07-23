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
	
	<form action="test/send.do" method="post">
		<input type="text" name="msg" placeholder="메세지 입력..."/>
		<button type="sumbit">전송</button>
	</form>
	
	<form action="test/send2.do" method="post">
		<input type="text" name="msg" placeholder="메세지 입력..."/>
		<button type="sumbit">전송</button>
	</form>	
	
	<ul>
		<li><a href="test/buy.do?code=1">1번 상품 구입하기</a></li>
		<li><a href="test/buy.do?code=2">2번 상품 구입하기</a></li>
		<li><a href="test/buy.do">아무 상품이나 구입하기</a></li>
	</ul>

	<h2>회원 등록 폼</h2>
	<form action="test/insert.do" method="post">
		<input type="text" name="num" placeholder="번호"/>
		<input type="text" name="name" placeholder="이름"/>
		<input type="text" name="addr" placeholder="주소"/>
		<button type="submit">등록</button>
	</form>

	<h2>공지사항</h2>
	<ul>
		<c:forEach var="tmp" items="${notice }">
			<li>${tmp }</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>

