<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Highscores</title>
		<script src="<c:url value="/js/angular.min.js" />"></script>
		<script src="<c:url value="/js/highscores.js"  />" ></script>
		<link rel="stylesheet" href="<c:url value="/css/highscores.css" />">
		<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">
	</head>
	<body>
		<%@ include file="../html-part/navbar.jsp"%>
		<div>
			<h1>Highscores</h1>
			<div ng-controller="myCtrl">
				<table class="blueTable">
					<thead>
						<tr>
							<th>Name</th>
							<th>Wins</th>
							<th>Losses</th>
							<th>Games Played</th>
							<th>Win-ratio</th>
						</tr>
					</thead>
					<tr ng-repeat="score in highscores">
						<td>{{ score.userName }}</td>
						<td>{{ score.win }}</td>
						<td>{{ score.loss }}</td>
						<td>{{ score.win+score.loss }}</td>
						<td>{{toInt(score.win / (score.win+score.loss)*100)}}%</td>
					</tr>
				</table>
			</div>
		</div>
		
	<%@ include file="../html-part/bootstrap.html" %>
	</body>
</html>