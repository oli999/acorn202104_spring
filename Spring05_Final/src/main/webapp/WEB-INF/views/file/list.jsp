<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/list.jsp</title>
<style>
	.page-ui a{
		text-decoration: none;
		color: #000;
	}
	
	.page-ui a:hover{
		text-decoration: underline;
	}
	
	.page-ui a.active{
		color: red;
		font-weight: bold;
		text-decoration: underline;
	}
	.page-ui ul{
		list-style-type: none;
		padding: 0;
	}
	
	.page-ui ul > li{
		float: left;
		padding: 5px;
	}
</style>
</head>
<body>
<div class="container">
	<a href="upload_form.do">업로드 하러가기</a>
	<h1>자료실 목록입니다.</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자(업로더)</th>
				<th>제목(설명)</th>
				<th>파일명(원본파일명)</th>
				<th>파일크기</th>
				<th>등록일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="tmp" items="${requestScope.list}">
			<tr>
				<td>${tmp.num }</td>
				<td>${tmp.writer }</td>
				<td>${tmp.title }</td>
				<td><a href="download.do?num=${tmp.num }">${tmp.orgFileName }</a></td>
				<td>${tmp.fileSize } byte</td>
				<td>${tmp.regdate }</td>
				<td>
					<c:if test="${tmp.writer eq id }">
						<a href="javascript:deleteConfirm(${tmp.num })">삭제</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="page-ui clearfix">
		<ul>
			<c:if test="${startPageNum ne 1 }">
				<li>
					<a href="list.do?pageNum=${startPageNum-1 }&condition=${condition }&keyword=${encodedK }">Prev</a>
				</li>
			</c:if>
			<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<li>
					<c:choose>
						<c:when test="${pageNum eq i }">
							<a class="active" href="list.do?pageNum=${i }&condition=${condition }&keyword=${encodedK}">${i }</a>
						</c:when>
						<c:otherwise>
							<a href="list.do?pageNum=${i }&condition=${condition }&keyword=${encodedK}">${i }</a>
						</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
			<c:if test="${endPageNum lt totalPageCount}">
				<li>
					<a href="list.do?pageNum=${endPageNum+1 }&condition=${condition }&keyword=${encodedK }">Next</a>
				</li>
			</c:if>
		</ul>
	</div>
	
	<div style="clear:both;"></div>
	
	<form action="list.do" method="get"> 
		<label for="condition">검색조건</label>
		<select name="condition" id="condition">
			<option value="title_filename" ${condition eq 'title_filename' ? 'selected' : '' }>제목+파일명</option>
			<option value="title" ${condition eq 'title' ? 'selected' : '' }>제목</option>
			<option value="writer" ${condition eq 'writer' ? 'selected' : '' }>작성자</option>
		</select>
		<input type="text" id="keyword" name="keyword" placeholder="검색어..." value="${keyword }"/>
		<button type="submit">검색</button>
	</form>	
	<c:if test="${not empty condition }">
		<p>
			<strong>${totalRow }</strong> 개의 자료가 검색 되었습니다.
		</p>
	</c:if>
</div>
<script>
	function deleteConfirm(num){
		const isDelete=confirm(num+" 번 자료를 삭제 하겠습니까?");
		if(isDelete){
			location.href="delete.do?num="+num;
		}
	}
</script>
</body>
</html>

