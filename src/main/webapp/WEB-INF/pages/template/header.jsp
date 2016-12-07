<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<header class="main-header">
	<!-- Logo -->
	<a href="<c:url value="/"/>" class="logo">
		<span class="logo-lg"><b>Java</b>MRS</span>
	</a>
	<nav class="navbar navbar-static-top">
		<ul class="nav navbar-nav" id="nav">
			<li><a href="<c:url value="/room/list"/>"><i
					class="fa fa-fw fa-calendar-check-o"></i> <spring:message
						code="nav.room.manage" /></a></li>
			<li><a href="<c:url value="/user/list"/>"><i
					class="fa fa-fw fa-users"></i> <spring:message
						code="nav.user.manage" /></a></li>
			<li><a href="<c:url value="/system/list"/>"><i
					class="fa fa-fw fa-gears"></i> <spring:message
						code="nav.system.setting" /></a></li>
			<li><a href="<c:url value="/help"/>"><i
					class="fa fa-fw fa-question-circle"></i> <spring:message
						code="nav.help" /></a></li>
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
				<sec:authorize access="isAnonymous()">
					<li><a href="<c:url value="/login" />">Login</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li><a href="#" data-toggle="control-sidebar"><i
							class="fa fa-fw fa-th-large"></i></a></li>
					<li><a href="<c:url value="/logout" />">Logout</a></li>
				</sec:authorize>
			</ul>
		</div>
	</nav>
</header>