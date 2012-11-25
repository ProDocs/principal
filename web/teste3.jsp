<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Prodocs</title>
</head>
<body>
<script type="text/javascript" src="script/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="script/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="script/jquery.mCustomScrollbar.min.js"></script>
<script type="text/javascript" src="script/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="script/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="script/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="script/tag-it.js"></script>
<script type="text/javascript" src="script/functions.js"></script>

<!-- HEADER -->
<div class="header">
    <div class="info">
	 <!-- <h2>Seja bem-vindo, <b>${sessionScope.login.login}</b>&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout">Logout</a></h2> -->
     <h2>Seja bem-vindo, <span>Yori Yagami</span></h2>
     <a class="user" href="#" title="Perfil">User</a>
     <a class="home" href="home.html" title="Home">Home</a>
     <a class="logout" href="login.html" title="Sair">Logout</a>
    </div>
</div>

--%>
<%@include file="header.jsp" %>
     
<!-- WRAPPER -->

<div class="wrapper">
	

    <!--<div class="scroll">-->
        <div class="box-main-doc">
              <!-- Iteração -->
              <div class="editor-container shadows">
                     <center>  <sj:div id="editDoc" name="editDoc" reloadTopics="loadEditor" src="editor" onSuccessTopics="remoteDivLoaded"/></center>
              </div>
        </div>
    <!--</div>-->
  
    <div class="sidebar shadows"> 
    
        <%--   <div class="sub-header"> --%>
            <div class="doc-manager">
            <a title="Salvar" href="#save" class="btn-blue option-save">Salvar</a>

            <%--Modal salvar documento--%>
                <div style="display: none;">
                    <div id="save" class="highlight-fancy opt-save">
                        <h4>Salvando...</h4>
                        <div class="highlight-fancy-content">
                                <br/>
                                <p>Insira o nome deste documento:</p>
                                <br/>
                                <input type="text"/>
                        </div>
                        <div class="highlight-btn">
                            <a class="btn-blue" href="#">Salvar</a>
                            <a class="btn-blue" href="#">Cancelar</a>
                        </div>
                    </div>
                </div>
            <%--Modal salvar documento--%>

            </div>
            <%--   </div> --%>
    
    

           <div class="tag-container">
                <h4 class="tag-align">Adicione as tags para busca</h4>
                    <div class="tagbox bordering">
                	<form name="tags">
                            <%--Adicionar tagging jquery--%>
                            <input  name="tags" id="submitField" disabled="true"/>
                        </form>                
                    </div>
                <a class="btn-blue tag-align" onclick="document.tag.submit();">Enviar para aprovação</a>
           </div>
        

        
        <!--<div class="formsearch">
        	<form>
            	<input type="text" placeholder="Inserir tags" class="txtsearch"/>
                <input type="image" value="" class="button-seach" src="images/1343703624_24.png"/>
            </form>
        </div>-->

    </div>
</div>

<%@include file="footer.jsp" %>

