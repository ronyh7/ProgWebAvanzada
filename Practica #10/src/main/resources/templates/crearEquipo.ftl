<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Articulo</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/blog.css" rel="stylesheet">
      <link href="/css/articulo.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  <#include "header.ftl">
  <div class="container">
        <div class="col-md-3"></div>
        <div class="col-md-4">
            <h1>Inserta un Equipo</h1>
            <form th:action="@{/crearEquipo}" th:object="${equipo}" method="POST" >
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <label>Nombre:</label> <input name="nombre" type="text"/><br/>
                <label>Descripcion:</label> <textarea name="descripcion" maxlength="500"></textarea><br/>
                <label>Cantidad:</label><input name="cantidad" type="number"/><br/>
                <label>SubFamilia:</label>
                <select class="form-control" id="subFamiliaEquipo" name="subFamilia">
                <#list familias as s>
                    <option value="${s.id}">${s.nombre}</option>
                </#list>
                </select>
                <button name="Insertar" type="submit">Enviar</button>
            </form>
        </div>
    </div>
            <!-- /.blog-main -->




    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="/js/subfamilia.js"></script>

  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
