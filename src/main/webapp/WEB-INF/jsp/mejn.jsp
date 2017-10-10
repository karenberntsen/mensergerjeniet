<!DOCTYPE html>
<html ng-app="myApp">

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<script>
var app = angular.module('myApp', [])
.controller('myCtrl', function($scope) {
  $scope.whiteCircles = [{"x": 6, "y": 0}, {"x": 6, "y": 1}, {"x": 6, "y": 2}, {"x": 6, "y": 3}, {"x": 6, "y": 4}, {"x": 7, "y": 4}, {"x": 8, "y": 4}, {"x": 9, "y": 4}, {"x": 10, "y": 4}, {"x": 10, "y": 5}, {"x": 10, "y": 6}, {"x": 9, "y": 6}, {"x": 8, "y": 6}, {"x": 7, "y": 6}, {"x": 6, "y": 6}, {"x": 6, "y": 7}, {"x": 6, "y": 8}, {"x": 6, "y": 9}, {"x": 6, "y": 10}, {"x": 5, "y": 10}, {"x": 4, "y": 10}, {"x": 4, "y": 9}, {"x": 4, "y": 8}, {"x": 4, "y": 7}, {"x": 4, "y": 6}, {"x": 3, "y": 6}, {"x": 2, "y": 6}, {"x": 1, "y": 6}, {"x": 0, "y": 6}, {"x": 0, "y": 5}, {"x": 0, "y": 4}, {"x": 1, "y": 4}, {"x": 2, "y": 4}, {"x": 3, "y": 4}, {"x": 4, "y": 4}, {"x": 4, "y": 3}, {"x": 4, "y": 2}, {"x": 4, "y": 1}, {"x": 4, "y": 0}, {"x": 5, "y": 0}];
  $scope.blueCircles=[{"x": 9, "y": 0}, {"x": 10, "y": 0}, {"x": 9, "y": 1}, {"x": 10, "y": 1}, {"x": 5, "y": 1}, {"x": 5, "y": 2}, {"x": 5, "y": 3}, {"x": 5, "y": 4}, {"x": 6, "y": 0}];
  $scope.greenCircles=[{"x": 9, "y": 9}, {"x": 10, "y": 9}, {"x": 9, "y": 10}, {"x": 10, "y": 10}, {"x": 9, "y": 5}, {"x": 8, "y": 5}, {"x": 7, "y": 5}, {"x": 6, "y": 5}, {"x": 10, "y": 6}];
  $scope.yellowCircles=[{"x": 0, "y": 9}, {"x": 1, "y": 9}, {"x": 0, "y": 10}, {"x": 1, "y": 10}, {"x": 5, "y": 9}, {"x": 5, "y": 8}, {"x": 5, "y": 7}, {"x": 5, "y": 6}, {"x": 4, "y": 10}];
  $scope.redCircles=[{"x": 0, "y": 0}, {"x": 1, "y": 0}, {"x": 0, "y": 1}, {"x": 1, "y": 1}, {"x": 1, "y": 5}, {"x": 2, "y": 5}, {"x": 3, "y": 5}, {"x": 4, "y": 5}, {"x": 0, "y": 4}];
  $scope.boardBorder=7;
  $scope.circleRadius=3;
  $scope.pawnBorder=4;
  $scope.pawnFill=2;
  $scope.circleDistance=2;
  $scope.circleCoordinates=[];
  $scope.circleCoordinates[0]=$scope.boardBorder;
  $scope.dobbel="een";
  for(var i=1;i<11;i++) {
		$scope.circleCoordinates[i]= $scope.circleCoordinates[i-1]+$scope.circleRadius*2+$scope.circleDistance;
  }
  
  
  });
</script>

<svg style=width:100vmin;height:100vmin;position:fixed;top:0;left:0;bottom:0;right:0; ng-controller="myCtrl" xmlns="http://www.w3.org/2000/svg">
		<circle ng-repeat="indices in whiteCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="white" />
		<circle ng-repeat="indices in blueCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="blue" />
		<circle ng-repeat="indices in greenCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="green" />
		<circle ng-repeat="indices in yellowCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="yellow" />
		<circle ng-repeat="indices in redCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="red" />		
	    <image id="dice" onclick="throwDice()" xlink:href="img/1.png" ng-attr-x="{{circleCoordinates[5]-circleRadius}}%" ng-attr-y="{{circleCoordinates[5]-circleRadius}}%" height="{{2*circleRadius}}%" width="{{2*circleRadius}}%"/>

</svg>
<div id="chat-page">
        <div class="chat-container">
            <div class="chat-header">
                <h2>Spring WebSocket Chat Demo</h2>
            </div>
            <div class="connecting">
                Connecting...
            </div>
            <ul id="messageArea">

            </ul>
            <form id="messageForm" name="messageForm" nameForm="messageForm">
                <div class="form-group">
                    <div class="input-group clearfix">
                        <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                        <button type="submit" class="primary">Send</button>
                        
						<button onclick="throwDice()">trow dice</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script src="/js/sockjs.min.js"></script>
    <script src="/js/stomp.min.js"></script>
    <script src="/js/main.js"></script>
    <script>
    conn();</script>
</body>
</html>