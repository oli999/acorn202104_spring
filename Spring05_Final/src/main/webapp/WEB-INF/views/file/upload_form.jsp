<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/upload_form.jsp</title>
</head>
<body>
<div class="container">
	<h1>파일 업로드 폼 입니다.</h1>
	<form action="${pageContext.request.contextPath}/file/upload.do" method="post" enctype="multipart/form-data">
		<div>
			<label for="title">제목</label>
			<input type="text" name="title" id="title"/>
		</div>
		<div>
			<label for="myFile">첨부파일</label>
			<input type="file" name="myFile" id="myFile"/>
		</div>
		<button type="submit">업로드</button>
	</form>
</div>
</body>
</html>