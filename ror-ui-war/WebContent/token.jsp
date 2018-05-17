<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Of Requirement</title>
</head>
<body>
	<form action="tokenCheck.cont" method="post">
		<input type="hidden" name="rorUserId" id="userIdInput"  placeholder="User Id" maxlength="6" value="${rorUserId }"	width="50%" required /><br>
		<input type="text" name= "userToken" id="userToken" placeholder="Enter the security token" required /><b>${tokenStatusMessage }</b>
		<br>
		<input type="submit" value="Check Token">
	</form>
</body>
</html>