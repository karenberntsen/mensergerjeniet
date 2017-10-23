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
			<li class="nav-item right"><a class="nav-link"
				href="<c:url value="./admin"/>">Admin</a>
			</li>
			<li class="nav-item right"><a class="nav-link"
				href="<c:url value="./login"/>">Login</a>
			</li>
			<li class="nav-item right"><a class="nav-link" href="#"
				onclick="logout()">Logout</a>
			</li>
		</ul>
	</div>
</nav>