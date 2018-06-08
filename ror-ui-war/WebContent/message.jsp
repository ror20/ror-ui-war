<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

	<form id="messageId" name="messageName" method="post">
		<input type="hidden" id="fromUserId" name="fromUserId" value="574385">
		<input type="hidden" id="toUserId" name="toUserId" value="574372">
		<input type="hidden" id="messageSentTime" name="messageSentTime"
			value="1111"> Message:<input id="message" type="text"
			name="message" size="60" placeholder="Message" required /> <input
			type="button" id="button" value="Submit" />
	</form>
	<span id="state"></span>
	<script type="text/javascript">
		$('#button').click(function() {
			$.ajax({
				url : 'https://ror-rest.herokuapp.com/rest/messages/draft',
				//url : 'http://localhost:8080/ror-rest-war/rest/messages/draft',
				type : 'POST',
				contentType : 'application/json',
				crossDomain : true,
				data : JSON.stringify({
					"fromUserId" : $('#fromUserId').val(),
					"toUserId" : $('#toUserId').val(),
					"message" : $('#message').val(),
					"messageSentTime" : $('#messageSentTime').val(),
				}),
				dataType : "json",
				processData : true,
				success : function(data, textStatus, jqXHR) {
					console.log('passed');
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log('failed :(');
					console.log(errorThrown);
				}
			});
		});
	</script>
</body>
</html>