<svg
	style="width: 100vmin; height: 100vmin; top: 300; left: 0; bottom: 0; right: 0; margin-left:auto; margin-right:auto; display:block;
	-moz-user-select: none; -webkit-user-select: none; -ms-user-select:none; user-select:none;-o-user-select:none;
	stroke-width: 0px; "
	xmlns="http://www.w3.org/2000/svg"
	unselectable="on"
	onselectstart="return false;" 
	onmousedown="return false;">
	
	<rect ng-attr-x="2.5%"
			ng-attr-y="2.5%"
			height="90%" width="90%"
			fill="#f2ec80" stroke-width="0.5%" stroke="#ff0000"/> 
	<!-- Zet de namen op het scherm -->
	<text ng-repeat="player in playerNames"
		ng-attr-x="{{player.x}}%"
		ng-attr-y="{{player.y}}%" text-anchor="middle"
		stroke="black" stroke-width="2px">{{player.name}}</text>
		
	<!-- Zet de cirkels op het scherm -->
	<circle ng-repeat="circle in allCircles"
		ng-attr-cx="{{circleCoordinates[circle.x]}}%"
		ng-attr-cy="{{circleCoordinates[circle.y]}}%"
		ng-attr-r="{{circleRadius}}%" stroke="black" stroke-width="1"
		fill="{{circle.c || 'white'}}" />
	
	<!-- Zet de pionnen op het scherm met ID -->	
	<g ng-repeat="pawn in pawns"
		ng-attr-x="{{circleCoordinates[pawn.x]}}%"
		ng-attr-y="{{circleCoordinates[pawn.y]}}%"
		ng-click="movePawn(pawn.id)">
		<circle id="{{pawn.id}}"
			ng-attr-cx="{{circleCoordinates[pawn.x]}}%"
			ng-attr-cy="{{circleCoordinates[pawn.y]}}%"
			ng-attr-r="{{pawnRadius}}%" stroke="black" stroke-width="1"
			fill="{{pawn.colour}}">
		</circle>
	<!-- 	<text ng-attr-x="{{circleCoordinates[pawn.x] + 0.1}}%"
			ng-attr-y="{{circleCoordinates[pawn.y] + 0.8}}%" text-anchor="middle"
			stroke="black" stroke-width="2px">{{pawn.id}}
		</text> -->
	</g>
	
	<!-- Zet de dobbelsteen op het scherm -->
	<g>
		<rect id="dicebg"
			ng-attr-x="{{circleCoordinates[5]-circleRadius}}%"
			ng-attr-y="{{circleCoordinates[5]-circleRadius}}%"
			height="{{2*circleRadius}}%" width="{{2*circleRadius}}%"
			fill="#668cff" stroke="#668cff"/> 
		<image id="dice" ng-click="throwDice()" xlink:href="../img/1.png"
			ng-attr-x="{{circleCoordinates[5]-circleRadius}}%"
			ng-attr-y="{{circleCoordinates[5]-circleRadius}}%"
			height="{{2*circleRadius}}%" width="{{2*circleRadius}}%" />
	</g>
	
	<!-- Zet de startknop op het scherm -->
	<g>
		<rect 	ng-attr-x="23%"
				ng-attr-y="0.25%" 
				fill="white" width="4.2%" height="2.2%"/> 
		<text 	ng-attr-x="25%"
				ng-attr-y="2%" text-anchor="middle"
				stroke="black" stroke-width="2px" ng-click="throwDiceHax()">HAX</text>
	</g>
	<g>
		<rect 	ng-attr-x="36.5%"
				ng-attr-y="0.25%" 
				fill="white" width="5.2%" height="2.2%" ng-hide="started"/> 
		<text 	ng-attr-x="39%"
				ng-attr-y="2%" text-anchor="middle"
				stroke="black" stroke-width="2px" ng-click="joinGame()" ng-hide="started">JOIN</text>
	</g>
	<g>
		<rect 	ng-attr-x="52%"
				ng-attr-y="0.25%" 
				fill="white" width="6.2%" height="2.2%" ng-hide="started"/> 
		<text 	ng-attr-x="55%"
				ng-attr-y="2%" text-anchor="middle"
				stroke="black" stroke-width="2px" ng-click="startGame()" ng-hide="started">START</text>
	</g>
	<g>
		<rect 	ng-attr-x="65.5%"
				ng-attr-y="0.25%" 
				fill="white" width="7.2%" height="2.2%"/> 
		<text 	ng-attr-x="69%"
				ng-attr-y="2%" text-anchor="middle"
				stroke="black" stroke-width="2px" ng-click="stopGame()">DELETE</text>
	</g>
</svg>