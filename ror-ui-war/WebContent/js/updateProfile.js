$(document).ready(function() {

	$('#editUserId').click(function() {
		$('#userName').prop('readonly', false);
	});

	$('#editUserPassword').click(function() {
		$('#rorUserPassword').prop('readonly', false);
	});

	$('#editUserEmail').click(function() {
		$('#email').prop('readonly', false);
	});
});