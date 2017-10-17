<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
      
   </head>

   <body>
  <%@ include file="../html-part/navbar.html" %>
   
      <h2>Create new user</h2>
      <span class='errormessage'>${message}</span>
   <form:form method = "POST" action = "./register">
   <div class="form-group row">
    <form:label path = "userName" for="exampleInputUsername1" class="col-sm-2 col-form-label">Username</form:label>
    <form:input path = "userName" type="text" class="form-control col-sm-4" id="exampleInputUsername1" placeholder="Enter username" value='${userName}'/>
    </div>

<div class="form-group row">
    <form:label path = "email" for="exampleInputEmail1" class="col-sm-2 col-form-label">Email address</form:label>
    <form:input path = "email" type="email" class="form-control col-sm-4" id="exampleInputEmail1" placeholder="Enter email" value='${email}'/>
    </div>
    <div class="form-group row">
    <form:label path = "password" for="exampleInputPassword1" class="col-sm-2 col-form-label">Password</form:label>
    <form:input path = "password" type="password" class="form-control col-sm-4" id="exampleInputPassword1" placeholder="Password"/>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  <button type="submit" class="btn btn-primary ml-1">Create</button>
    </div>
</form:form>
      
   </body>
   
</html>