<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<script src="/webjars/jquery/3.1.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <#include "header.ftl">
    <script type="text/javascript">
        $( document ).ready(function() {
            $('.fecha2').val($('#fecha').val());
            console.log($('#fecha').val());
            $('#fecha').on('change', function() {
                $('.fecha2').val(this.value);
                console.log("ALGO")
            });

        });
    </script>
    <h1><@spring.message "factura"/></h1>

    <div class="col-md-4"></div>
    <div class="col-md-4">

        <h1><@spring.message "fecha_devolucion"/></h1>


        <form name="form1" action="/factura/devolver" method="get" >
            <input type="hidden" name="id" value="0"/>
            <input type="hidden" name="fid" value="${factura.id}">
            <label><@spring.message "fecha"/>:</label> <input name="fecha" id="fecha" type="date" required="true"/>
        <button name="Insertar" type="submit"><@spring.message "devolver_equipos"/></button>
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

                <td>${factura.id}</td>
                <td>${a.equipo.nombre}</td>
                <form name="form2" action="/factura/devolver" method="get" >
                    <input type="hidden" name="id" value="${a.id}"/>
                    <input type="hidden" name="fid" value="${factura.id}"/>
                    <input type="hidden" class="fecha2" name="fecha" value=""/>
                    <td><button name="Devolver" type="submit" ONCLICK="checkForm(${a.id})"><@spring.message "devolver"/></button></td>
                </form>
            </tr>

            </#list>
        </#if>
        </tbody>
    </table>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

    <!--<script src="/js/factura.js"></script>!-->

</body>

</html>