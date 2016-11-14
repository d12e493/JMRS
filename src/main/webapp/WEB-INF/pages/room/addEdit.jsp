<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="<c:url value="/js/room/addEdit.js"/>"></script>
<section class="content">
	<div class="box box-success">
		<div class="box-header with-order">
			<h3 class="box-title">新增 會議室</h3>
		</div>
		<div class="box-body">
			<form class="form-horizontal">
				<div class="form-group">
					<label for="" class="col-md-2 control-label">Name</label>
					<div class="col-md-3">
						<input type="text" class="form-control" id=""
							placeholder="Room Name">
					</div>
				</div>
				<div class="form-group">
					<label for="" class="col-md-2 control-label">Comment</label>
					<div class="col-md-5">
						<textarea class="form-control" rows="3"
							placeholder="This is a special room..."></textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="" class="col-md-2 control-label">Status</label>
					<div class="col-md-3 form-group">
						<label class="radio-inline"> <input type="radio"
							name="status" class="flat-blue" checked>&nbsp;啟用
						</label> <label class="radio-inline"> <input type="radio"
							name="status" class="flat-blue">&nbsp;停用
						</label>
					</div>
				</div>
			</form>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<button type="submit" class="btn btn-info">
				<spring:message code="button.add" />
			</button>
			&nbsp;
			<button type="submit" class="btn btn-danger">
				<spring:message code="button.cancel" />
			</button>
		</div>
		<!-- /.box-footer -->

	</div>
</section>
