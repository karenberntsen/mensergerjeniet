<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html ng-app="myApp">
	<head>
		<meta charset="UTF-8">
		<title>Mens erger je niet - The Game</title>
		
		<script src="./js/angular.min.js"></script>
		<script src="./js/sockjs.min.js"></script>
		<script src="./js/stomp.min.js"></script>
		<script src="./js/main.js"></script>
		<script src="./js/mejn.js"></script>
		<link rel="stylesheet" href="./css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
 	</head>
	<body>
		<%@ include file="../html-part/navbar.html"%>
		<div ng-controller="myCtrl">
			<%@ include file="../html-part/mejnboard.html" %>
			<%@ include file="../html-part/chat.html" %>
		</div>
	</body>
</html>