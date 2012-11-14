<%-- 
    Document   : teste
    Created on : 04/11/2012, 13:12:00
    Author     : discover
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp"  %>
    
            First Select: <sj:select id="tipoMensagem" list="{'incluir','1','2'}" name="tipoMensagem" onChangeTopics="tipoMensagemChanged"/><br>
            Display Result:<br> <sj:div id="secondSelect" reloadTopics="tipoMensagemChanged" src="incluir" elementIds="tipoMensagem"/><br>
            Grupos: <sj:select id="tipoMensagem" list="{'incluir','1','2'}" name="tipoMensagem" onChangeTopics="tipoMensagemChanged"/>
            <s:url id="gruposList" action="listarGrupos"/>
            <sj:select name="idGrupo" href="%{gruposList}" list="grupos" listKey="idGrupo" listValue="nome" selectBox="true"/>

<%@include file="footer.jsp"%>