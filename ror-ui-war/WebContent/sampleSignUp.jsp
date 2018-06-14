<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" 	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
			<a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
				href="javascript:void(0)" onclick="openNav()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="sampleLogin.jsp" class="w3-bar-item w3-button w3-padding-large">HOME</a>
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
		<a href="sampleLogin.jsp#about" class="w3-bar-item w3-button w3-padding-large"
			onclick="openNav()">ABOUT</a>
	</div>
	
	<!--Sign Up Form  -->
	<div class="w3-card-4 w3-margin w3-white ror-card-size-half">
		<img src="images/ror-flower.jpg" class="ror-aboutus"
			alt="about Us" style="width: 100%;margin-top: 10px;">
		<div id="about" class="w3-container">
			<hr>
			<h3>
				<b>Sign Up</b>
			</h3>
		</div>

		<div class="w3-container">
			<p>Let's get you started! Please fill in the below form</p>
		</div>


	</div>
</body>
</html>