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
		 location.pathname = location.pathname+"/mejn/"+$("#boardId")[0].value;
	}
	$scope.getGamesList();
});