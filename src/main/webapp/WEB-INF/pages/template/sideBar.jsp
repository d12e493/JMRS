<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.datepicker table td.day:not(.old):not(.new){
	font-weight: bold;
}
</style>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<div id="datepicker"></div>
		<script>
			$(function() {
				$("#datepicker").datepicker();
				var today = new Date();
				var day = today.getDate();
				$('#datepicker table td.day').filter(function() {
					return $(this).text() == day;
				}).addClass('active');
			});
		</script>
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<div class="box box-primary box-solid">
			<div class="box-header with-border">
				<h3 class="box-title">
					<i class="fa fa-fw fa-calendar"></i> &nbsp; My Booking Room
				</h3>

				<div class="box-tools pull-right">
					<button type="button" class="btn btn-box-tool"
						data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
				</div>
				<!-- /.box-tools -->
			</div>
			<!-- /.box-header -->
			<div class="box-body">The body of the box</div>
			<!-- /.box-body -->
		</div>
	</section>
	<!-- /.sidebar -->
</aside>
