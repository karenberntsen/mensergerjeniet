var app = angular.module('adminApp', []);
app.controller('adminCtrl', function($scope) {
	$scope.enabledUsers = [];
	$scope.disabledUsers = [];
	$scope.deletedUsers = [];
	
	$scope.loadEnabledUsers = function() {
		getRequest(null, "/admin/enabledUsers", $scope.loadEnabledUsersCallback);
	};
	$scope.loadDisabledUsers = function() {
		getRequest(null, "/admin/disabledUsers", $scope.loadDisabledUsersCallback);
	};
	$scope.loadDeletedUsers = function() {
		getRequest(null, "/admin/deletedUsers", $scope.loadDeletedUsersCallback);
	};
	
	$scope.loadEnabledUsersCallback = function(responseText) {
		$scope.enabledUsers = JSON.parse(responseText);
		$scope.$apply();
	}
	$scope.loadDisabledUsersCallback = function(responseText) {
		$scope.disabledUsers = JSON.parse(responseText);
		$scope.$apply();
	}
	$scope.loadDeletedUsersCallback = function(responseText) {
		$scope.deletedUsers = JSON.parse(responseText);
		$scope.$apply();
	}
	
	$scope.enableUser = function(id) {
		alert("enable user: " + id);
		putRequest(null, "/admin/users/"+id+"/enable", $scope.enableUserCallback)
	}
	$scope.enableUserCallback = function(response) {
		$scope.loadData();
	}
	
	$scope.deleteUser = function(id) {
		alert("delete user: " + id);
		deleteRequest(null, "/admin/users/"+id, $scope.deleteUserCallback)
	}
	$scope.deleteUserCallback = function(response) {
		$scope.loadData();
	}
	
	$scope.loadData = function() {
		$scope.loadEnabledUsers();
		$scope.loadDisabledUsers();
		$scope.loadDeletedUsers();
	}
	$scope.loadData();
});
