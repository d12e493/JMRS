$(function() {

	$("#datepicker").datepicker({
		autoclose : true,
		format : "yyyy-mm-dd",
	});

	if (startTime != '') {
		$('#startTime').val(startTime);
	}
	if (endTime != '') {
		$('#endTime').val(endTime);
	} else {
		// 把小於 startTime 的選項全部刪掉
		setEndTimeByStartTime(startTime)
	}

	$('#startTime').on('change', function() {
		setEndTimeByStartTime($(this).val());
	});

	$('#endTime').on('change', function() {
		countDuration();
	});
});
/**
 * 把小於 startTime 的選項全部刪掉
 * 
 * @param start
 * @returns
 */
function setEndTimeByStartTime(start) {
	$('#endTime option').show();
	var optionIndex = $('#endTime option[value="' + start + '"]').index();
	var defaultEndTimeIndex = optionIndex + 1;
	$('#endTime option:lt("' + defaultEndTimeIndex + '")').hide();
	
	// check old endTime
	var endTime = $('#endTime').val();
	
	if($('#endTime option[value="'+endTime+'"]').css('display') == 'none'){
		$('#endTime option:eq(' + defaultEndTimeIndex + ')').prop('selected', true);
	}
	
	countDuration();
}

function countDuration() {

	var start = $('#startTime').val().split(':');
	var end = $('#endTime').val().split(':');

	var startDate = new Date();
	startDate.setHours(start[0]);
	startDate.setMinutes(start[1]);
	
	var endDate = new Date();
	endDate.setHours(end[0]);
	endDate.setMinutes(end[1]);
	
	var duration = (endDate - startDate)/1000/60/60;
	
	$('#duration').html(duration);
}