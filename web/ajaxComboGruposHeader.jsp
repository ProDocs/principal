<%-- 
    Document   : ajaxComboGruposHeader
    Created on : 14/11/2012, 11:06:38
    Author     : discover
--%>

<%@taglib  prefix="s" uri="/struts-tags" %>
<%@taglib  prefix="sj" uri="/struts2-jquery-tags" %>


<sj:select name="changeGroup" id="selectedGroup"  list="gruposUsuario"  listKey="idGrupo" listValue="nome" selectBox="true" value="%{selectedGroup}" onclick="index();" onChangeTopics="displayPage" />
