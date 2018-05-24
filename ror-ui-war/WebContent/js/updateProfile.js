$(document).ready(function() {

	$('#editUserId').click(function() {
		$('#userName').prop('readonly', false);
	});

	$('#editUserPassword').click(function() {
		$('#oldPassword').show();
	});

	$('#editUserEmail').click(function() {
		$('#email').prop('readonly', false);
	});
});

var request;
function checkIfPasswordMacthes() {
	var id = document.changePassword.rorUserId.value;
	var password = document.changePassword.rorUserPassword.value;
	var creds = id+"&"+password;
		var url = "https://ror-rest.herokuapp.com/rest/checkPasswordMatch/"+creds;
		if(!creds){
			return;
		}
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}

	try {
		request.onreadystatechange = getInfo;
		request.open("GET", url);
		request.send();
		console.log(request.responseText);
	} catch (e) {
		alert(e);
		alert("Unable to connect to server");
	}
}

function getInfo() {
	if (request.readyState == 4) {
		var val = request.responseText;
		if(val == 'true'){
			$('#submitDiv').show();
		}
		else{
			$('#submitDiv').hide();			
		}
	}
}