<%-- 
    Document   : index
    Created on : 14/03/2011, 22:14:25
    Author     : lab210
--%>
<script type="text/javascript" src="script/functions.js"></script>
<script type="text/javascript" src="script/tag-it.js"></script>
<%@taglib prefix="sj" uri="/struts2-jquery-tags"%>
<%@taglib  prefix="s" uri="/struts-tags"%>
<div class="wrapper">
    <div class="container-login shadows bordering">
        <div class="box-creation bordering">
        	<div class="main-search s-home">
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
                        <td class="text">
                            <div class="tagbox bordering">
                                <form>
                                    <ul id="tagBoxElement"></ul>
                                    <input type="hidden" name="tags" id="submitField" disabled="true">
                                </form>                
                            </div>
                            <input type="text" style="display: none"/>
                        </td>
                    </tr>
  
		</table>
            </div>
        </div>
    </div>
</div>


