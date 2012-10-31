<%-- 
    Document   : header
    Created on : 02/10/2012, 20:57:01
    Author     : discover
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="script/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="script/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="script/jquery.mCustomScrollbar.min.js"></script>
<script type="text/javascript" src="script/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="script/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="script/functions.js"></script>


<!-- HEADER -->
<body>
<div class="header">
    <div class="info">
        &nbsp;
        <b>Grupo :</b>
      
     <select size="1" name="comboGrupos">
       <s:iterator value="gruposUsuario" status="stat" >
           <s:if test="nome.equals(selectedGroup)">
               <option selected value="<s:property value="gruposUsuario[#stat.index].idGrupo"/>">${nome}</option>
           </s:if>
           <s:else>
               <option value="<s:property value="gruposUsuario[#stat.index].idGrupo"/>">${nome}</option>
           </s:else>
       </s:iterator>
     </select>
        
     <h2>Seja bem-vindo, <b>${userLogado.nome}</b>&nbsp;&nbsp;&nbsp;&nbsp;</h2> 
     <a class="user" href="#">User</a>
     <a title="asdfasdf" class="home" href="index">Home</a>
     <a class="logout" href="userLogout">Logout</a>&nbsp;&nbsp;
    </div>
</div>



