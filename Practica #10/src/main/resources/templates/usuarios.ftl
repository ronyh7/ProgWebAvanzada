<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <!-- Bootstrap -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
      <link href="/static/css/blog.css" rel="stylesheet">
      <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">



      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <#include "header.ftl">
    <div class="container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th><@spring.message "nombre_usuario"/></th>
                <th><@spring.message "nombre"/></th>
                <th><@spring.message "apellido"/></th>
            </tr>
            </thead>
            <tbody>
            <a href="/usuario/crearUsuario"><@spring.message "nuevo_usuario"/></a>
            <#list usuarios as u>
            <tr>
                <td>${u.username}</td>
                <td>${u.nombre}</td>
                <td>${u.apellido}</td>
            </tr>
            </#list>

            </tbody>
        </table>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>