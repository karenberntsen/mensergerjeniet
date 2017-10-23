<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/" />">Home</a></li>
			<a class="nav-link" href="<c:url value="/highscores" />">Highscores</a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="./admin"/>">Admin</a>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
		<c:choose>
			<c:when test="${empty sessionScope.name}">
				<li class="nav-item right"><a class="nav-link"
					href="<c:url value="./login"/>">Login</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="nav-item right">
					<a class="nav-link active disabled" disabled
					><c:out value="${sessionScope.name}"/> </a>
				</li>
				<li class="nav-item right">
					<form action="<c:url value="/logout"/>" method="post">
						<a href="javascript:;" onclick="parentNode.submit();" class="nav-link active">Logout</a>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</li>
			</c:otherwise>
		</c:choose>
	
		</ul>
	</div>
</nav>