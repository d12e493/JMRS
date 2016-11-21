<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/plugins/fullcalendar/fullcalendar.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/plugins/fullcalendar/fullcalendar.print.css"/>"
	media="print">

<div id="calendar"></div>
<script src="<c:url value="/js/moment.min.js"/>"></script>
<script src="<c:url value="/js/fullcalendar.min.js"/>"></script>
<script src="<c:url value="/js/scheduler.min.js"/>"></script>
<script type="text/javascript">
	$(function() {

		var date = new Date();
		var d = date.getDate(), m = date.getMonth(), y = date.getFullYear();
		$('#calendar').fullCalendar({
			header : {
				left : 'prev',
				center : 'title today',
				right : 'next'
			},
			buttonText : {
				today : 'today',
			},
			resources: [
						{ id: 'a', title: 'Room A', eventColor: 'blue' },
						{ id: 'b', title: 'Room B', eventColor: 'green' },
						{ id: 'c', title: 'Room C', eventColor: 'orange' },
						{ id: 'd', title: 'Room D', eventColor: 'red' }
					],
			events: [
						{ id: '1', resourceId: 'a', start: '10:00:00', end: '12:00:00', title: 'event 1' },
						{ id: '2', resourceId: 'a', start: '13:00:00', end: '15:00:00', title: 'event 2' },
						{ id: '3', resourceId: 'b', start: '12:00:00', end: '14:00:00', title: 'event 3' },
						{ id: '4', resourceId: 'c', start: '09:30:00', end: '13:30:00', title: 'event 4' },
						{ id: '5', resourceId: 'd', start: '10:00:00', end: '15:00:00', title: 'event 5' },
						{ id: '10', resourceId: 'd', start: '16:00:00', end: '17:00:00', title: 'event test' }
					],
			timeFormat : 'HH:mm',
			editable : false,
			droppable : false,
			defaultView: 'agendaDay',
			allDaySlot : false,
			selectable: true,
			minTime : '08:00:00',
			maxTime : '19:00:00',
			slotDuration : '00:15:00',
			slotLabelInterval  : '00:15:00',
			slotLabelFormat : 'HH:mm',
			schedulerLicenseKey: 'GPL-My-Project-Is-Open-Source',
		});
	});
</script>
