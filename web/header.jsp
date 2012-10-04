<%-- 
    Document   : header
    Created on : 02/10/2012, 20:57:01
    Author     : discover
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="View/css/style.css" type="text/css" media="screen"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="View/script/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="View/script/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="View/script/jquery.mCustomScrollbar.min.js"></script>
<script type="text/javascript" src="View/script/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="View/script/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="View/script/functions.js"></script>


<!-- HEADER -->
<div class="header">
    <div class="info">
     <h2>Seja bem-vindo, <b>${sessionScope.login.login}</b>&nbsp;&nbsp;&nbsp;&nbsp;<a class="logout" href="logout">Logout</a>
     <!--<h2>Seja bem-vindo, <span>Yori Yagami</span></h2>-->
    </div>
</div>
<body>




