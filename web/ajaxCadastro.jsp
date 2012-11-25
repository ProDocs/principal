<%-- 
    Document   : cadastro
    Created on : 22/10/2012, 01:03:23
    Author     : discover
--%>
<%@taglib prefix="s" uri="/struts-tags"  %>
<%@taglib prefix="sj" uri="/struts2-jquery-tags" %>

  <div id="cadForm">
                <sj:form name="cadastroForm"  id="cadastroForm">
                    <table>
                        <tr>
                            <td><label>Grupo:</label></td>
                            <td class="text">
                                <s:fielderror fieldName="novoUsuario.idGrupo" cssStyle="color:sienna;font-size:9pt" />
                                <sj:select name="idGrupo" headerValue="Selecione o grupo" headerKey="0" list="grupos" listKey="idGrupo" listValue="nome"/>
                            </td>
                                
                        </tr>
                        <tr>
                            <td><label>Perfil de acesso:</label></td>
                            <td class="text">
                                <s:fielderror fieldName="novoUsuario.perfil" cssStyle="color:sienna;font-size:9pt" />
                                <sj:select id="perfis" name="perfil" headerValue="Selecione o perfil" headerKey="0" list="perfil={'Leitor','Editor','Gestor'}"/>
                            </td>
                            
                        </tr>
                        <tr>
                            <td><label>Nome</label></td>
                            <td class="text">
                                <s:fielderror fieldName="novoUsuario.nome" cssStyle="color:sienna;font-size:9pt"/>
                                <input type="text" name="novoUsuario.nome"/>
                            </td>
                        </tr>
			<tr>
                            <td><label>Sobrenome</label></td>
                            <td class="text">
                                <s:fielderror fieldName="novoUsuario.sobrenome" cssStyle="color:sienna;font-size:9pt"/>
                                <input type="text" name="novoUsuario.sobrenome"/>               
                            </td>
                        </tr>
			<tr>
                            <td><label>E-mail</label></td>
                            <td class="text">
                                <s:fielderror fieldName="novoUsuario.email" cssStyle="color:sienna;font-size:9pt"/>
                                <input type="text" name="novoUsuario.email"/>
                            </td>
                        </tr>
						<tr>
                            <td><label>Login</label></td>
                            <td class="text">
                                <s:fielderror fieldName="novoUsuario.login" cssStyle="color:sienna;font-size:9pt"/>
                                <input type="text" name="novoUsuario.login"/>
                            </td>
                        </tr>
			<tr>
                            <td><label>Senha</label></td>
                            <td class="text">
                                <s:fielderror fieldName="novoUsuario.senha" cssStyle="color:sienna;font-size:9pt"/>
                                <input type="password" name="novoUsuario.senha"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="text">
                                <sj:a cssClass="btn-blue" onClickTopics="exibeForm" onclick="removeParam(),addParam()" >Cadastrar</sj:a>
                                <a class="btn-blue" onclick="showRegister('login'),removeParam()">Cancelar</a>
                            </td>
                        </tr>
                        
                    </table> 
                </sj:form>
  </div>