<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jQuery 2.2.3 -->
<script src="<c:url value="/plugins/jQuery/jquery-2.2.3.min.js"/>"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
	$.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/plugins/datepicker/bootstrap-datepicker.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/dist/js/app.min.js"/>"></script>
<script src="<c:url value="/plugins/timepicker/bootstrap-timepicker.min.js"/>"></script>