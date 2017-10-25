<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="adminApp">
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin page</title>
		<%@ include file="../html-part/jsCssIncludes.jsp" %>
		<script src="<c:url value="/js/admin.js"/>"  ></script>
		<script> var _csrf ={"name": "${_csrf.parameterName}", "token": "${_csrf.token}"}; </script>
		<link rel="stylesheet" href="<c:url value="/css/admin.css" />">
	</head>
	<body>
		<%@ include file="../html-part/adminNavbar.jsp"%>
		<div>
			<h1>Users</h1>
			<div ng-controller="adminCtrl">
				<table class="blueTable">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Status</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tr ng-repeat="user in enabledUsers">
						<td>{{ user.id }}</td>
						<td>{{ user.userName}}</td>
						<td>{{ user.enabled }}</td>
						<td ng-show= "{{ user.enabled != 'DELETED'  }} " >
							<input type="button" value="X" ng-click="softDeleteUser(user.id)"/>
						</td>
					</tr>
				</table>
				<h1>Disabled Users</h1>
				<table class="blueTable">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Status</th>
							<th>Delete</th>
							<th>Enable</th>
						</tr>
					</thead>
					<tr ng-repeat="user in disabledUsers">
						<td>{{ user.id }}</td>
						<td>{{ user.userName}}</td>
						<td>{{ user.enabled }}</td>
						<td ng-show= "{{ user.enabled != 'DELETED'  }} " >
							<input type="button" value="X" ng-click="softDeleteUser(user.id)"/>
						</td>
						<td ng-show= "{{ user.enabled  == 'DISABLED' }} ">
							<input type="button" value="E" ng-click="enableUser(user.id)"/>
						</td>
					</tr>
				</table>
				<h1>Deleted Users</h1>
				<table class="blueTable">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Hard Delete</th>
						</tr>
					</thead>
					<tr ng-repeat="user in deletedUsers">
						<td>{{ user.id }}</td>
						<td>{{ user.userName}}</td>
						<td>
							<input type="button" value="X" ng-click="hardDeleteUser(user.id)"/>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>