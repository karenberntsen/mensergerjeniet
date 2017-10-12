<!DOCTYPE html>
<html ng-app="myApp">

<script src="js/angular.min.js"></script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<script>
var app = angular.module('myApp', [])
.controller('myCtrl', function($scope) {
  $scope.whiteCircles = [
		 {"x": 0, "y": 4}, {"x": 1, "y": 4}, {"x": 2, "y": 4}, {"x": 3, "y": 4}, {"x": 4, "y": 4}, {"x": 4, "y": 3},  {"x": 4, "y": 2}, {"x": 4, "y": 1}, {"x": 4, "y": 0}, {"x": 5, "y": 0}, 
		 {"x": 6, "y": 0}, {"x": 6, "y": 1}, {"x": 6, "y": 2}, {"x": 6, "y": 3}, {"x": 6, "y": 4}, {"x": 7, "y": 4}, {"x": 8, "y": 4}, {"x": 9, "y": 4}, {"x": 10, "y": 4}, {"x": 10, "y": 5}, 
	 					 {"x": 10, "y": 6}, {"x": 9, "y": 6}, {"x": 8, "y": 6}, {"x": 7, "y": 6}, {"x": 6, "y": 6}, {"x": 6, "y": 7}, {"x": 6, "y": 8}, {"x": 6, "y": 9}, {"x": 6, "y": 10}, {"x": 5, "y": 10}, 
	 					 {"x": 4, "y": 10}, {"x": 4, "y": 9}, {"x": 4, "y": 8}, {"x": 4, "y": 7}, {"x": 4, "y": 6}, {"x": 3, "y": 6}, {"x": 2, "y": 6}, {"x": 1, "y": 6}, {"x": 0, "y": 6}, {"x": 0, "y": 5}];
  $scope.blueCircles=[{"x": 9, "y": 0}, {"x": 10, "y": 0}, {"x": 9, "y": 1}, {"x": 10, "y": 1}, {"x": 5, "y": 1}, {"x": 5, "y": 2}, {"x": 5, "y": 3}, {"x": 5, "y": 4}, {"x": 6, "y": 0}];
  $scope.greenCircles=[{"x": 9, "y": 9}, {"x": 10, "y": 9}, {"x": 9, "y": 10}, {"x": 10, "y": 10}, {"x": 9, "y": 5}, {"x": 8, "y": 5}, {"x": 7, "y": 5}, {"x": 6, "y": 5}, {"x": 10, "y": 6}];
  $scope.yellowCircles=[{"x": 0, "y": 9}, {"x": 1, "y": 9}, {"x": 0, "y": 10}, {"x": 1, "y": 10}, {"x": 5, "y": 9}, {"x": 5, "y": 8}, {"x": 5, "y": 7}, {"x": 5, "y": 6}, {"x": 4, "y": 10}];
  $scope.redCircles=[{"x": 0, "y": 0}, {"x": 1, "y": 0}, {"x": 0, "y": 1}, {"x": 1, "y": 1}, {"x": 1, "y": 5}, {"x": 2, "y": 5}, {"x": 3, "y": 5}, {"x": 4, "y": 5}, {"x": 0, "y": 4}];
  $scope.colours= ["blue","green","yellow","red"];
  $scope.home=[{"x": 9, "y": 0}, {"x": 10, "y": 0}, {"x": 9, "y":  1}, {"x": 10, "y":  1},
	  		   {"x": 9, "y": 9}, {"x": 10, "y": 9}, {"x": 9, "y": 10}, {"x": 10, "y": 10},
	  		   {"x": 0, "y": 9}, {"x":  1, "y": 9}, {"x": 0, "y": 10}, {"x":  1, "y": 10},
	  		   {"x": 0, "y": 0}, {"x":  1, "y": 0}, {"x": 0, "y":  1}, {"x":  1, "y":  1}];
  $scope.finish = [{"x": 5, "y": 1}, {"x": 5, "y": 2}, {"x": 5, "y": 3}, {"x": 5, "y": 4},
	  {"x": 9, "y": 5}, {"x": 8, "y": 5}, {"x": 7, "y": 5}, {"x": 6, "y": 5},
	  {"x": 5, "y": 9}, {"x": 5, "y": 8}, {"x": 5, "y": 7}, {"x": 5, "y": 6},
	  {"x": 1, "y": 5}, {"x": 2, "y": 5}, {"x": 3, "y": 5}, {"x": 4, "y": 5}];
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
  for(var i=0; i < 16; ++i) {
	  $scope.pawns[i]={"id": i, "x": $scope.home[i].x, "y": $scope.home[i].y, "colour": $scope.colours[~~(i/4)]};
  }
  
  $scope.movePawn = function(id) {
	 if(stompClient) {
	    var chatMessage = {
	       content: 'pion '+id,
	       type: 'GAME'
	    };

	    stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
	 }
};

$scope.startGame = function() {
	 if(stompClient) {
	        var chatMessage = {
	            content: 'start',
	            type: 'GAME'
	        };

	        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
	    }
	    event.preventDefault();
	
};
  
$scope.throwDice = function() {
    if(stompClient) {
        var chatMessage = {
            content: 'throw',
            type: 'GAME'
        };

        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
    }
    event.preventDefault();
}
  
  $scope.onMessageReceived = function(payload) {
	    var message = JSON.parse(payload.body);

	    var messageElement = document.createElement('li');

	    if(message.type === 'JOIN') {
	        messageElement.classList.add('event-message');
	        message.content = message.sender + ' joined!';
	    } else if (message.type === 'LEAVE') {
	        messageElement.classList.add('event-message');
	        message.content = message.sender + ' left!';
	    }else if (message.type === 'GAME_START') {
	        messageElement.classList.add('event-message');
	        
	        var data = JSON.parse(message.content);
	        var pawns = $scope.pawns;
	        for(var i =0; i < data.length; ++i) {
	        	var pawn = pawns[data[i].id];
	        	var index = data[i].index;
	        	pawn.location = data[i].location;
	        	if(data[i].location == "huis") {
	        		pawn.x = $scope.home[(~~(i/4)*4) + index].x;
	        		pawn.y = $scope.home[(~~(i/4)*4) + index].y;
	        	} else if(data[i].location == "bord") {
	        		pawn.x = $scope.whiteCircles[index].x;
	        		pawn.y = $scope.whiteCircles[index].y;
	        	} else if(data[i].location == "hok") {
	        		pawn.x = $scope.finish[~~(i/4) + index].x;
	        		pawn.y = $scope.finish[~~(i/4) + index].y;
	        	}
	        	
	        }
	        $scope.$apply();
	        //data[{id, location, index},{..},{..}]
	    }else if (message.type === 'GAME_OPTIONS') {
	        messageElement.classList.add('event-message');
	        
	        var data = JSON.parse(message.content);
	        document.getElementById("dice").href.baseVal = "img/"+data.dice+".png";
	        //data.dice , data.options
	        //TODO game stuff
	    } else {
	        messageElement.classList.add('chat-message');

	        var avatarElement = document.createElement('i');
	        var avatarText = document.createTextNode(message.sender[0]);
	        avatarElement.appendChild(avatarText);
	        avatarElement.style['background-color'] = getAvatarColor(message.sender);

	        messageElement.appendChild(avatarElement);

	        var usernameElement = document.createElement('span');
	        var usernameText = document.createTextNode(message.sender);
	        usernameElement.appendChild(usernameText);
	        messageElement.appendChild(usernameElement);
	    }

	    var textElement = document.createElement('p');
	    var messageText = document.createTextNode(message.content);
	    textElement.appendChild(messageText);

	    messageElement.appendChild(textElement);

	    messageArea.appendChild(messageElement);
	    messageArea.scrollTop = messageArea.scrollHeight;
	};
	
$scope.sendMessage = function(event) {
    var messageContent = messageInput.value.trim();

    if(messageContent && stompClient) {
        var chatMessage = {
            content: messageInput.value,
            type: 'CHAT'
        };

        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
};

$scope.onConnected = function() {
    // Subscribe to the Public Channel
    stompClient.subscribe('/channel/public', $scope.onMessageReceived);

    // Tell your username to the server
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({sender: null, type: 'JOIN'})
    )

    connectingElement.classList.add('hidden');
};

$scope.onError = function(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
};

$scope.conn = function() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, $scope.onConnected, $scope.onError);
};
$scope.conn();

});
</script>
<div  ng-controller="myCtrl" > 

	<svg style=width:100vmin;height:100vmin;position:fixed;top:0;left:0;bottom:0;right:0; xmlns="http://www.w3.org/2000/svg">
			<circle ng-repeat="indices in whiteCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="white" />
			<circle ng-repeat="indices in blueCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="blue" />
			<circle ng-repeat="indices in greenCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="green" />
			<circle ng-repeat="indices in yellowCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="yellow" />
			<circle ng-repeat="indices in redCircles" ng-attr-cx="{{circleCoordinates[indices.x]}}%" ng-attr-cy="{{circleCoordinates[indices.y]}}%" ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1" fill="red" />		
		    <image id="dice" ng-click="throwDice()" xlink:href="img/1.png" ng-attr-x="{{circleCoordinates[5]-circleRadius}}%" ng-attr-y="{{circleCoordinates[5]-circleRadius}}%" height="{{2*circleRadius}}%" width="{{2*circleRadius}}%"/>
			
			<circle ng-repeat="pawn in pawns" id="{{pawn.id}}" ng-click="movePawn(pawn.id)" ng-attr-cx="{{circleCoordinates[pawn.x]}}%" ng-attr-cy="{{circleCoordinates[pawn.y]}}%" ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1" fill="{{pawn.colour}}" />
			
			<!-- <circle id="red1.pawn" ng-click="movePawn()" ng-attr-cx="{{circleCoordinates[pawns[12].x]}}%" ng-attr-cy="{{circleCoordinates[pawns[12].y]}}%" ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1" fill="{{pawns[12].colour}}" />
			<circle id="red2.pawn" ng-click="movePawn()" ng-attr-cx="{{circleCoordinates[pawns[13].x]}}%" ng-attr-cy="{{circleCoordinates[pawns[13].y]}}%" ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1" fill="{{pawns[12].colour}}" />
			<circle id="red3.pawn" ng-click="movePawn()" ng-attr-cx="{{circleCoordinates[pawns[14].x]}}%" ng-attr-cy="{{circleCoordinates[pawns[14].y]}}%" ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1" fill="{{pawns[12].colour}}" />
			<circle id="red4.pawn" ng-click="movePawn()" ng-attr-cx="{{circleCoordinates[pawns[15].x]}}%" ng-attr-cy="{{circleCoordinates[pawns[15].y]}}%" ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1" fill="{{pawns[12].colour}}" />
	-->
	 <image id="start" ng-click="startGame()" xlink:href="img/start_button.png" ng-attr-x="30%" ng-attr-y="80%" height="{{5*circleRadius}}%" width="{{10*circleRadius}}%"/>
			
	</svg>
	<div id="chat-page" style="margin-left: 750px">
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
</div>
    <script src="/js/sockjs.min.js"></script>
    <script src="/js/stomp.min.js"></script>
    <script src="/js/main.js"></script>
</body>
</html>