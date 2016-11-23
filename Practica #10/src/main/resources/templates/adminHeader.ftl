<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/nav.css" rel="stylesheet">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>BLOG</title>

</head>
<body>
<div id="sidebar-wrapper">
    <ul class="sidebar-nav">
        <li class="sidebar-brand">
            <a href="/graficos">
                <@spring.message "graficos"/>
            </a>
        </li>
        <li>
            <a href="/factura/alquileres?nombre=0">
                <@spring.message "alquileres_pendientes"/>
            </a>
        </li>
        <li>
            <a href="#">Shortcuts</a>
        </li>
        <li>
            <a href="#">Overview</a>
        </li>
        <li>
            <a href="#">Events</a>
        </li>
        <li>
            <a href="#">About</a>
        </li>
        <li>
            <a href="#">Services</a>
        </li>
        <li>
            <a href="#">Contact</a>
        </li>
    </ul>
</div>

</body>