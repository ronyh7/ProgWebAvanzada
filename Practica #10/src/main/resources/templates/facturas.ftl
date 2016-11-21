<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <#include "header.ftl">
    <h1><@spring.message "facturaA"/></h1>

    <div class="col-md-4"></div>
    <div class="col-md-4">
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID:</th>
            <th><@spring.message "equipos"/>:</th>
            <th><@spring.message "cliente"/>:</th>
        </tr>
        </thead>
        <tbody>
        <#if facturasA?has_content>
            <#list facturasA as f>
            <tr>
                <td><a href="/factura/?id=${f.id}">${f.id}</a></td>
                <td>
                    <#list f.equiposAlquilados as a>

                        <ul>
                            <li>${a.equipo.nombre}</li>
                        </ul>

                    </#list>
                </td>
                <td>${f.cliente.username}</td>
            </tr>
            </#list>
        </#if>
        </tbody>
    </table>
    <h1><@spring.message "facturaP"/></h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID:</th>
            <th><@spring.message "equipos"/>:</th>
            <th><@spring.message "cliente"/>:</th>
        </tr>
        </thead>
        <tbody>
        <#if facturasP?has_content>
            <#list facturasP as f>
            <tr>
                <td>${f.id}</td>
                <td>
                    <#list f.equiposAlquilados as a>

                        <ul>
                            <li>${a.equipo.nombre}</li>
                        </ul>

                    </#list>
                </td>
                <td>${f.cliente.username}</td>
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