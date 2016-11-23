<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <#include "header.ftl">
    <h1><@spring.message "alquileres"/></h1>
    <div class="container">

        <h1><@spring.message "alquileres_pendientes"/></h1>
        <form action="/factura/alquileres" method="POST" >
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <label><@spring.message "cliente"/>:</label> <input name="nombre" type="text" required="true"></>
        <button name="Insertar" id="insertar" type="submit"><@spring.message "alquileres"/></button>
        </form>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th><@spring.message "equipos"/>:</th>
        </tr>
        </thead>
        <tbody>
        <#if alquiler?has_content>
            <#list alquiler as a>
            <tr>
                <td><a href="/factura/?id=${a.factura.id}">${a.factura.id}</a></td>
                <td>${a.equipo.nombre}</td>
            </tr>

            </#list>
        </#if>
        </tbody>
    </table>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/webjars/jquery/3.1.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>

</html>