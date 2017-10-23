<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html ng-app="myApp">
	<head>
		<meta charset="UTF-8">
		<title>Mens erger je niet - The Game</title>
		<script src="<c:url value="/js/angular.min.js"/>"></script>
		<script src="<c:url value="/js/sockjs.min.js" />"></script>
		<script src="<c:url value="/js/stomp.min.js"  />"></script>
		<script src="<c:url value="/js/mejn.js"       />"></script>
		<script>
		var _csrf ={"name": "${_csrf.parameterName}", "token": "${_csrf.token}"};
		</script>
		<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" >
 	</head>
	<body>
		<%@ include file="../html-part/navbar.jsp"%>
		<div ng-controller="myCtrl">
			<%@ include file="../html-part/mejnboard.html" %>
			<%@ include file="../html-part/chat.html" %>
		</div>
	<%@ include file="../html-part/bootstrap.html" %>
	</body>
</html>