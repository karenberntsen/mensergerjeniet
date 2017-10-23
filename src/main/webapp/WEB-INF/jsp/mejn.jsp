<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html ng-app="myApp">
	<head>
		<meta charset="UTF-8">
		<title>Mens erger je niet - The Game</title>
	<%@ include file="../html-part/jsCssIncludes.jsp" %>
		<script src="<c:url value="/js/sockjs.min.js" />"></script>
		<script src="<c:url value="/js/stomp.min.js"  />"></script>
		<script src="<c:url value="/js/mejn.js"       />"></script>
		<script>
		var _csrf ={"name": "${_csrf.parameterName}", "token": "${_csrf.token}"};
		</script>
 	</head>
	<body>
		<%@ include file="../html-part/navbar.jsp"%>
		<div ng-controller="myCtrl">
			<%@ include file="../html-part/mejnboard.jsp" %>
			<%@ include file="../html-part/chat.jsp" %>
		</div>
	</body>
</html>