<%-- 
    Document   : param_trecho
    Created on : 04/10/2012, 01:50:59
    Author     : discover
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

          
                
         <%--           
         <table>
             <tr>
                <td>
                    <sj:a href="javascript:;" onClickTopics="testeAjax">Atualizar</sj:a>
               </td>
            </tr>
            <tr>
                <td>
                    <sj:div reloadTopics="testeAjax" formIds="custom-break"  src="incluir"/>
               </td>
            </tr>
        </table>
         --%>
         
<div class="sidebar shadows">
     <div class="formsearch">
         <form action="BuscaAction">    
            <input class="txtsearch" type="text" >
            <input class="button-seach" type="image" src="images/1343703624_24.png" value="">
         </form>
     </div>
                <s:if test="%{produtos.isEmpty}">
                   <br />
                   <h3>Nenhum trecho foi encontrado!</h3>
                </s:if>
                   
                   
                   
        <div class="resultsearch" id="mcs_container">
            <s:iterator value="artefatos" status="stat">
        	<ul id="sortable" class="result-list">
                    <li>
                        <h4>${titulo}</h4>
                        <p>${conteudo}</p>
                    </li>
                    <li>
                        <h4>teste</h4>
                        <p>resultado da busca</p>
                    </li>
                    <li>
                        <h4>teste</h4>
                        <p>resultado da busca</p>
                    </li>
                </ul>
            </s:iterator>
        </div>   
</div>
         
         
         
         
         
         
         
         
         
         
         
<div class="sidebar shadows">
         
         <div class="tag-container">
		<form name="tag" id="custom-break">
                      <h4 class="tag-align">Insira as Tags</h4>
                            <div class="tagbox bordering">
                                <input type="text" name="tag[]" value="" class="tag"/>
                            </div>
                            <a class="btn-blue tag-align" onclick="document.tag.submit();">Salvar</a>
		</form>
                
        </div>     
</div>

       

