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
		<li><a href="upload_test.do">파일 업로드 테스트</a></li>
	</ul>
	<h2>공지사항</h2>
	<ul>
		<c:forEach var="tmp" items="${notice }">
			<li>${tmp }</li>
		</c:forEach>
	</ul>
	<h2>ajax 테스트</h2>
	<input type="text" placeholder="서버에 할말 입력..." id="msg"/>
	<button type="submit" id="sendBtn">전송</button>
</div>
<script src="${pageContext.request.contextPath}/resources/js/gura_util.js"></script>
<script>
	/* 
		위에 전송 버튼을 눌렀을때  input 요소에 입력한 문자열을 서버에(JsonTestController) 전송하고  
		{"isSuccess":true}
		형식의 json 문자열을 서버에서 받는 프로그래밍을 해 보세요 
	*/
	document.querySelector("#sendBtn").addEventListener("click", function(){
		let msg=document.querySelector("#msg").value;
		
		ajaxPromise("${pageContext.request.contextPath}/send.do", "post", "msg="+msg)
		.then(function(response){
			return response.json();
		})
		.then(function(data){
			console.log(data);
		});
	});
</script>
</body>
</html>








