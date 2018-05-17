function openNav() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

var request;
function checkUserIdIFExist() {
	var v = document.signupform.rorUserId.value;
		var url = "https://ror-rest.herokuapp.com/rest/checkUserExist/"
				+ v;
		if(!v){
			return;
		}
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}

	try {
		request.onreadystatechange = getInfo;
		request.open("GET", url, true);
		request.send();
	} catch (e) {
		alert("Unable to connect to server");
	}
}

function getInfo() {
	if (request.readyState == 4) {
		var val = request.responseText;
		if(val == 'true'){
			document.getElementById('status').innerHTML = 'Not available';
			$('#status').css('color', 'red');
		}
		else{
			document.getElementById('status').innerHTML = 'available';
			$('#status').css('color', 'green');
		}
	}
}

 $('#rorUserPassword, #repassword').on('keyup', function() {
	if(!$('#repassword').val()){
		return;
	}
	if ($('#rorUserPassword').val() == $('#repassword').val()) {
		$('#message').html('Matching').css('color', 'green');
		$('#submitDiv').show();
	} else{
		$('#message').html('Not Matching').css('color', 'red');
	$('#submitDiv').hide();
	}
});
 


$('#forgotPasswordLink').click(function(){
	$('#forgotPasswordDiv').show();
});
 