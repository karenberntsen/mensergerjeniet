<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
<link rel="stylesheet" href="./css/bootstrap.min.css" >
	<script>
		var _csrf ={"name": "${_csrf.parameterName}", "token": "${_csrf.token}"};
		</script>
</head>
<body>
	<%@ include file="../html-part/navbar.jsp"%>
	<h2>Create new user</h2>
	<span class='errormessage'>${message}</span>
	<form method="POST" action="<c:url value="/register"/>">
		<div class="form-group row">
			<label name="username" for="username"
				class="col-sm-2 col-form-label">Username</label>
			<input id="username" type="text" class="form-control col-sm-4"
				 placeholder="Enter username"
				value='${userName}' />
		</div>
		<div class="form-group row">
			<label name="email" for="email"
				class="col-sm-2 col-form-label">Email address</label>
			<input id="email" type="email" class="form-control col-sm-4"
				 placeholder="Enter email" value='${email}' />
		</div>
		<div class="form-group row">
			<label name="password" for="password"
				class="col-sm-2 col-form-label">Password</label>
			<input id="password" type="password"
				class="form-control col-sm-4" 
				placeholder="Password" />
			<input type="button" onclick="register()"class="btn btn-primary ml-1" value="Create"/>
		</div>
	</form>
	<%@ include file="../html-part/bootstrap.html"%>
</body>

</html>