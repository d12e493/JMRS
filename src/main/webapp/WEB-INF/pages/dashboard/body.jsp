<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet"
	href="<c:url value="/plugins/fullcalendar/fullcalendar.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/plugins/fullcalendar/fullcalendar.print.css"/>"
	media="print">
<style>
.td_time_hover {
	background-color: #00c0ef;
}

div.fc-slats table td, th {
	position: relative;
}

div.fc-slats  table {
	overflow: hidden;
}

.fc-today {
	background: transparent !important;
}

.th-hover {
	background-color: #b9ccb1 !important;
}

table tbody tr td:first-child {
	text-align: center;
}

table thead tr th {
	text-align: center;
}
</style>
<section class="content">
	<div class="box box-default">
		<div class="box-header with-border">
			<div class="col-md-5"></div>
			<div class="col-md-2">
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-calendar"></i>
					</div>
					<input type="text" class="form-control pull-right" id="datepicker">
				</div>
				<div id="dateDivPicker"></div>
			</div>
			<div class="col-md-5"></div>
		</div>
		<div class="box-body">
			<c:set var="startTime" value="0800" />
			<c:set var="endTime" value="1900" />
			<table class="table table-hover table-bordered">
				<thead class="">
					<tr>
						<th>Time</th>
						<th class="success" style="width: 30%">Room 1</th>
						<th class="success" style="width: 30%">Room AA</th>
						<th class="success" style="width: 30%">Room D.C.</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="time" begin="0" step="50"
						end="${endTime-startTime}">
						<fmt:parseNumber var="hour" integerOnly="true" pattern="##"
							value="${startTime/100+time/100}" />
						<fmt:formatNumber type="number" value="${hour }" var="hour_format"
							minIntegerDigits="2" />
						<tr>
							<td class="info"><c:choose>
									<c:when test="${time%100 == 0 }">
										${hour_format}:00
									</c:when>
									<c:otherwise>
									${hour_format}:30
								</c:otherwise>
								</c:choose></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>
<script src="<c:url value="/js/moment.min.js"/>"></script>
<script type="text/javascript">
	$(function() {

		var today = new Date();

		$('#datepicker').datepicker({
			autoclose : true,
		}).datepicker("setDate", "0");

		$("#dateDivPicker").datepicker();
		
		$('table tbody tr td').hover(function() {
			var th = getThByTd($(this));
			th.addClass('th-hover');
		}, function() {
			var th = getThByTd($(this));
			th.removeClass('th-hover');
		});
	});

	function getThByTd(tdObj) {
		var index = tdObj.index();
		var table = tdObj.closest('table');
		console.log(index);
		var th = $(table).find('thead th:nth-child(' + (index+1) + ')');
		console.log(th.html());
		return th;
	}
</script>
