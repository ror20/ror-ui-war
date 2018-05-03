<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Room Of Requirements</title>
</head>
<body>
	<div class="w3-right" style="margin-right: 10px;">
		<a href="logout.cont" >Logout</a>
	</div>
	<h1>Hello ${rorUserName}</h1>
	<input type="hidden" value="${rorUserName}">
</body>
</html>