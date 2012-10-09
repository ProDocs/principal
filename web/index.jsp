<%-- 
    Document   : index
    Created on : 14/03/2011, 22:14:25
    Author     : lab210
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

                <!-- Area do Topo -->
<%@include file="header.jsp"%>
                <!-- Rodape-->
<div class="wrapper">
    <div class="container-login shadows bordering">
        <div class="box-creation bordering">
        	
        </div>
        <div class="box-creation-options bordering shadows">
            <div class="action-opt">
                <ul>
                    <li class="btn-blue"><a href="busca.jsp">Pesquisar</a></li>
                    <li class="btn-blue">
                    	Criar
                    	<ul class="bordering shadows">
                        	<li><a href="criar_template.jsp">Templates</a></li>
                            <li><a href="criar_trecho.jsp">Trechos</a></li>
                            <li><a href="criar_documento.jsp">Documentos</a></li>
                            <li class="last"><a href="#">Minhas Tarefas</a></li>
                        </ul>
                    </li>
                    <li class="btn-blue">
                    	Aprovar
                    	<ul class="bordering shadows">
                        	<li><a href="#">Novos documentos</a></li>
                            <li><a href="#">Novos trechos</a></li>
                            <li class="last"><a href="#">Novos usuários</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
		</div>
    </div>
</div>
                <!-- Rodape-->
<%@include file="footer.jsp"%>
