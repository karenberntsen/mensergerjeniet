<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Highscores</title>
		<script src="./js/angular.min.js" ></script>
		<script src="./js/xhttpRequest.js"></script>
		<script src="./js/highscores.js"  ></script>
		<link rel="stylesheet" href="./css/highscores.css">
		<link rel="stylesheet" href="./css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	</head>
	<body>
		<%@ include file="../html-part/navbar.html"%>
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
	</body>
</html>