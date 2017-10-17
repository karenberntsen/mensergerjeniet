var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
	$scope.highscores = [];
	
	$scope.loadScores = function() {
		getRequest(null, "/highscoresdata", $scope.loadScoresCallback);
	};
	
	$scope.loadScoresCallback = function(responseText) {
		$scope.highscores = JSON.parse(responseText);
		$scope.$apply();
	}
	$scope.loadScores();
});
