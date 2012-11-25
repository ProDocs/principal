<%-- 
    Document   : ajaxComboCategoriasBusca
    Created on : 14/11/2012, 11:06:38
    Author     : discover
--%>

<%@taglib  prefix="s" uri="/struts-tags" %>
<%@taglib  prefix="sj" uri="/struts2-jquery-tags" %>


<sj:select name="filtro.categoria" id="selectCategoria"  list="categoriasGrupo"  listKey="idCategoria" listValue="nome" selectBox="true"  value="0"/>
