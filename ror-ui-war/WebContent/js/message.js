var request;
function searchUser() {
	var v = document.searchUserForm.userName.value;
	var url = "http://localhost:8080/ror-rest-war/rest/searchUser/" + v;
	if (!v) {
		return;
	}
	if(v==''){
		$('#userTable').hide();
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
	} catch (e) {
		alert(e);
		alert("Unable to connect to server");
	}
}

function getInfo() {
	if (request.readyState == 4) {
		var val = request.responseText;
		console.log(val);
		var jsonObj = JSON.parse(request.responseText);
		console.log(jsonObj);
		var obj;

		
		var x = document.createElement("TABLE");
		x.setAttribute("id", "userTable");
		document.body.appendChild(x);
		var i;
		//for (obj in jsonObj) {
		for(i=0;i<jsonObj.length;i++){
			console.log(jsonObj[i]);
			var y = document.createElement("TR");
			y.setAttribute("id", "myTr");
			document.getElementById("userTable").appendChild(y);

			var z = document.createElement("TD");
			var t = document.createTextNode(jsonObj[i].userName);
			z.appendChild(t);
			document.getElementById("myTr").appendChild(z);
			
			var z1 = document.createElement("TD");
			var t1 = document.createTextNode(jsonObj[i].userId);
			z1.appendChild(t1);
			document.getElementById("myTr").appendChild(z1);

		}
		
		document.getElementById("userTableDiv").innerHTML = document.getElementById("userTable");

		/*
		 * if(val == 'true'){ document.getElementById('status').innerHTML = 'Not
		 * available'; $('#status').css('color', 'red'); } else{
		 * document.getElementById('status').innerHTML = 'available';
		 * $('#status').css('color', 'green'); }
		 */
	}
}