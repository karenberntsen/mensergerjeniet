<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"  %>
<style>
      .errormessage {
      	color : red;
      }
 	body {
  height: 1080px;
  border: 20px solid;
  border-image: linear-gradient(to left, rgba(78, 137, 176, 1) 1%, rgba(115, 192, 85, 1) 100%);
  border-image-slice: 1;
  background: linear-gradient(to left, rgba(78, 137, 176, 1) 1%, rgba(115, 192, 85, 1) 100%);
}
</style>
<script src="<c:url value="/js/main.js"/>"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link "  href="<c:url value="/" />">Home</a>
      </li>
        <a class="nav-link active" href="<c:url value="/highscores" />">Highscores</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value="./admin"/>">Admin</a>
      </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <li class="nav-item active right">
        <a class="nav-link" href="<c:url value="./login"/>">Login</a>
      </li>
      <li class="nav-item active right">
        <a class="nav-link" href="#" onclick="logout()">Logout</a>
      </li>
    </ul>
  </div>
</nav>