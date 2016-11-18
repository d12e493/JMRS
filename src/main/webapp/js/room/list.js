$(function() {
	$('#room_table').DataTable();
});

function edit(id) {
	$('#roomId').val(id);
	$('#action_form').submit();
}
function deleteRoom(id){
	$('#roomId').val(id);
	$('#action_form').attr('action',delete_url);
	$('#action_form').submit();
}