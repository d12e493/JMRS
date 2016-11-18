<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet"
	href="<c:url value="/plugins/datatables/dataTables.bootstrap.css"/>">
<script src="<c:url value="/js/user/list.js"/>"></script>
<script type="text/javascript">
	var delete_url = '<c:url value="/user/delete" />';
</script>
<script
	src="<c:url value="/plugins/datatables/jquery.dataTables.min.js"/>"></script>
<script
	src="<c:url value="/plugins/datatables/dataTables.bootstrap.min.js"/>"></script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-solid">
				<div class="box-header with-border">
					<h3 class="box-title">
						<spring:message code="path.user.list" />
					</h3>
				</div>
				<div class="box-body">
					<div class="btn-group">
						<a href="<c:url value="/user/add"/>" class="btn btn-success">
							<i class="fa fa-fw fa-pencil"></i> <spring:message
								code="button.add" />
						</a>
					</div>
					<table id="user_table"
						class="table table-bordered table-striped table-hover dataTable"
						role="grid" aria-describedby="example1_info" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th><spring:message code="form.name" /></th>
								<th><spring:message code="form.role" /></th>
								<th><spring:message code="form.status" /></th>
								<th><spring:message code="form.action" /></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th><spring:message code="form.name" /></th>
								<th><spring:message code="form.role" /></th>
								<th><spring:message code="form.status" /></th>
								<th><spring:message code="form.action" /></th>
							</tr>
						</tfoot>
						<c:if test="${userList.size() > 0}">
							<tbody>
								<c:forEach items="${userList }" var="user">
									<tr>
										<td>${user.name }</td>
										<td><spring:message
												code="role.${fn:toLowerCase(user.role)}" /></td>
										<td><c:choose>
												<c:when test="${user.status}">
													<i class="fa fa-fw fa-check text-success"></i>
												</c:when>
												<c:when test="${not user.status}">
													<i class="fa fa-fw fa-ban text-danger"></i>
												</c:when>
											</c:choose></td>
										<td>
											<button class="btn btn-info" onclick="edit(${user.userId});">
												<i class="fa fa-fw fa-edit"></i>
												<spring:message code="button.edit" />
											</button> &nbsp;
											<button class="btn btn-danger"
												onclick="deleteUser(${user.userId});">
												<i class="fa fa-fw fa-trash-o"></i>
												<spring:message code="button.delete" />
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</c:if>

					</table>
				</div>
			</div>
		</div>
	</div>
</section>
<form id="action_form" method="post"
	action="<c:url value="/user/edit"/>">
	<input type="hidden" name="userId" id="userId" />
</form>
