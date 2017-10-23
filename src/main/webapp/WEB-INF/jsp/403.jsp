<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../html-part/jsCssIncludes.jsp" %>
	<link href="<c:url value="/css/app.css" />" rel="stylesheet" type="text/css"></link>
	<title>No Permission!</title>
</head>
<body class="security-app">
  <%@ include file="../html-part/navbar.jsp" %>
	<div class="lc-block">		
		<div class="alert-danger">
			<h3>You do not have permission to access this page!</h3>	
		</div>
		<form action="<c:url value="/logout"/>" method="post">
			<input type="submit" class="button red big" value="Sign in as different user" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>		
	</div>	
	
</body>
</html>
