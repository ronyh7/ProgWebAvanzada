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
            <h1>Inserta un nuevo usuario</h1>
            <form th:action="@{/usuario/crear_usuario}" th:object="${usuario}" method="POST" >
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <label>Username:</label> <input name="username" type="text" required="true" /><br/>
                <label>Password:</label> <input name="password" type="password" required="true"/><br/>
                <label>Nombre:</label> <input name="nombre"  type="text" required="true"/><br/>
                <label>Apellido:</label> <input name="apellido"  type="text" required="true"/><br/>
                <label>Cedula:</label> <input name="cedula" type="text" required="true"/><br/>
                <label>Roles:</label><input name="rolesTemp" type="text" required="true"/><br/>
                <button name="usuario" id="usuario" type="submit">Enviar</button>
            </form>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>