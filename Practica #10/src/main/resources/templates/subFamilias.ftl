<!DOCTYPE html>
<html>
<head>
<title>Insertar</title>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/insertar.css" rel="stylesheet" >
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
    <#include "header.ftl">
    <div class="container">
        <div class="col-md-3">
            <h1>Familia</h1>
            <pre>
            ${familia.nombre}
            </pre>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Sub Familias</th>
                    </tr>
                </thead>
                <tbody>
                <#if subFamilias?has_content>
                    <#list subFamilias as s>
                        <tr>
                            <td>${s.id}</td>
                            <td>${s.nombre}</td>
                        </tr>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>
        <div class="col-md-4">

            <form action="/familia/crearSubFamilia" th:object="${subFamilia}" method="post" >
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <label>Agregar Sub Familia:</label> <input name="nombre" type="text"/>
                <input type="hidden" name="fID" value="${familia.id}">

                <button name="Insertar" id="insertar" type="submit">Enviar</button>
            </form>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>