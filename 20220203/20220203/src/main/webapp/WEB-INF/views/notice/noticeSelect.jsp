<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>공지사항 내용</h1>
		</div>
		<div>
			<table border='1'>
				<tbody>
					<tr>
						<th width='70'>작성자</th>
						<td width='100' align='center'>${notice.noticeWriter}</td>
						<th width='70'>작성일자</th>
						<td width='150' align='center'>${notice.noticeDate}</td>
						<th width='70'>조회수</th>
						<td width='30' align='center'>${notice.noticeHit}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan='5'>${notice.noticeTitle}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan='5'>
						<textarea cols='100' rows='10'>${notice.noticeSubject}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
			<button type='button' onclick='location.href="noticeList.do"'>목록</button>
			&nbsp;&nbsp;&nbsp;
	</div>
</body>
</html>