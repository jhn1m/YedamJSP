<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">

		<div>
			<h1>공지사항 목록</h1>
		</div>
		<div>
			<table border='1'>
				<thead>
					<tr>
						<th width="50">글번호</th>
						<th width="250">제목</th>
						<th width="150">작성자</th>
						<th width="150">날짜</th>
						<th width="70">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${notices}" var="notice">
						<tr onmouseover='this.style.background="#fcecae";'
							onmouseleave='this.style.background="";'
							onclick="noticeSelect(${notice.noticeId})">
							<td align="center">${notice.noticeId}</td>
							<td width="250">${notice.noticeTitle}</td>
							<td align="center">${notice.noticeWriter}</td>
							<td align="center">${notice.noticeDate}</td>
							<td align="center">${notice.noticeHit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br>
		<div>
			<c:if test="${not empty id}">
				<button type='button' onclick='location.href="noticeWriteForm.do"'>글쓰기</button>
			</c:if>
		</div>
	</div>
	<br>
	<div>
		<form id='frm' action='noticeSelect.do' method='post'>
			<input type='hidden' id='noticeId' name='noticeId' value='noticeId'>
		</form>
	</div>

	<script>
	function noticeSelect(id){ // 선택된 행의 세부내역을 보기 위한 함수
		frm.noticeId.value = id;
		frm.submit();
	}	
</script>

</body>

</html>
