<%-- 
    Document   : header
    Created on : 02/10/2012, 20:57:01
    Author     : discover
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@taglib  prefix="sj" uri="/struts2-jquery-tags" %>
<!DOCTYPE html>
<html>
<head>
<sj:head compressed="false"/>
<sj:head jqueryui="true"/>
<title>::ProDocs::</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="script/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="script/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="script/jquery.mCustomScrollbar.min.js"></script>
<script type="text/javascript" src="script/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="script/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="script/functions.js"></script>

</head>
<!-- HEADER -->
<body>
<form name="groupForm" action="grupo">   
    
    <div class="header">
    <div class="box-logo-top">
    	<a href="index">Prodocs</a>
    </div>
        <div class="info">
        <h2>Seja bem-vindo, ${userLogado.nome}</h2>
        <div class="category">
     	<label>Grupo: </label>
            <select size="1" name="changeGroup" onchange="groupForm.submit();  ">
               <s:iterator value="gruposUsuario" status="stat" >
                   <s:if test="#stat.index == selectedGroup">
                       <option selected value="<s:property value="#stat.index"/>">${nome}</option>  
                   </s:if>
                   <s:else>
                       <option value="<s:property value="#stat.index"/>">${nome}</option>
                   </s:else>
               </s:iterator>
            </select>    
        </div>
            <a class="user" href="#" title="Perfil">User</a>
            <a class="home" href="index" title="Home">Home</a>
            <a class="logout" href="userLogout" title="Sair">Logout</a>
        </div>
    </div>
</form>




