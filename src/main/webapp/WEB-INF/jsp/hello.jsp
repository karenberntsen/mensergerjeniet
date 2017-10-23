<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/css/app.css" />" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/bootstrap.min.css">
 <title>Hello World!</title>
</head>
<body class="security-app">
  <%@ include file="../html-part/navbar.jsp" %>
	<div class="details">

		<h2>Spring Security - JDBC Authentication</h2>
		<a href="http://www.programming-free.com/2016/01/spring-security-spring-data-jpa.html" class="button green small">Tutorial</a> 
		<a href="https://github.com/priyadb/SpringSecurityJdbcApp/archive/master.zip"
			class="button red small">Download</a>
	</div>

	<div class="lc-block">
		<h1>
			Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
		</h1>
		<form action="<c:url value="/logout" />" method="post">
			<input type="submit" class="button red big" value="Sign Out" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>

	<%@ include file="../html-part/bootstrap.html" %>
</body>
</html>
