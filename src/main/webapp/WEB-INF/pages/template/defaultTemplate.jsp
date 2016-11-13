<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<tiles:insertAttribute name="css" />
<tiles:insertAttribute name="script" />
<title><tiles:insertAttribute name="title" /></title>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<tiles:insertAttribute name="header" />
		
		<tiles:insertAttribute name="sideBar" />
		
		<div class="content-wrapper">
			<tiles:insertAttribute name="body" />
		</div>

		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>