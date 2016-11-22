<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns="http://www.w3.org/1999/html">
<head>
<title>Insertar</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/insertar.css" rel="stylesheet" >
    <#include "header.ftl">

</head>
<body>
    <div class="container">
        <div class="col-md-3"></div>
        <div class="col-md-5">
            <h1><@spring.message "nuevo_cliente"/></h1>
            <form id="upload-file-form" th:action="@{/crearCliente}" enctype='multipart/form-data' th:object="${usuario}" method="POST" >
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <label><@spring.message "nombre_usuario"/>:</label> <input name="username" type="text" required="true" /><br/>
                <label><@spring.message "contrasena"/>:</label> <input name="password" type="password" required="true"/><br/>
                <label><@spring.message "nombre"/>:</label> <input name="nombre"  type="text" required="true"/><br/>
                <label><@spring.message "apellido"/>:</label> <input name="apellido"  type="text" required="true"/><br/>
                <label><@spring.message "cedula"/>:</label> <input name="cedula" type="text" required="true"/><br/>
                <label for="upload-file-input"><@spring.message "foto" />:</label>
                <input id="upload-file-input" type="file" name="uploadfile" accept="*"/>
                <button name="usuario" id="usuario" type="submit"><@spring.message "nuevo_cliente"/></button>
            </form>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>