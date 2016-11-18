<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="<c:url value="/js/room/addEdit.js"/>"></script>
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
				<spring:message code="room" />
			</h3>
		</div>
		<div class="box-body">
			<c:choose>
				<c:when test="${action == 'add'}">
					<c:url var="form_action" value="/room/save" />
				</c:when>
				<c:when test="${action == 'edit'}">
					<c:url var="form_action" value="/room/update" />
				</c:when>
			</c:choose>
			<form class="form-horizontal" id="room_form" method="post"
				action="${form_action}">
				<input type="hidden" name="roomId" value="${room.roomId }" />
				<div class="form-group">
					<label for="" class="col-md-2 control-label"><spring:message code="form.name" /></label>
					<div class="col-md-3">
						<input type="text" class="form-control" id="" name="name"
							value="${room.name}" placeholder="Room Name">
					</div>
				</div>
				<div class="form-group">
					<label for="" class="col-md-2 control-label"><spring:message code="form.comment" /></label>
					<div class="col-md-5">
						<textarea class="form-control" rows="3" name="comment"
							placeholder="This is a special room...">${room.comment }</textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="" class="col-md-2 control-label"><spring:message code="form.status" /></label>
					<div class="col-md-3 form-group">
						<label class="radio-inline"> <input type="radio"
							name="status" class="flat-blue" value="1"
							<c:if test="${room.status != '0' }">checked</c:if>>&nbsp;<spring:message
								code="form.status.active" />
						</label> <label class="radio-inline"> <input type="radio"
							<c:if test="${room.status == '0' }">checked</c:if> name="status"
							class="flat-blue" value="0">&nbsp;<spring:message
								code="form.status.inactive" />
						</label>
					</div>
				</div>
			</form>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<div class="col-md-offset-2">
				<a href="javascript:;" onclick="$('#room_form').submit();"
					class="btn btn-primary"> <i class="fa fa-fw fa-save"></i> <c:choose>
						<c:when test="${action == 'add'}">
							<spring:message code="button.save" />
						</c:when>
						<c:when test="${action == 'edit'}">
							<spring:message code="button.update" />
						</c:when>
					</c:choose>
				</a> &nbsp; <a href="<c:url value="/room/list"/>" class="btn btn-danger">
					<i class="fa fa-fw fa-ban"></i> <spring:message
						code="button.cancel" />
				</a>
			</div>
		</div>
		<!-- /.box-footer -->
	</div>
</section>
