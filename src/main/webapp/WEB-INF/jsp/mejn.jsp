<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app="myApp">
<script src="js/angular.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Mens erger je niet - The Game</title>
</head>
<body>
	<%@ include file="../html-part/navbar.html"%>
	<div ng-controller="myCtrl">

		<svg
			style="width: 100vmin; height: 100vmin; top: 300; left: 0; bottom: 0; right: 0;"
			xmlns="http://www.w3.org/2000/svg">
			<text ng-repeat="player in playerNames"
				ng-attr-x="{{circleCoordinates[player.x]}}%"
				ng-attr-y="{{circleCoordinates[player.y]-5}}%" text-anchor="middle"
				stroke="black" stroke-width="2px">{{player.name}}</text>
			<circle ng-repeat="indices in whiteCircles"
				ng-attr-cx="{{circleCoordinates[indices.x]}}%"
				ng-attr-cy="{{circleCoordinates[indices.y]}}%"
				ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1"
				fill="white" />
			<circle ng-repeat="indices in blueCircles"
				ng-attr-cx="{{circleCoordinates[indices.x]}}%"
				ng-attr-cy="{{circleCoordinates[indices.y]}}%"
				ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1"
				fill="blue" />
			<circle ng-repeat="indices in greenCircles"
				ng-attr-cx="{{circleCoordinates[indices.x]}}%"
				ng-attr-cy="{{circleCoordinates[indices.y]}}%"
				ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1"
				fill="green" />
			<circle ng-repeat="indices in yellowCircles"
				ng-attr-cx="{{circleCoordinates[indices.x]}}%"
				ng-attr-cy="{{circleCoordinates[indices.y]}}%"
				ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1"
				fill="yellow" />
			<circle ng-repeat="indices in redCircles"
				ng-attr-cx="{{circleCoordinates[indices.x]}}%"
				ng-attr-cy="{{circleCoordinates[indices.y]}}%"
				ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1"
				fill="red" />		
		    
			<g ng-repeat="pawn in pawns"
				ng-attr-x="{{circleCoordinates[pawn.x]}}%"
				ng-attr-y="{{circleCoordinates[pawn.y]}}%"
				ng-click="movePawn(pawn.id)">
				<circle id="{{pawn.id}}" ng-attr-cx="{{circleCoordinates[pawn.x]}}%"
				ng-attr-cy="{{circleCoordinates[pawn.y]}}%"
				ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1"
				fill="{{pawn.colour}}">
				</circle>
				<text ng-attr-x="{{circleCoordinates[pawn.x] + 0.1}}%"
				ng-attr-y="{{circleCoordinates[pawn.y] + 0.8}}%"
				text-anchor="middle" stroke="black" stroke-width="2px">{{pawn.id}}</text>
			</g>
			<g>
				<rect id="dicebg" ng-attr-x="{{circleCoordinates[5]-circleRadius}}%"
				ng-attr-y="{{circleCoordinates[5]-circleRadius}}%"
				height="{{2*circleRadius}}%" width="{{2*circleRadius}}%"
				fill="#668cff" stroke="#668cff"> </rect>
				<image id="dice" ng-click="throwDice()" xlink:href="img/1.png"
				ng-attr-x="{{circleCoordinates[5]-circleRadius}}%"
				ng-attr-y="{{circleCoordinates[5]-circleRadius}}%"
				height="{{2*circleRadius}}%" width="{{2*circleRadius}}%" />
			
			</g>
	 <image id="start" ng-click="startGame()"
				xlink:href="img/start_button.png" ng-attr-x="33%" ng-attr-y="88%"
				height="{{5*circleRadius}}%" width="{{10*circleRadius}}%" />
			
	</svg>
		<div id="chat-page" style="margin-left: 750px">
			<div class="chat-container">
				<div class="chat-header">
					<h2>Spring WebSocket Chat Demo</h2>
				</div>
				<div class="connecting">Connecting...</div>
				<ul id="messageArea">

				</ul>
				<form id="messageForm" name="messageForm" nameForm="messageForm">
					<div class="form-group">
						<div class="input-group clearfix">
							<input type="text" id="message" placeholder="Type a message..."
								autocomplete="off" class="form-control" />
							<button type="submit" class="primary">Send</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="/js/sockjs.min.js"></script>
	<script src="/js/stomp.min.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/mejn.js"></script>

</body>
</html>