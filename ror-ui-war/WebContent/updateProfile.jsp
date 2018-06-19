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
<link rel="stylesheet" href="css/updateProfile.css">
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/updateProfile.js"></script>
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
				href="profile.cont"
				class="w3-bar-item w3-button w3-padding-large">HOME</a> <a
				href="logout.cont"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small w3-right"
				onclick="openNav()">LOGOUT</a>
		</div>
	</div>

	<!-- Navbar on small screens (remove the onclick attribute if you want the navbar to always show on top of the content when clicking on the links) -->
	<div id="navDemo"
		class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top"
		style="margin-top: 46px">
		<a href="logout.cont" class="w3-bar-item w3-button w3-padding-large"
			onclick="openNav()">LOGOUT</a>
	</div>

	<div class="w3-card-4 w3-margin w3-white ror-card-signup-size">
		<img src="images/ror-update-nature-image.jpg" class="ror-update-image"
			alt="update-nature-image" style="width: 100%; margin-top: 10px;">
		<div id="myProfile" class="w3-container">
			<hr>
			<h3>
				<b>My Profile</b>
			</h3>
		</div>

		<div class="w3-container">
			<p>Click on the edit button to edit the profile details.</p>
		</div>

		<div class="update-form">
			<form name="updateForm" action="updateUser.cont" method="post">
				<table border="0">
					<input type="hidden" name="rorUserId" id="userIdInput"
						maxlength="6" value="${rorUserId }" required />
					<br>
					<tr>
						<td><p>
								<b>User Name:<b></b>
									<p></td>
					</tr>
					<tr>
						<td><input type="text" id="userName" name="userName"
							class="w3-input" readonly="" placeholder="Enter the User Name"
							value="${rorUserName }" required /></td>
						<td><input type="button" id="editUserId"
							class="ror-edit-blue-button" value="EDIT" /></td>
					</tr>
					<tr>
						<td><p>
								<b>User Email:<b></b>
									<p></td>
					</tr>
					<tr>

						<td><input type="email" id="email" name="email"
							class="w3-input" readonly=""
							placeholder="Enter the Email address" value="${email }" required /></td>
						<td><input type="button" id="editUserEmail"
							class="ror-edit-blue-button" value="EDIT" /></td>
					</tr>
					<tr>
						<td><br> <input type="submit" class="ror-update-button"
							name="update" value="Update"><br></td>
					</tr>
					<tr>
					
						<td><input type="button" id="editUserPassword"
							class="ror-changePassword-button" value="changePassword" /></td>
					</tr>
				</table>
				<b>${updateMessage }</b>
			</form>
			
			<div id="oldPassword">
				<p>
					<b>User must enter the old password in order to Reset.</b>
				</p>
				<form name="changePassword" method="post"
					action="changePassword.cont">
					<input type="hidden" name="rorUserId" id="userIdInput"
						placeholder="User Id" maxlength="6" value="${rorUserId }" required />
					<table border="0">
						<tr>
							<td><input type="password" id="rorUserPassword"
								onkeyup="checkIfPasswordMacthes()" name="rorUserPassword"
								class="w3-input" placeholder="Enter the Old Password" required /></td>
							<td>
								<div id="submitDiv">
									<input type="submit" class="ror-green-change-button"
										name="oldPasswordCheck" value="Change">
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<p>
				<b>${changePasswordStatus }</b>
			</p>

		</div>

	</div>
</body>
</html>