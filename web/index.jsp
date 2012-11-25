<%-- 
    Document   : index
    Created on : 14/03/2011, 22:14:25
    Author     : lab210
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="sj" uri="/struts2-jquery-tags" %>
<!-- Area do Topo -->
<%@include file="header.jsp"%>

<!-- campo oculto -->
<sj:select id="pagina" value="index" name="pagina" list="{'index','painel','busca','modelo','trecho','documento'}" cssStyle="display:none" />
<!-- campo oculto -->
<sj:div id="homePage" reloadTopics="displayPage" src="display" elementIds="selectedGroup,pagina" loadingText="Carregando..." onSuccessTopics="remoteDivLoaded"/>


<!-- Rodape -->
<%@include file="footer.jsp"%>
