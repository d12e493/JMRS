<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet"
	href="<c:url value="/plugins/fullcalendar/fullcalendar.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/plugins/fullcalendar/fullcalendar.print.css"/>"
	media="print">
<link rel="stylesheet" href="<c:url value="/css/dashboard.css"/>">
<script type="text/javascript">
	var booking_add_url = '<c:url value="/book/add"/>';
</script>
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
			<form id="book_form" method="post">
				<c:set var="startTime" value="0800" />
				<c:set var="endTime" value="1900" />
				<input type="hidden" name="date" id="currentDay"
					value="${currentDay }" /> <input type="hidden" name="room.roomId"
					id="room_id" value="" /> <input type="hidden" name="start"
					id="start_time" value="" />
				<table class="table table-hover table-bordered" id="meeting_table">
					<thead class="">
						<tr>
							<th>Time</th>
							<c:if test="${fn:length(roomList) gt 0}">
								<c:forEach var="room" items="${roomList }">
									<th class="success" style="width: ${90/fn:length(roomList)}%">${room.name }</th>
								</c:forEach>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="time" begin="0" step="50"
							end="${endTime-startTime}">
							<fmt:parseNumber var="hour" integerOnly="true" pattern="##"
								value="${startTime/100+time/100}" />
							<fmt:formatNumber type="number" value="${hour }"
								var="hour_format" minIntegerDigits="2" />
							<c:choose>
								<c:when test="${time%100 == 0 }">
									<c:set var="hour_time" value="${hour_format}:00" />
								</c:when>
								<c:otherwise>
									<c:set var="hour_time" value="${hour_format}:30" />
								</c:otherwise>
							</c:choose>
							<tr time="${hour_time }">
								<td class="info">${hour_time}</td>
								<c:if test="${fn:length(roomList) gt 0}">
									<c:forEach var="room" items="${roomList }">
										<c:set var="bookMap" value="${roomBookMap[room.roomId] }" />
										<c:choose>
											<c:when test="${not empty bookMap && not empty bookMap[hour_time] }">
												<td>123</td>
											</c:when>
											<c:otherwise>
												<td type="free" room="${room.roomId }">&nbsp;</td>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</section>
<script src="<c:url value="/js/moment.min.js"/>"></script>
<script src="<c:url value="/js/dashboard/list.js"/>"></script>