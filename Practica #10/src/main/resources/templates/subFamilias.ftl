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

            <h1><@spring.message "familias"/>: ${familia.nombre}</h1>
            <form action="/familia/crearSubFamilia" th:object="${subFamilia}" method="post" >
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <label><@spring.message "nueva_subfamilia"/>:</label> <input name="nombre" type="text" required="true"/>
                <input type="hidden" name="fID" value="${familia.id}">

                <button name="Insertar" id="insertar" type="submit"><@spring.message "confirmacion"/></button>
            </form>

            <a href="/equipo/crearEquipo?fid=${familia.id}" class="btn btn-default" role="button">Agregar Equipo</a>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th><@spring.message "sub_familia"/></th>
                    <th><@spring.message "equipos"/></th>
                </tr>
                </thead>
                <tbody>
                <#if subFamilias?has_content>
                    <#list subFamilias as s>
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.nombre}</td>
                        <td>
                            <#if s.equipos?has_content>
                                <#list s.equipos as e>

                                    <ul>
                                        <li>${e.nombre}</li>
                                    </ul>

                                </#list>
                            </#if>
                        </td>
                    </tr>
                    </#list>
                </#if>
                </tbody>
            </table>

    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>