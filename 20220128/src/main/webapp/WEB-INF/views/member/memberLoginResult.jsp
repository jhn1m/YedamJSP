<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Web Site</title>
</head>
<body>
	<div align="center">
		<jsp:include page="../main/header.jsp"></jsp:include>
		<div>
			<h1>${message }</h1>
		</div>
	</div>
</body>
</html>