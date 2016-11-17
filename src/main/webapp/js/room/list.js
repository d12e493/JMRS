$(function() {
	$('#room_table').DataTable();
});

function edit(id) {
	$('#roomId').val(id);
	$('#action_form').submit();
}