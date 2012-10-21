<%-- 
    Document   : busca_trecho
    Created on : 04/10/2012, 01:49:19
    Author     : discover
--%>
<%@taglib prefix="s" uri="/struts-tags" %>




     <div class="formsearch">
         <form action="BuscaAction">    
            <input class="txtsearch" type="text" >
            <input class="button-seach" type="image" src="View/images/1343703624_24.png" value="">
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
                </ul>
            </s:iterator>
        </div>   

          

