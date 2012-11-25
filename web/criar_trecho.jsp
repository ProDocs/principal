<%-- 
    Document   : criar_trecho
    Created on : 04/10/2012, 01:54:03
    Author     : discover
--%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@taglib  prefix="sj" uri="/struts2-jquery-tags" %>

    <link rel="shortcut icon" href="favicon.ico"/>
    <link rel="StyleSheet" href="tagging/css/ui-lightness/jquery-ui-1.8.6.custom.css" type="text/css" media="all"/>
    <link rel="StyleSheet" href="tagging/css/jquery.tagedit.css" type="text/css" media="all"/>
    <script type="text/javascript" src="tagging/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="tagging/js/jquery-ui-1.8.6.custom.min.js"></script>
    <script type="text/javascript" src="tagging/js/jquery.autoGrowInput.js"></script>
    <script type="text/javascript" src="tagging/js/jquery.tagedit.js"></script>
    <script type="text/javascript">
	$(function() {	
		
		
		// Custom Break Characters
		$('#custom-break input.tag').tagedit({
			//autocompleteURL: 'server/autocomplete.php',
			// return, comma, space, period, semicolon
			breakKeyCodes: [ 13, 44, 32, 46, 59 ],
                        allowEdit: false
		});

		
	});
    </script>


<div class="wrapper">

	<!--<div class="scroll">-->
        <div class="box-main-doc">
        		<!-- Iteração -->
         		<div class="editor-container shadows">
                            <center>  <sj:div id="editDoc" name="editDoc" reloadTopics="loadEditor" src="editor" onSuccessTopics="remoteDivLoaded"/><center>
			</div>

        </div>
    <!--</div>-->
    <div class="sidebar shadows">
        
            <div class="doc-manager">
                <a title="Salvar" href="javascript:;" class="btn-blue option-save">Salvar</a>
           

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
                 <p>
                     
                     
                     
                     
                     Digite o nome do trecho: &nbsp; <input type="text" style="width: 200px"/>
                </p>


           <div class="tag-container">
                <h4 class="tag-align">Adicione as tags para busca</h4>
                    <div class="tagbox bordering">
                        <form id="custom-break">
                               <input type="text" name="tag[]" value="" id="submitField"  class="tag"/>
                        </form>              
                    </div>
                <a class="btn-blue tag-align" onclick="document.tag.submit();">Enviar para aprovação</a>
           </div>
    </div>
</div>