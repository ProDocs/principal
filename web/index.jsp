<%-- 
    Document   : index
    Created on : 14/03/2011, 22:14:25
    Author     : lab210
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="sj" uri="/struts2-jquery-tags" %>

<!-- Area do Topo -->
<%@include file="header.jsp"%>


<div class="wrapper">
    <div class="container-login shadows bordering">
       <!-- <div class="box-creation bordering">
        	
        </div>-->
        
        <div class="box-creation-options bordering shadows">
            <div class="action-opt">
                <ul>
                    <li class="btn-blue"><a href="busca">Pesquisar</a></li>
                    <li class="btn-blue">
                    	Criar
                    	<ul class="bordering shadows">
                        	<li><a href="modelo">Modelos</a></li>
                            <li><a href="trecho">Trechos</a></li>
                            <li><a href="documento">Documentos</a></li>
                            <li class="last"><a href="#">Minhas Tarefas</a></li>
                        </ul>
                    </li>
                    <li class="btn-blue">
                    	Aprovar
                    	<ul class="bordering shadows">
                        	<li><a href="lista_aprov_doc.jsp">Novos documentos</a></li>
                            <li><a href="lista_aprov_tre.jsp">Novos trechos</a></li>
                            <li class="last"><a href="lista_usr.jsp">Novos usuários</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
		</div>
    </div>
</div>
<!-- Rodape-->
<%@include file="footer.jsp"%>
