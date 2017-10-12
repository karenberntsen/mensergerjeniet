'use strict';
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;
var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];
var pawns;


function movePawn2(pawn) {
	alert("pawn");
	if(stompClient) {
        var chatMessage = {
           content: 'pion '+pawn,
            type: 'GAME'
        };

        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
    }
}

function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }

    var index = Math.abs(hash % colors.length);
    return colors[index];
}

//messageForm.addEventListener('submit', sendMessage, true)
