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
			<br>
			<h1>로 그 인</h1>
			<div>
				<form id='frm' action='login.do' method='post'>
					<table border='1'>
						<tr>
							<th width='100'>아이디</th>
							<td width='150'><input type='text' id='id' name='id' required='required'></td>
						</tr>
						<tr>
							<th width='100'>비밀번호</th>
							<td width='150'><input type='password' id='password' name='password' required='required'></td>
						</tr>
					</table>
					<input type='submit' value='로그인'> &nbsp;&nbsp;&nbsp;
					<input type='reset' value='취소'>
				</form>
			</div>
		</div>
	</div>
</body>
</html>