var app = angular
		.module('myApp', [])
		.controller(
				'myCtrl',
				function($scope) {
					$scope.whiteCircles = [ {
						"x" : 0,
						"y" : 4
					}, {
						"x" : 1,
						"y" : 4
					}, {
						"x" : 2,
						"y" : 4
					}, {
						"x" : 3,
						"y" : 4
					}, {
						"x" : 4,
						"y" : 4
					}, {
						"x" : 4,
						"y" : 3
					}, {
						"x" : 4,
						"y" : 2
					}, {
						"x" : 4,
						"y" : 1
					}, {
						"x" : 4,
						"y" : 0
					}, {
						"x" : 5,
						"y" : 0
					}, {
						"x" : 6,
						"y" : 0
					}, {
						"x" : 6,
						"y" : 1
					}, {
						"x" : 6,
						"y" : 2
					}, {
						"x" : 6,
						"y" : 3
					}, {
						"x" : 6,
						"y" : 4
					}, {
						"x" : 7,
						"y" : 4
					}, {
						"x" : 8,
						"y" : 4
					}, {
						"x" : 9,
						"y" : 4
					}, {
						"x" : 10,
						"y" : 4
					}, {
						"x" : 10,
						"y" : 5
					}, {
						"x" : 10,
						"y" : 6
					}, {
						"x" : 9,
						"y" : 6
					}, {
						"x" : 8,
						"y" : 6
					}, {
						"x" : 7,
						"y" : 6
					}, {
						"x" : 6,
						"y" : 6
					}, {
						"x" : 6,
						"y" : 7
					}, {
						"x" : 6,
						"y" : 8
					}, {
						"x" : 6,
						"y" : 9
					}, {
						"x" : 6,
						"y" : 10
					}, {
						"x" : 5,
						"y" : 10
					}, {
						"x" : 4,
						"y" : 10
					}, {
						"x" : 4,
						"y" : 9
					}, {
						"x" : 4,
						"y" : 8
					}, {
						"x" : 4,
						"y" : 7
					}, {
						"x" : 4,
						"y" : 6
					}, {
						"x" : 3,
						"y" : 6
					}, {
						"x" : 2,
						"y" : 6
					}, {
						"x" : 1,
						"y" : 6
					}, {
						"x" : 0,
						"y" : 6
					}, {
						"x" : 0,
						"y" : 5
					} ];
					$scope.blueCircles = [ {
						"x" : 9,
						"y" : 0
					}, {
						"x" : 10,
						"y" : 0
					}, {
						"x" : 9,
						"y" : 1
					}, {
						"x" : 10,
						"y" : 1
					}, {
						"x" : 5,
						"y" : 1
					}, {
						"x" : 5,
						"y" : 2
					}, {
						"x" : 5,
						"y" : 3
					}, {
						"x" : 5,
						"y" : 4
					}, {
						"x" : 6,
						"y" : 0
					} ];
					$scope.greenCircles = [ {
						"x" : 9,
						"y" : 9
					}, {
						"x" : 10,
						"y" : 9
					}, {
						"x" : 9,
						"y" : 10
					}, {
						"x" : 10,
						"y" : 10
					}, {
						"x" : 9,
						"y" : 5
					}, {
						"x" : 8,
						"y" : 5
					}, {
						"x" : 7,
						"y" : 5
					}, {
						"x" : 6,
						"y" : 5
					}, {
						"x" : 10,
						"y" : 6
					} ];
					$scope.yellowCircles = [ {
						"x" : 0,
						"y" : 9
					}, {
						"x" : 1,
						"y" : 9
					}, {
						"x" : 0,
						"y" : 10
					}, {
						"x" : 1,
						"y" : 10
					}, {
						"x" : 5,
						"y" : 9
					}, {
						"x" : 5,
						"y" : 8
					}, {
						"x" : 5,
						"y" : 7
					}, {
						"x" : 5,
						"y" : 6
					}, {
						"x" : 4,
						"y" : 10
					} ];
					$scope.redCircles = [ {
						"x" : 0,
						"y" : 0
					}, {
						"x" : 1,
						"y" : 0
					}, {
						"x" : 0,
						"y" : 1
					}, {
						"x" : 1,
						"y" : 1
					}, {
						"x" : 1,
						"y" : 5
					}, {
						"x" : 2,
						"y" : 5
					}, {
						"x" : 3,
						"y" : 5
					}, {
						"x" : 4,
						"y" : 5
					}, {
						"x" : 0,
						"y" : 4
					} ];
					$scope.home = [ {
						"x" : 9,
						"y" : 0
					}, {
						"x" : 10,
						"y" : 0
					}, {
						"x" : 9,
						"y" : 1
					}, {
						"x" : 10,
						"y" : 1
					}, {
						"x" : 9,
						"y" : 9
					}, {
						"x" : 10,
						"y" : 9
					}, {
						"x" : 9,
						"y" : 10
					}, {
						"x" : 10,
						"y" : 10
					}, {
						"x" : 0,
						"y" : 9
					}, {
						"x" : 1,
						"y" : 9
					}, {
						"x" : 0,
						"y" : 10
					}, {
						"x" : 1,
						"y" : 10
					}, {
						"x" : 0,
						"y" : 0
					}, {
						"x" : 1,
						"y" : 0
					}, {
						"x" : 0,
						"y" : 1
					}, {
						"x" : 1,
						"y" : 1
					} ];
					$scope.finish = [ {
						"x" : 5,
						"y" : 1
					}, {
						"x" : 5,
						"y" : 2
					}, {
						"x" : 5,
						"y" : 3
					}, {
						"x" : 5,
						"y" : 4
					}, {
						"x" : 9,
						"y" : 5
					}, {
						"x" : 8,
						"y" : 5
					}, {
						"x" : 7,
						"y" : 5
					}, {
						"x" : 6,
						"y" : 5
					}, {
						"x" : 5,
						"y" : 9
					}, {
						"x" : 5,
						"y" : 8
					}, {
						"x" : 5,
						"y" : 7
					}, {
						"x" : 5,
						"y" : 6
					}, {
						"x" : 1,
						"y" : 5
					}, {
						"x" : 2,
						"y" : 5
					}, {
						"x" : 3,
						"y" : 5
					}, {
						"x" : 4,
						"y" : 5
					} ];
					$scope.blueCircles.Home = [ {
						"x" : 9,
						"y" : 0
					}, {
						"x" : 10,
						"y" : 0
					}, {
						"x" : 9,
						"y" : 1
					}, {
						"x" : 10,
						"y" : 1
					} ];
					$scope.blueCircles.Start = {
						"x" : 6,
						"y" : 0
					};
					$scope.blueCircles.Finish = [ {
						"x" : 5,
						"y" : 1
					}, {
						"x" : 5,
						"y" : 2
					}, {
						"x" : 5,
						"y" : 3
					}, {
						"x" : 5,
						"y" : 4
					} ];
					$scope.greenCircles.Home = [ {
						"x" : 9,
						"y" : 9
					}, {
						"x" : 10,
						"y" : 9
					}, {
						"x" : 9,
						"y" : 10
					}, {
						"x" : 10,
						"y" : 10
					} ];
					$scope.greenCircles.Start = {
						"x" : 10,
						"y" : 6
					};
					$scope.greenCircles.Finish = [ {
						"x" : 9,
						"y" : 5
					}, {
						"x" : 8,
						"y" : 5
					}, {
						"x" : 7,
						"y" : 5
					}, {
						"x" : 6,
						"y" : 5
					} ];
					$scope.yellowCircles.Home = [ {
						"x" : 0,
						"y" : 9
					}, {
						"x" : 1,
						"y" : 9
					}, {
						"x" : 0,
						"y" : 10
					}, {
						"x" : 1,
						"y" : 10
					} ];
					$scope.yellowCircles.Start = {
						"x" : 4,
						"y" : 10
					};
					$scope.yellowCircles.Finish = [ {
						"x" : 5,
						"y" : 9
					}, {
						"x" : 5,
						"y" : 8
					}, {
						"x" : 5,
						"y" : 7
					}, {
						"x" : 5,
						"y" : 6
					} ];
					$scope.redCircles.Home = [ {
						"x" : 0,
						"y" : 0
					}, {
						"x" : 1,
						"y" : 0
					}, {
						"x" : 0,
						"y" : 1
					}, {
						"x" : 1,
						"y" : 1
					} ];
					$scope.redCircles.Start = {
						"x" : 0,
						"y" : 4
					};
					$scope.redCircles.Finish = [ {
						"x" : 1,
						"y" : 5
					}, {
						"x" : 2,
						"y" : 5
					}, {
						"x" : 3,
						"y" : 5
					}, {
						"x" : 4,
						"y" : 5
					} ];

					$scope.colours = [ "#668cff", "#85e085", "#ffffb3",
							"#ff9999" ];
					$scope.optcolours = [ "cyan", "lime", "khaki", "orange" ];
					$scope.boardBorder = 7;
					$scope.circleRadius = 3;
					$scope.pawnRadius = 2;
					$scope.circleDistance = 2;
					$scope.circleCoordinates = [];
					$scope.circleCoordinates[0] = $scope.boardBorder;
					$scope.dobbel = "een";

					$scope.playerNames = [ {
						"name" : "test",
						"x" : 9,
						"y" : 0
					}, {
						"name" : "test2",
						"x" : 9,
						"y" : 9
					}, {
						"name" : "test3",
						"x" : 0,
						"y" : 9
					}, {
						"name" : "test4",
						"x" : 0,
						"y" : 0
					} ];
					$scope.options = [];
					for (var i = 1; i < 11; i++) {
						$scope.circleCoordinates[i] = $scope.circleCoordinates[i - 1]
								+ $scope.circleRadius
								* 2
								+ $scope.circleDistance;
					}

					$scope.pawns = [];
					for (var i = 0; i < 16; ++i) {
						$scope.pawns[i] = {
							"id" : i,
							"x" : $scope.home[i].x,
							"y" : $scope.home[i].y,
							"colour" : $scope.colours[~~(i / 4)]
						};
					}

					$scope.movePawn = function(id) {
						if (stompClient) {
							var chatMessage = {
								content : 'pion ' + id,
								type : 'GAME'
							};

							stompClient.send("/app/chat.sendMessage", {}, JSON
									.stringify(chatMessage));
						}
					};

					$scope.startGame = function() {
						if (stompClient) {
							var chatMessage = {
								content : 'start',
								type : 'GAME'
							};

							stompClient.send("/app/chat.sendMessage", {}, JSON
									.stringify(chatMessage));
						}
						event.preventDefault();

					};
					$scope.throwEffect = function(dice, pid) {
						for (var i = 0; i < 9; ++i) {
							setTimeout(
									function() {
										document.getElementById("dice").href.baseVal = "img/"
												+ ((~~(Math.random() * 6)) + 1)
												+ ".png";
									}, i * 50);
						}
						setTimeout(function() {
							$scope.changeDice(dice, pid);
						}, 500);
					};

					$scope.flashOptions = function() {
						for (var i = 0; i < $scope.pawns.length; ++i) {
							$scope.pawns[i].colour = $scope.colours[~~(i / 4)];
						}
						for (var i = 0; i < $scope.options.length; ++i) {
							$scope.pawns[$scope.options[i]].colour = $scope.optcolours[~~($scope.options[i] / 4)];
						}

					}
					$scope.throwDice = function() {
						if (stompClient) {
							var chatMessage = {
								content : 'throw',
								type : 'GAME'
							};

							stompClient.send("/app/chat.sendMessage", {}, JSON
									.stringify(chatMessage));
						}
						event.preventDefault();
					};

					$scope.changeDice = function(dice, pid) {
						document.getElementById("dice").href.baseVal = "img/"
								+ dice + ".png";
						document.getElementById("dicebg").style.fill = $scope.colours[pid]
						document.getElementById("dicebg").style.stroke = $scope.colours[pid];
					}
					$scope.onMessageReceived = function(payload) {
						var message = JSON.parse(payload.body);

						var messageElement = document.createElement('li');

						if (message.type === 'JOIN') {
							messageElement.classList.add('event-message');
							message.content = message.sender + ' joined!';
						} else if (message.type === 'LEAVE') {
							messageElement.classList.add('event-message');
							message.content = message.sender + ' left!';
						} else if (message.type === 'GAME_OPTIONS') {
							messageElement.classList.add('event-message');

							var total = JSON.parse(message.content);
							var data = total.pawns;
							var pawns = $scope.pawns;
							var players = total.players;
							$scope.options = total.options;
							$scope.flashOptions();
							for (var i = 0; i < data.length; ++i) {
								var pawn = pawns[data[i].id];
								var index = data[i].index;
								pawn.location = data[i].location;
								if (data[i].location == "huis") {
									pawn.x = $scope.home[(~~(i / 4) * 4)
											+ index].x;
									pawn.y = $scope.home[(~~(i / 4) * 4)
											+ index].y;
								} else if (data[i].location == "bord") {
									pawn.x = $scope.whiteCircles[index].x;
									pawn.y = $scope.whiteCircles[index].y;
								} else if (data[i].location == "hok") {
									pawn.x = $scope.finish[(~~(i / 4) * 4)
											+ index].x;
									pawn.y = $scope.finish[(~~(i / 4) * 4)
											+ index].y;
								}

							}

							for (var i = 0; i < players.length; ++i) {
								$scope.playerNames[i].name = players[i];
							}
							if (total.action == "throw") {
								$scope.throwEffect(total.dice, total.pid);
							} else {
								$scope.changeDice(total.dice, total.pid);
							}

							document.getElementById("start").style.display = "none";
							$scope.$apply();
							// data[{id, location, index},{..},{..}]
						} else {
							messageElement.classList.add('chat-message');

							var avatarElement = document.createElement('i');
							var avatarText = document
									.createTextNode(message.sender[0]);
							avatarElement.appendChild(avatarText);
							avatarElement.style['background-color'] = getAvatarColor(message.sender);

							messageElement.appendChild(avatarElement);

							var usernameElement = document
									.createElement('span');
							var usernameText = document
									.createTextNode(message.sender);
							usernameElement.appendChild(usernameText);
							messageElement.appendChild(usernameElement);
						}

						var textElement = document.createElement('p');
						var messageText = document
								.createTextNode(message.content);
						textElement.appendChild(messageText);

						messageElement.appendChild(textElement);

						messageArea.appendChild(messageElement);
						messageArea.scrollTop = messageArea.scrollHeight;
					};

					$scope.sendMessage = function(event) {
						var messageContent = messageInput.value.trim();

						if (messageContent && stompClient) {
							var chatMessage = {
								content : messageInput.value,
								type : 'CHAT'
							};

							stompClient.send("/app/chat.sendMessage", {}, JSON
									.stringify(chatMessage));
							messageInput.value = '';
						}
						event.preventDefault();
					};

					$scope.onConnected = function() {
						// Subscribe to the Public Channel
						stompClient.subscribe('/channel/public',
								$scope.onMessageReceived);

						// Tell your username to the server
						stompClient.send("/app/chat.addUser", {}, JSON
								.stringify({
									sender : null,
									type : 'JOIN'
								}))

						connectingElement.classList.add('hidden');
					};

					$scope.onError = function(error) {
						connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
						connectingElement.style.color = 'red';
					};

					$scope.conn = function() {
						var socket = new SockJS('./ws');
						stompClient = Stomp.over(socket);

						stompClient.connect({}, $scope.onConnected,
								$scope.onError);
					};
					$scope.conn();

				});