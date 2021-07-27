<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/upload_test.jsp</title>
</head>
<body>
	<h1>파일 업로드 테스트</h1>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		제목 <input type="text" name="title"/>
		<br />
		첨부 파일 <input type="file" name="myFile"/>
		<br />
		<button type="submit">업로드</button>
	</form>
</body>
</html>