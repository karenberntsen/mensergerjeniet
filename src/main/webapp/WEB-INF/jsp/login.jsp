<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
 <title>Spring Security Example</title>
</head>
<body class="security-app">
  <%@ include file="../html-part/navbar.html" %>
      <h2>Login</h2>
	<form action="./login" method="post">

		<div class="lc-block">
			<div>
				<input type="text" class="style-4" name="username"
					placeholder="User Name" />
			</div>
			<div>
				<input type="password" class="style-4" name="password"
					placeholder="Password" />
			</div>
			<div>
				<input type="submit" value="Sign In" class="button red small" />
			</div>
			<c:if test="${param.error ne null}">
				<div class="alert-danger">Invalid username and password.</div>
			</c:if>
			<c:if test="${param.logout ne null}">
				<div class="alert-normal">You have been logged out.</div>
			</c:if>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	Nog geen account? registreer <a href="./register">hier</a>.
<%@ include file="../html-part/bootstrap.html" %> 
</body>
</html>
