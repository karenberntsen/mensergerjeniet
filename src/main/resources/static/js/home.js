var app = angular.module('indexApp', []);
app.controller('indexCtrl', function($scope) {
	$scope.list = [];
	$scope.getGamesList = function () {
		getRequest(null, "/gameslist", $scope.getGamesListCallback);
	}
	$scope.getGamesListCallback = function(responseText) {
		$scope.list = JSON.parse(responseText);
		$scope.$apply();
	}
	
	$scope.newBoard = function() {
		var value = $("#boardId")[0].value;
		var pat = /^([\w]{1,})$/;
		if(pat.test(value) == false) {
			$('.errormessage').text("voer een bordnaam met alleen letters & cijfers in.");
			$('.errormessage').removeClass('invisible');
			return;
		}
		location.pathname = location.pathname+"mejn/"+$("#boardId")[0].value;
	}
	$scope.getGamesList();
});