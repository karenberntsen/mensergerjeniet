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
  $scope.blueCircles.Home=[{"x": 9, "y": 0}, {"x": 10, "y": 0}, {"x": 9, "y": 1}, {"x": 10, "y": 1}];
  $scope.blueCircles.Start={"x": 6, "y": 0};
  $scope.blueCircles.Finish=[{"x": 5, "y": 1}, {"x": 5, "y": 2}, {"x": 5, "y": 3}, {"x": 5, "y": 4}];
  $scope.greenCircles.Home=[{"x": 9, "y": 9}, {"x": 10, "y": 9}, {"x": 9, "y": 10}, {"x": 10, "y": 10}];
  $scope.greenCircles.Start={"x": 10, "y": 6};
  $scope.greenCircles.Finish=[{"x": 9, "y": 5}, {"x": 8, "y": 5}, {"x": 7, "y": 5}, {"x": 6, "y": 5}];
  $scope.yellowCircles.Home=[{"x": 0, "y": 9}, {"x": 1, "y": 9}, {"x": 0, "y": 10}, {"x": 1, "y": 10}];
  $scope.yellowCircles.Start={"x": 4, "y": 10};
  $scope.yellowCircles.Finish=[{"x": 5, "y": 9}, {"x": 5, "y": 8}, {"x": 5, "y": 7}, {"x": 5, "y": 6}];
  $scope.redCircles.Home=[{"x": 0, "y": 0}, {"x": 1, "y": 0}, {"x": 0, "y": 1}, {"x": 1, "y": 1}];
  $scope.redCircles.Start={"x": 0, "y": 4};
  $scope.redCircles.Finish=[{"x": 1, "y": 5}, {"x": 2, "y": 5}, {"x": 3, "y": 5}, {"x": 4, "y": 5}];
		  
		  
  $scope.boardBorder=7;
  $scope.circleRadius=3;
  $scope.pawnRadius=2;
  $scope.circleDistance=2;
  $scope.circleCoordinates=[];
  $scope.circleCoordinates[0]=$scope.boardBorder;
  $scope.dobbel="een";
  for(var i=1;i<11;i++) {
		$scope.circleCoordinates[i]= $scope.circleCoordinates[i-1]+$scope.circleRadius*2+$scope.circleDistance;
  }
  
  $scope.pawns=[];
  for(var i=0;i<4;i++) { 
	  $scope.pawns[i]={"x": $scope.blueCircles.Home[i].x, "y": $scope.blueCircles.Home[i].y, "colour":"blue"};
  }
  for(var i = 4;i<8;i++) {
	  $scope.pawns[i]={"x": $scope.greenCircles.Home[i%4].x, "y": $scope.greenCircles.Home[i%4].y, "colour":"green"};
  }
  for(var i = 8;i<12;i++) {
	  $scope.pawns[i]={"x": $scope.yellowCircles.Home[i%4].x, "y": $scope.yellowCircles.Home[i%4].y, "colour":"yellow"};
  }
  for(var i = 12;i<16;i++) {
	  $scope.pawns[i]={"x": $scope.redCircles.Home[i%4].x, "y": $scope.redCircles.Home[i%4].y, "colour":"red"};
  }
  
  
  $scope.movePawn = function() {
	$scope.pawns[0].x=9;
	$scope.pawns[0].y=5;
};
  
  });
</script>


<svg style=width:100vmin;height:100vmin;position:fixed;top:0;left:0;bottom:0;right:0; ng-controller="myCtrl" xmlns="http://www.w3.org/2000/svg">
		<circle ng-repeat="indices in whiteCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="white" />
		<circle ng-repeat="indices in blueCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="blue" />
		<circle ng-repeat="indices in greenCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="green" />
		<circle ng-repeat="indices in yellowCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="yellow" />
		<circle ng-repeat="indices in redCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="red" />		
	    <image id="dice" onclick="throwDice()" xlink:href="img/1.png" ng-attr-x="{{circleCoordinates[5]-circleRadius}}%" ng-attr-y="{{circleCoordinates[5]-circleRadius}}%" height="{{2*circleRadius}}%" width="{{2*circleRadius}}%"/>
		<circle id="red1.pawn" ng-click="movePawn()" ng-attr-cx="{{circleCoordinates[pawns[12].x]}}%" ng-attr-cy="{{circleCoordinates[pawns[12].y]}}%" ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1" fill="{{pawns[12].colour}}" />
		<circle id="red2.pawn" onclick="movePawn2('red2.pawn')" ng-attr-cx="{{circleCoordinates[pawns[13].x]}}%" ng-attr-cy="{{circleCoordinates[pawns[13].y]}}%" ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1" fill="{{pawns[12].colour}}" />
		<circle id="red3.pawn" onclick="movePawn2('red3')" ng-attr-cx="{{circleCoordinates[pawns[14].x]}}%" ng-attr-cy="{{circleCoordinates[pawns[14].y]}}%" ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1" fill="{{pawns[12].colour}}" />
		<circle id="red4.pawn" onclick="movePawn2('red4')" ng-attr-cx="{{circleCoordinates[pawns[15].x]}}%" ng-attr-cy="{{circleCoordinates[pawns[15].y]}}%" ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1" fill="{{pawns[12].colour}}" />

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