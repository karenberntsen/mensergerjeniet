<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app="indexApp">
	<head>
 		<title>Mens Erger Je Niet Homepage</title>
		<%@ include file="../html-part/jsCssIncludes.jsp" %>
		<link href="<spring:url value="/css/app.css" />" rel="stylesheet" type="text/css">
 		<script src= "<spring:url value="/js/home.js"/>"></script>
	</head>
	<body class="security-app">
	  	<%@ include file="../html-part/navbar.jsp" %>
		<div ng-controller="indexCtrl">
			<form>
				<div class="form-group row">
					<h3 for="boardId" class="col-sm-2 col-form-label">New Game</h3>
					<input id="boardId" type="text"  placeholder="Board Name" class=" col-sm-4"/>
					<input type="button" value="Start board"  ng-click="newBoard()"/>
				</div>
			</form>
			<h1>Current Games</h1>
			<div class="card-deck">
				<div class="card" style="width: 33%;" ng-repeat="gameInfo in list">
					<div class="clearfix" ng-if="$index % 3 == 0"></div>
				  <div class="card-block">
				    <h4 class="card-title">{{gameInfo.id}}</h4>
				    <p class="card-text">
				    	<ul>
				    		<li ng-repeat="player in gameInfo.playerNames">{{player}} </li>
				    	</ul>	
				    </p>
				   <form method="get" action="{{'./mejn/' + gameInfo.id}}">
						<button type="submit">Watch Game</button>
					</form>
				  </div>
				</div>
			</div>
		</div>
	</body>
</html>
