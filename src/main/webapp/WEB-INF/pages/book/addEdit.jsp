<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
	var startTime = '<fmt:formatDate pattern="HH:mm" value="${book.startTime }"/>';
	var endTime = '<fmt:formatDate pattern="HH:mm" value="${book.endTime }"/>';
</script>
<script src="<c:url value="/js/book/addEdit.js"/>"></script>
<section class="content">
	<div class="box box-success">
		<div class="box-header with-border">
			<h3 class="box-title">
				<c:choose>
					<c:when test="${action == 'add'}">
						<spring:message code="button.add" />
					</c:when>
					<c:when test="${action == 'edit'}">
						<spring:message code="button.edit" />
					</c:when>
				</c:choose>
				<spring:message code="booking" />
			</h3>
		</div>
		<div class="box-body">
			<c:choose>
				<c:when test="${action == 'add'}">
					<c:url var="form_action" value="/book/save" />
				</c:when>
				<c:when test="${action == 'edit'}">
					<c:url var="form_action" value="/book/update" />
				</c:when>
			</c:choose>
			<form class="form-horizontal" id="book_form" method="post"
				action="${form_action}">
				<input type="hidden" name="room.roomId" value="${book.room.roomId }" />
				<!-- room name -->
				<div class="form-group">
					<label for="" class="col-md-2 control-label"><spring:message
							code="form.name" /></label>
					<div class="col-md-3">
						<input type="text" class="form-control" id="" name="name"
							value="${book.name}" placeholder="Meeting Name">
					</div>
				</div>
				<!-- room description -->
				<div class="form-group">
					<label for="" class="col-md-2 control-label"><spring:message
							code="form.comment" /></label>
					<div class="col-md-5">
						<textarea class="form-control" rows="3" name="comment"
							placeholder="Why we have this meeting...">${book.comment }</textarea>
					</div>
				</div>
				<!-- room date -->
				<div class="form-group">
					<label for="" class="col-md-2 control-label"><spring:message
							code="form.date" /></label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="datepicker" name="date"
							value="<fmt:formatDate pattern="yyyy-MM-dd" value="${book.bookDate }"/>" />
					</div>
				</div>
				<!-- room time -->
				<div class="form-group">
					<label for="" class="col-md-2 control-label"><spring:message
							code="form.time" /></label>
					<div class="col-md-5">
						<jsp:include page="/WEB-INF/pages/common/timeSelect.jsp">
							<jsp:param name="selectId" value="start" />
						</jsp:include>
						&nbsp;~&nbsp;
						<jsp:include page="/WEB-INF/pages/common/timeSelect.jsp">
							<jsp:param name="selectId" value="end" />
						</jsp:include>
						&nbsp;共 <span id="duration" class="text-red"></span> 小時
					</div>
				</div>
			</form>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<div class="col-md-offset-2">
				<a href="javascript:;" onclick="$('#book_form').submit();"
					class="btn btn-primary"> <i class="fa fa-fw fa-save"></i> <c:choose>
						<c:when test="${action == 'add'}">
							<spring:message code="button.save" />
						</c:when>
						<c:when test="${action == 'edit'}">
							<spring:message code="button.update" />
						</c:when>
					</c:choose>
				</a> &nbsp; <a href="<c:url value="/"/>" class="btn btn-danger"> <i
					class="fa fa-fw fa-ban"></i> <spring:message code="button.cancel" />
				</a>
			</div>
		</div>
		<!-- /.box-footer -->
	</div>
</section>
