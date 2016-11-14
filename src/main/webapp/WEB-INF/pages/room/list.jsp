<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/plugins/datatables/dataTables.bootstrap.css"/>">
<script src="<c:url value="/js/room/list.js"/>"></script>
<script
	src="<c:url value="/plugins/datatables/jquery.dataTables.min.js"/>"></script>
<script
	src="<c:url value="/plugins/datatables/dataTables.bootstrap.min.js"/>"></script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-solid">
				<div class="box-header with-border">
					<h3 class="box-title">Room List</h3>
				</div>
				<div class="box-body">
					<div class="btn-group">
						<a href="<c:url value="/room/add"/>" class="btn btn-success">Add</a>
					</div>
					<table id="room_table"
						class="table table-bordered table-striped dataTable" role="grid"
						aria-describedby="example1_info" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Name</th>
								<th>Comment</th>
								<th>Status</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Name</th>
								<th>Comment</th>
								<th>Status</th>
							</tr>
						</tfoot>
						<c:if test="${roomList.size() > 0}">
							<tbody>

							</tbody>
						</c:if>

					</table>
				</div>
			</div>
		</div>
	</div>
</section>
