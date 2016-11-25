$(function() {

	var today = new Date();

	$('#datepicker').datepicker({
		autoclose : true,
	}).datepicker("setDate", "0");

	$("#dateDivPicker").datepicker();

	$('#meeting_table tbody tr td').hover(function() {
		var th = getThByTd($(this));
		$(this).addClass('td_time_hover');
		th.addClass('th-hover');
	}, function() {
		var th = getThByTd($(this));
		$(this).removeClass('td_time_hover');
		th.removeClass('th-hover');
	});

	$("#meeting_table tbody tr td[type='free']").not(":first-child").click(
			function() {
				test();
			});
});

function getThByTd(tdObj) {
	var index = tdObj.index();
	var table = tdObj.closest('table');
	var th = $(table).find('thead th:nth-child(' + (index + 1) + ')');
	return th;
}

function test() {
	console.log('test');
}