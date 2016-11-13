<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="main-header">
	<!-- Logo -->
	<a href="<c:url value="/"/>" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>Java</b>MRS</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>Java</b>MRS</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<ul class="nav navbar-nav" id="nav">
			<li><a href="<c:url value="/room/list"/>"><i
					class="fa fa-fw fa-calendar-check-o"></i>會議室管理</a></li>
			<li><a href="<c:url value="/user/list"/>"><i
					class="fa fa-fw fa-users"></i>使用者管理</a></li>
			<li><a href="<c:url value="/system/list"/>"><i
					class="fa fa-fw fa-gears"></i>系統設定</a></li>
			<li><a href="<c:url value="/help"/>"><i
					class="fa fa-fw fa-question-circle"></i>Help</a></li>
		</ul>
		<script>
			$('#nav li a').each(function() {
				var path = window.location.pathname;

				if ($(this).attr('href') == path) {
					$(this).closest('li').addClass('active');
					return false;
				}
			});
		</script>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- Notifications: style can be found in dropdown.less -->
				<li class="dropdown notifications-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 10 notifications</li>
						<li>
							<!-- inner menu: contains the actual data -->
							<ul class="menu">
								<li><a href="#"> <i class="fa fa-users text-aqua"></i>
										5 new members joined today
								</a></li>
								<li><a href="#"> <i class="fa fa-warning text-yellow"></i>
										Very long description here that may not fit into the page and
										may cause design problems
								</a></li>
								<li><a href="#"> <i class="fa fa-users text-red"></i> 5
										new members joined
								</a></li>
								<li><a href="#"> <i
										class="fa fa-shopping-cart text-green"></i> 25 sales made
								</a></li>
								<li><a href="#"> <i class="fa fa-user text-red"></i>
										You changed your username
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="#">View all</a></li>
					</ul></li>
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"><span
						class="hidden-xs">Login User Name</span> </a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img src="" class="img-circle"
							alt="User Image">

							<p>
								Alexander Pierce - Web Developer <small>Member since
									Nov. 2012</small>
							</p></li>
						<!-- Menu Body -->
						<li class="user-body">
							<div class="row">
								<div class="col-xs-4 text-center">
									<a href="#">Followers</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Sales</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Friends</a>
								</div>
							</div> <!-- /.row -->
						</li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">Profile</a>
							</div>
							<div class="pull-right">
								<a href="#" class="btn btn-default btn-flat">Sign out</a>
							</div>
						</li>
					</ul></li>
				<!-- Control Sidebar Toggle Button -->
				<li><a href="#" data-toggle="control-sidebar"><i
						class="fa fa-fw fa-th-large"></i></a></li>
			</ul>
		</div>
	</nav>
</header>