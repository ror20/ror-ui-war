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

	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-black w3-card">
			<a
				class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
				href="javascript:void(0)" onclick="openNav()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="" class="w3-bar-item w3-button w3-padding-large">HOME</a> <a
				href="blogs.jsp"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">BLOGS</a>
			<a href="hotnews.jsp"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">HOT
				NEWS</a> <a href="#contact"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">CONTACT</a>
			<a href="#about"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">ABOUT</a>
		</div>
	</div>

	<!-- Navbar on small screens (remove the onclick attribute if you want the navbar to always show on top of the content when clicking on the links) -->
	<div id="navDemo"
		class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top"
		style="margin-top: 46px">
		<a href="blogs.jsp" class="w3-bar-item w3-button w3-padding-large"
			onclick="openNav()">BLOGS</a> <a href="hotnews.jsp"
			class="w3-bar-item w3-button w3-padding-large" onclick="openNav()">HOT
			NEWS</a> <a href="#contact"
			class="w3-bar-item w3-button w3-padding-large" onclick="openNav()">CONTACT</a>
		<a href="#about" class="w3-bar-item w3-button w3-padding-large"
			onclick="openNav()">ABOUT</a>
	</div>


	<div class="ror-content">
		<!-- Grid -->
		<div class="w3-row">

			<!-- Blog entries -->
			<div class="w3-col">
				<!-- Blog entry -->
				<div class="w3-card-4 w3-margin w3-white ror-card-size">
					<img src="images/grass.jpg" alt="Nature" style="width: 100%">
					<div class="w3-container">
						<h3>
							<b>LOGIN</b>
						</h3>
						<h5>Welcome To Room Of Requirement</h5>
					</div>

					<div class="w3-container">
						<p>${loginMessage}</p>
						<form action="authenticate.cont" method="post">

							<input type="text" name="rorUserId" id="userIdInput"
								class="w3-input w3-border " placeholder="User Id" maxlength="6"
								width="50%" required /><br> <input
								class="w3-input w3-border" width="100px" type="password"
								name="rorUserPassword" id="userPasswordInput"
								placeholder="Password" required /><br> <input
								id="ror-green-button" type="submit" value="Login" /> <a
								href="signup.jsp"> <input id="ror-blue-button" type="button"
								value="Sign Up" /></a> <a id="forgotPasswordLink"
								href="#forgotPasswordDiv">Forgot password.?</a> <br> <br>
							<br> <b><p class="logoutcss">${logoutMessage }</p></b>
						</form>
						<hr>
						<div id="rorBrief" class="w3-container">
							<h3>
								<b>ROR</b>
							</h3>
							<p>The Room of Requirement, the place where you need to be.
								What could be more exciting when you can blog, chat and get the
								latest news around the world all at one place.</p>
						</div>
						<div id="forgotPasswordDiv" class="w3-container">
							<center>
								<p>
									<b>Forgot Password</b>
								</p>
							</center>
							<form action="forgotPassword.cont" method="post">
								<input type="text" name="rorUserId" class="w3-input w3-border"
									placeholder="Enter the user Id" maxlength="6" width="50%"
									required /><br> <input class="ror-green-button"
									type="submit" value="Reset Password" /></a>
							</form>
						</div>
					</div>
				</div>

				<div class="w3-card-4 w3-margin w3-white ror-card-size-half">
					<img src="images/ror-aboutus-logo.jpg" class="ror-aboutus"
						alt="about Us" style="width: 100%">
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

				<div class="w3-card-4 w3-margin w3-white ror-card-size-half">
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
							For Queries and clarification, drop a mail to <a href=""
								style="color: blue">susasan27@gmail.com </a>
						</p>
					</div>

				</div>


			</div>
		</div>
	</div>
</body>
</html>
