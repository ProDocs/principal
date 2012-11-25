<%-- 
    Document   : index
    Created on : 14/03/2011, 22:14:25
    Author     : lab210
--%>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags" %>
<%@taglib  prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="script/functions.js"></script>
<script>
    
    function editorOFF(){
        tinyMCE.execCommand('mceRemoveControl', true, "elm1");
        
    }
    function editorON(){
        
        tinyMCE.execCommand('mceAddControl', false, "elm1");
    }
    
</script>


<div class="wrapper">
    <div class="container-login shadows bordering">
        <div class="box-creation bordering">
            <div class="main-search s-home" style="display: none">
                <input type="text" value="" placeholder="Pesquise o documento que você precisa..." style="height:45"/>
                <a class="btn-blue">Pesquisar</a>
            </div>
            <div class="adv-option">
            	<a href="javascript:;">Pesquisa avançada</a>
            </div>
            <div class="adv-search">
            	<table>
                    <tr>
			<td><label>Tipo</label></td>
			<td class="text">
                        	<select onchange="showInputTag()" id="select-trecho">
                            	<option value="0">-- Selecione --</option>
                                <option value="Documento">Documento</option>
                                <option value="Trecho">Trecho</option>
                            </select>
                        </td>
                        <td><label class="right">Categoria</label></td>
                        <td class="text">
                            <sj:div id="comboCategorias" reloadTopics="displayCategorias" src="categorias" loadingText="Carregando categorias..."/>
                        </td>
                    </tr>
		
                    <tr id="tag-trecho">
                        <td><label>Tags</label></td>
                        <td>
                             <div class="tag-container">
                                <h4 class="tag-align">Item Loren Ipsum</h4>
                                <div class="tagbox bordering">
                                        <form>
                                        <ul id="tagBoxElement"></ul>
                                        <input type="hidden" name="tags" id="submitField" disabled="true">
                                    </form>                
                                </div>
                                <a class="btn-blue tag-align" href="#">Salvar</a>
                            </div>
                        </td>
                        <td class="text"><input type="text"/></td>
                    </tr>
  
		</table>
            </div>
        </div>
        <div class="box-creation-options bordering shadows">
            <div class="action-opt">
                <ul>
                    <li>
                    	<a href="#" class="btn-blue">Criar</a>
                    	<ul class="bordering shadows">
                            <li><sj:a href="javascript:;" onclick="modelo();" onClickTopics="displayPage">Templates</sj:a></li>
                            <li><sj:a href="javascript:;"onclick="trecho();" onClickTopics="displayPage">Trechos</sj:a></li>
                            <li><sj:a href="javascript:;" onclick="editorOFF(),documento();" onClickTopics="displayPage">Documentos</sj:a></li>
                        </ul>
                    </li>
                    <li><sj:a cssClass="btn-blue" onclick="painel();" onClickTopics="displayPage">Minhas Tarefas</sj:a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

