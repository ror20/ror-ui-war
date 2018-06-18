<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/index.js"></script>
<title>Room Of Requirement</title>
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>
</head>
<body class="w3-light-grey">

	<div class="w3-top">
		<div class="w3-bar w3-black w3-card">
			<a
				class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
				href="javascript:void(0)" onclick="openNav()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="sampleLogin.jsp"
				class="w3-bar-item w3-button w3-padding-large">HOME</a>
		</div>
	</div>

	<!-- Navbar on small screens (remove the onclick attribute if you want the navbar to always show on top of the content when clicking on the links) -->
	<div id="navDemo"
		class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top"
		style="margin-top: 46px">
		<a href="blogs.jsp" class="w3-bar-item w3-button w3-padding-large"
			onclick="openNav()">BLOGS</a> <a href="hotnews.jsp"
			class="w3-bar-item w3-button w3-padding-large" onclick="openNav()">HOT
			NEWS</a> <a href="sampleLogin.jsp#contact"
			class="w3-bar-item w3-button w3-padding-large" onclick="openNav()">CONTACT</a>
		<a href="sampleLogin.jsp#about"
			class="w3-bar-item w3-button w3-padding-large" onclick="openNav()">ABOUT</a>
	</div>

	<!--Sign Up Form  -->
	<div class="w3-card-4 w3-margin w3-white ror-card-signup-size">
		<img src="images/ror-flower.jpg" class="ror-aboutus" alt="about Us"
			style="width: 100%; margin-top: 10px;">
		<div id="about" class="w3-container">
			<hr>
			<h3>
				<b>Sign Up</b>
			</h3>
		</div>

		<div class="w3-container">
			<p>Let's get you started! Please fill in the below form</p>
		</div>

		<div class="sign-up-form">
		<center><p><b>Register to become a ROR User today!</b></p></center>
		<form name="signupform" action="storeUser.cont" method="post">
			<input type="text" id="userName" name="userName" class="w3-input" placeholder="Enter the User Name" value="${userName }" required /><br>
			<input type="text" id="rorUserId" name="rorUserId" class="w3-input" placeholder="Enter the User Id" value="${rorUserId }" minlength="6" maxlength="6"	onkeyup="checkUserIdIFExist()" title="Enter 6 digit user id" required />
			<span id="status"> </span><br>
			<input type="email" id="email" name="email" class="w3-input" placeholder="Enter the Email address" value="${email }" required /><br>
			<input type="password" id="rorUserPassword" name="rorUserPassword" class="w3-input" placeholder="Enter the Password" required /><br>
			<input type="password" id="repassword" name="repassword" class="w3-input" placeholder="ReEnter the Password" required />
			<span id='message' name="span"></span><br>
			<div id="submitDiv">
			<input type="submit" class="ror-green-button" name="register" value="Register"><br>
			</div><br>
			<b>${signUpMessage }</b>
		</form>
		
		</div>

	</div>
</body>
</html>