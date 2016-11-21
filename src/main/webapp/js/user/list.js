$(function() {
	$('#user_table').DataTable();
});

function edit(id) {
	$('#userId').val(id);
	$('#action_form').submit();
}
function deleteUser(id){
	$('#userId').val(id);
	$('#action_form').attr('action',delete_url);
	$('#action_form').submit();
}