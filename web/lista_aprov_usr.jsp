<%-- 
    Document   : lista_aprov_doc
    Created on : 03/10/2012, 18:00:07
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%  Usuario userLogado = new Usuario();
    userLogado.setNome("Usuario");
        userLogado = (Usuario)ActionContext.getContext().getSession().get("SESSION_USER");%>
        
        
<div class="wrapper">
    <%out.println(userLogado.getNome());%>
        <div class="scroll">
            <div class="box-main-list" id="accordion">
            	<h3><a href="#">Hoje</a></h3>
            	<ul class="approve-list">
                	<li id="p1">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
                    <li id="p2">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
                    <li id="p3">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
				</ul>
            	<h3><a href="#">11/11/11</a></h3>
            	<ul class="approve-list">
                    <li id="p4">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
                   	<li id="p5">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
                    <li id="p6">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
                    <li id="p7">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
                    <li id="p8">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
					<li id="p9">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
					<li id="p10">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
					<li id="p11">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
                </ul>
                <h3><a href="#">10/11/11</a></h3>
            	<ul class="approve-list">
                	<li id="p1">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
                    <li id="p2">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
                    <li id="p3">
                    	<div class="time">00:00</div>
                    	<h4>Yori Yagami</h4>
                        <p>Solicitou acesso ao ProDocs</p>
                        <div class="action-buttons">
                            <a href="#" class="btn-blue">Aprovar</a>
                            <a href="#" class="btn-blue modal">Rejeitar</a>
                        </div>
                    </li>
				</ul>
            </div>
        </div>
        
        <div id="preview">
        	<div class="close-preview">Close</div>
        </div>
   
</div>

<%@include file="footer.jsp" %>