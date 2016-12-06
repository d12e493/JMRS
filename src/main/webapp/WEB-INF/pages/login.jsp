<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br />
<br />
<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<form action="<c:url value="/login"/>" method="post">
			<div class="form-group has-feedback">
				<input type="text" class="form-control" placeholder="Name" name="name">
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" class="form-control" placeholder="Password" name="password">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="row">
				<div class="col-xs-8"></div>
				<div class="col-xs-4">
					<button type="submit" class="btn btn-primary btn-block btn-flat">
						<spring:message code="form.login" />
					</button>
				</div>
			</div>
		</form>
	</div>
	<div class="col-md-4"></div>
</div>