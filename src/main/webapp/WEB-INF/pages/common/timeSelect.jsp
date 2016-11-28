<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="startTime" value="0800" />
<c:set var="endTime" value="1900" />
<select id="${param.selectId }" name="${param.selectId }">
	<c:forEach var="time" begin="0" step="50" end="${endTime-startTime}">
		<fmt:parseNumber var="hour" integerOnly="true" pattern="##"
			value="${startTime/100+time/100}" />
		<fmt:formatNumber type="number" value="${hour }" var="hour_format"
			minIntegerDigits="2" />
		<c:choose>
			<c:when test="${time%100 == 0 }">
				<c:set var="hour_time" value="${hour_format}:00" />
			</c:when>
			<c:otherwise>
				<c:set var="hour_time" value="${hour_format}:30" />
			</c:otherwise>
		</c:choose>
		<option value="${hour_time }">${hour_time }</option>
	</c:forEach>
</select>