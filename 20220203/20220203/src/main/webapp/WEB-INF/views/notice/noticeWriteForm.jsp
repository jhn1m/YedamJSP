<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align='center'>
		<div>
			<h1>공지사항 글쓰기</h1>
		</div>
		<form id='frm' action='noticeWrite.do' method='post'>
			<table border='1'>
				<tr>
					<th width='100'>작성자</th>
					<td width='150'><input type='text' readonly id='noticeWriter' name='noticeWriter' value='${name}'></td>
					<th width='100'>작성일자</th>
					<td width='150'><input type='date' id='noticeDate' name='noticeDate'></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan='3'><input type='text' size='40' id='noticeTitle' name='noticeTitle'>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan='3'>
					<textarea cols='100' rows='10' id='noticeSubject' name='noticeSubject'></textarea>
					</td>
				</tr>
			</table>
			<br>
			<input type='submit' value='등록'>&nbsp;&nbsp;&nbsp;
			<input type='reset' value='취소'>&nbsp;&nbsp;&nbsp;
			<input type='button' value='목록' onclick='location.href="noticeList.do"'>
		</form>
	</div>
<script>
	document.getElementById('noticeDate').value = new Date().toISOString().substring(0,10);
</script>
</body>
</html>