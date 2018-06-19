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
<link rel="stylesheet" href="css/profile.css">
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
				class="w3-bar-item w3-button w3-padding-large">HOME</a><a
				href="updateProfile.cont"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">MY PROFILE</a><a
				href="blogs.jsp"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">BLOGS</a>
			<a href="hotnews.jsp"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">HOT
				NEWS</a> <a href="#contact"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">CONTACT</a>
			<a href="#about"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">ABOUT</a>
			<a href="logout.cont"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small w3-right"
				onclick="openNav()">LOGOUT</a>
		</div>
	</div>
	

	<!-- Navbar on small screens (remove the onclick attribute if you want the navbar to always show on top of the content when clicking on the links) -->
	<div id="navDemo"
		class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top"
		style="margin-top: 46px">
		<a href="updateProfile.cont"
			class="w3-bar-item w3-button w3-padding-large" onclick="openNav()">MY PROFILE</a>
		<a href="blogs.jsp" class="w3-bar-item w3-button w3-padding-large"
			onclick="openNav()">BLOGS</a> <a href="hotnews.jsp"
			class="w3-bar-item w3-button w3-padding-large" onclick="openNav()">HOT
			NEWS</a> <a href="#contact"
			class="w3-bar-item w3-button w3-padding-large" onclick="openNav()">CONTACT</a>
		<a href="#about" class="w3-bar-item w3-button w3-padding-large"
			onclick="openNav()">ABOUT</a> <a href="logout.cont"
			class="w3-bar-item w3-button w3-padding-large" onclick="openNav()">LOGOUT</a>
	</div>

	<div class="w3-card-4 w3-margin w3-white ror-card-size-profile">
		<div class="profileLayout">
			<p class="helloUserName">
				<b> Hello ${rorUserName }! </b>
			</p>
			<div class="profileDescription">
				<p>
					<b>Welcome to the Room Of Requirement.</b>
				</p>
				<center><p class="profile-message"><b>${profileMessage }</b></p></center>
			</div>
			
		</div>

	</div>

	<div class="w3-card-4 w3-margin w3-white ror-card-size-half">
		<img src="images/ror-aboutus-logo.jpg" class="ror-aboutus"
			alt="about Us" style="width: 100%; margin-top: 10px;">
		<div id="about" class="w3-container">
			<hr>
			<h3>
				<b>ABOUT US</b>
			</h3>
		</div>

		<div class="w3-container">
			<p>We are a bunch of developers who love to code,learn and
				develop new products that aid people around the globe.</p>
		</div>
	</div>

	<div class="w3-card-4 w3-margin w3-white ror-card-size-full">
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6536.712556782325!2d77.62296947932298!3d13.051417261773768!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae1765b5eaaaab%3A0x7e080adef1489e8d!2sCognizant+Technology+Solutions+Pvt+Ltd!5e0!3m2!1sen!2sin!4v1528886556058"
			width="100%" height="450" frameborder="0" style="border: 0"
			allowfullscreen></iframe>
		<!-- <img src="images/ror-aboutus-logo.jpg" class ="ror-aboutus" alt="about Us" style="width: 100%" > -->
		<div id="about" class="w3-container">
			<hr>
			<h3 id="contact">
				<b>CONTACT</b>
			</h3>
		</div>

		<div class="w3-container">
			<p>
				For Queries and clarification, drop a mail to <a 
					style="color: blue">susasan27@gmail.com </a>
			</p>
		</div>

	</div>
</body>
</html>