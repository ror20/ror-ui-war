<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="images/RORLogo.png" />
<link rel="stylesheet" href="css/index.css">
<title>Room Of Requirements</title>
</head>
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
}

table, td {
    border: 1px solid black;
}

#messageContainer {
	border: solid 2px;
	border-color: grey;
	margin-top: 85px;
	margin-left: 45px;
	width: 75%;
}
</style>
<script type="text/javascript" src="js/message.js"></script>
<body class="w3-theme-l5">

	<div class="w3-top">
		<div class="w3-bar w3-theme-d2 w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2"
				href="javascript:void(0);" onclick="openNav()"><i
				class="fa fa-bars"></i></a>
			<div class="w3-bar-item w3-button w3-padding-large w3-theme-d4">
				<i class="fa fa-home w3-margin-right"></i>Room Of Requirement
			</div>

		</div>
	</div>

	<div id="navDemo"
		class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Home</a> <a
			href="updateProfile.cont"
			class="w3-bar-item w3-button w3-padding-large w3-black">${rorUserName}(My
			Profile)</a> <a href="#" class="w3-bar-item w3-button w3-padding-large">Blogs</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Hot
			News</a> <a href="#" class="w3-bar-item w3-button w3-padding-large">Contest</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">About
			us</a> <a href="logout.cont"
			class="w3-bar-item w3-button w3-padding-large">Logout</a>
	</div>

	<div id="messageContainer">

		<form id="searchUserFormContainer" name="searchUserForm" method="post">
			<input type="text" name="userName" id="userName" class="w3-input"
				placeholder="Search User" maxlength="20" onkeyup="searchUser()"
				required /><br>
		</form>
		<div id="userTableDiv">
		</div>
	</div>



</body>
</html>