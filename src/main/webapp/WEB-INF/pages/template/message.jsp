<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(function() {
		$.notifyDefaults({
			type : 'info',
			delay: 5000,
			template: '<div data-notify="container" class="col-xs-11 col-sm-3 callout callout-{0}" role="alert">' +
			'<button type="button" aria-hidden="true" class="close" data-notify="dismiss">×</button>' +
			'<span data-notify="icon"></span> ' +
			'<span data-notify="title">{1}</span> ' +
			'<span data-notify="message">{2}</span>' +
			'<div class="progress" data-notify="progressbar">' +
				'<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
			'</div>' +
			'<a href="{3}" target="{4}" data-notify="url"></a>' +
			'</div>',
		});
	});
</script>
<c:set var="messages" value="${sessionScope.messages }" />
<c:if test="${not empty messages }">
	<c:forEach var="message" items="${messages}">
		<script type="text/javascript">
		$(function() {
			$.notify({
				icon : '${message.icon}',
				message : '<strong>'+'${message.content}'+'</strong>'
			}, {
				type : '${message.type}'
			});
		});
		</script>
	</c:forEach>
	<c:remove var="messages" scope="session" />
</c:if>
