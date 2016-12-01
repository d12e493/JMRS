$(function() {

	$("#datepicker").datepicker({
		autoclose : true,
		format : "yyyy-mm-dd",
	});

	if (startTime != '') {
		$('#start').val(startTime);
	}
	if (endTime != '') {
		$('#end').val(endTime);
	} else {
		// 把小於 startTime 的選項全部刪掉
		setEndTimeByStartTime(startTime)
	}

	$('#start').on('change', function() {
		setEndTimeByStartTime($(this).val());
	});

	$('#end').on('change', function() {
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
	$('#end option').show();
	var optionIndex = $('#end option[value="' + start + '"]').index();
	var defaultEndTimeIndex = optionIndex + 1;
	$('#end option:lt("' + defaultEndTimeIndex + '")').hide();
	
	// check old endTime
	var endTime = $('#end').val();
	
	if($('#end option[value="'+endTime+'"]').css('display') == 'none'){
		$('#end option:eq(' + defaultEndTimeIndex + ')').prop('selected', true);
	}
	
	countDuration();
}

function countDuration() {

	var start = $('#start').val().split(':');
	var end = $('#end').val().split(':');

	var startDate = new Date();
	startDate.setHours(start[0]);
	startDate.setMinutes(start[1]);
	
	var endDate = new Date();
	endDate.setHours(end[0]);
	endDate.setMinutes(end[1]);
	
	var duration = (endDate - startDate)/1000/60/60;
	
	duration = parseFloat(Math.round(duration * 100) / 100).toFixed(1);
	
	$('#duration').html(duration);
}