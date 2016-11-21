<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title><@spring.message "iniciar_sesion"/></title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">
      <form class="form-signin" role="form" action="/login" method="post">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <label for="inputEmail" class="sr-only"><@spring.message "nombre_usuario"/></label>
        <input type="text" name ="username" id="username" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only"><@spring.message "contrasena"/></label>
        <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><@spring.message "iniciar_sesion"/></button>
          <hr>
          <h4><a href="/crearCliente"><@spring.message "registrar_cliente"/></a> </h4>
      </form>

    </div> <!-- /container -->
    <#if error.isPresent()>
    <p>usuario no existe....</p>
    </#if>


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
