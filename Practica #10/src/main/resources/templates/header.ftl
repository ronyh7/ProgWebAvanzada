<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title><@spring.message "equipos"/></title>

</head>
<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="#" class="navbar-brand"><@spring.message "bienvenido"/>!</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li><a href="/">Home</a></li>
                    <#if usuario.admin == true>
                        <li><a href="/usuario/"><@spring.message "usuarios"/></a></li>
                        <li><a href="/familia/"><@spring.message "familias"/></a></li>
                    </#if>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/factual/"><@spring.message "facturaAC"/></a></li>
                    <#if usuario.admin == true>
                        <li><a href="/factura/facturas"><@spring.message "facturas"/></a></li>
                    </#if>
                    <#if usuario.username == " ">
                        <li><a href="/login">Login</a></li>
                    <#else>
                        <li><a href="/logout"><@spring.message "cerrar_sesion"/></a></li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>

</body>