<!DOCTYPE html>
<html x lang="en">

<head>
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">

</head>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
    body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>

<body class="w3-light-grey">
<#include "header.ftl">
IMAGEN: ${usuario.imagen}


<!-- w3-content defines a container for fixed size centered content,
and is wrapped around the whole page content, except for the footer in this example -->
<div class="w3-content" style="max-width:1400px">

    <!-- Header -->
    <header class="w3-container w3-center w3-padding-32">
        <h1><b><@spring.message "equipos"/></b></h1>
    </header>

    <!-- Grid -->
    <div class="w3-row">

        <!-- Blog entries -->
        <div class="w3-col l8 s12">
            <#if equipos?has_content>
                <!-- Blog entry -->
                <#list equipos as e>
                    <div class="w3-card-4 w3-margin w3-white">
                        <div class="w3-container w3-padding-8">
                            <h3><b>${e.nombre}</b></h3>

                        </div>

                        <div class="w3-container">
                            <p>${e.descripcion}</p>
                            <div class="w3-row">
                                <h4><@spring.message "cantidad"/> ${e.cantidad}</h4>
                                <form action="/alquiler?equipo=${e.id}" method="post">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <div class="w3-col m8 s12">
                                        <h5><@spring.message "costo"/>:<b>${e.cobroDia}</b></h5>
                                    <p><button class="w3-btn w3-padding-large w3-white w3-border w3-hover-border-black"><b><@spring.message "rentar"/></b></button></p>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </#list>
            </#if>
        </div>

        <!-- Introduction menu -->
        <div class="w3-col l4">
            <!-- About Card -->
            <div class="w3-card-2 w3-margin w3-margin-top">
                    <img src="/archivos/${usuario.imagen}" style="width:100%">


                <div class="w3-container w3-white">
                    <h4><@spring.message "nombre_usuario"/>: <b>${usuario.username}</b></h4>
                </div>
            </div><hr>

            <hr>

            <!-- END Introduction Menu -->
        </div>

        <!-- END GRID -->
    </div><br>

    <!-- END w3-content -->
</div>

<!-- Footer -->
<footer class="w3-container w3-dark-grey w3-padding-32 w3-margin-top">
    <button class="w3-btn w3-disabled w3-padding-large w3-margin-bottom">Previous</button>
    <button class="w3-btn w3-padding-large w3-margin-bottom">Next »</button>
</footer>





<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/webjars/jquery/3.1.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>

</html>