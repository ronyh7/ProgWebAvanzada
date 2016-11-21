<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <#include "header.ftl">
    <h1><@spring.message "familias"/></h1>
    <div class="container">

        <h1><@spring.message "nueva_familia"/></h1>
        <form action="/familia/crearFamilia" th:object="${familia}" method="POST" >
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <label><@spring.message "familia"/>:</label> <input name="nombre" type="text"></>
        <button name="Insertar" id="insertar" type="submit"><@spring.message "nueva_familia"/></button>
        </form>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th><@spring.message "familia"/></th>
        </tr>
        </thead>
        <tbody>
        <#if familias?has_content>
            <#list familias as f>
            <tr>
                <td>${f.id}</td>
                <td><a href="/familia/subFamilia?id=${f.id}">${f.nombre}</a></td>
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