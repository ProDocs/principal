<%-- 
    Document   : cadastro
    Created on : 22/10/2012, 01:03:23
    Author     : discover
--%>
<%@include file="header_limpo.jsp" %>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="wrapper">
    <div class="container-login shadows bordering">
        <div class="box-top-register shadows bordering">
            <center>  <h2>Cadastro</h2> </center>
        </div>
        <div class="box-register bordering">
            <div class="form-reg">
                <form name="cadastroForm" action="cadastroUsuario">
                    <table>
                        <tr>
                            <td><label>Grupo:</label></td>
                            <td class="text">
                                <select size="1" name="idGrupo">
                                    <option selected value="">Selecione o grupo</option>
                                       <s:iterator value="todosGrupos" status="stat" >
                                           <s:if test="#stat.index == 0"/>                                            
                                           <s:else>
                                               <option value="<s:property value="todosGrupos[#stat.index].idGrupo"/>">${nome}</option>
                                           </s:else>
                                       </s:iterator>
                                </select>
                            </td>
                            <s:fielderror fieldName="user.user" />
                        </tr>
                        <tr>
                            <td><label>Perfil de acesso:</label></td>
                            <td class="text">
                                <select size="1" name="perfil">
                                    <option selected value="">Selecione o perfil</option>   
                                      <s:iterator value="perfisUsuario" status="stat" >  
                                            <s:if test="#stat.index == 0"/>                                            
                                            <s:else>
                                               <option value="<s:property value="perfisUsuario[#stat.index]"/>"><s:property value="perfisUsuario[#stat.index]"/></option>
                                            </s:else>
                                      </s:iterator>
                                </select>
                            </td>
                            <s:fielderror fieldName="user.user" />
                        </tr>
                        <tr>
                            <td><label>Nome</label></td>
                            <td class="text"><input type="text" name="novoUsuario.nome"/>
                            <s:fielderror fieldName="novoUsuario.nome" /></td>
                        </tr>
			<tr>
                            <td><label>Sobrenome</label></td>
                            <td class="text"><input type="text" name="novoUsuario.sobrenome"/></td>
                        </tr>
			<tr>
                            <td><label>E-mail</label></td>
                            <td class="text"><input type="text" name="novoUsuario.email"/></td>
                        </tr>
						<tr>
                            <td><label>Login</label></td>
                            <td class="text"><input type="text" name="novoUsuario.login"/></td>
                        </tr>
			<tr>
                            <td><label>Senha</label></td>
                            <td class="text"><input type="password" name="novoUsuario.senha"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="text">
                                <a class="btn-blue" onclick="cadastroForm.submit();">Cadastrar</a>
                            </td>
                        </tr>
                    </table>                   
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>