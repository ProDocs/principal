<%-- 
    Document   : login
    Created on : 03/10/2012, 18:02:38
    Author     : ASUS
--%>



<%@include file="header_limpo.jsp"%>
<%@taglib prefix="sj" uri="/struts2-jquery-tags" %>
<%@taglib  prefix="s" uri="/struts-tags" %>
<script>
    function addParam() {
                
                $("#param").attr("name","carregaForm");
                
            }
    function removeParam() {
                
                $("#param").removeAttr("name")
                
            }
</script>


<div class="wrapper">
    <div class="container-login shadows bordering">
        <div class="box-left-login shadows bordering">
            <img src="images/Prodocs-login.png" alt=""/>
        </div>
        <div class="box-enter-login bordering">
            <div class="form-login">
            	<h2>Login</h2>            
                <form action="ProDocs" method="post" name="login">
                    <table>
                        <tr>
                            <td><label>Login de usuário</label></td>
                            <td class="text"><input type="text" name="userLogin.login" id="userLogin.login"/>
                                <s:fielderror fieldName="userLogin.login"  cssStyle="color:sienna;font-size:9pt"/>
                            </td>
                            
                        </tr>
                        <tr>
                            <td><label>Senha</label></td>
                            <td class="text"><input type="password" name="userLogin.senha" id="userLogin.senha"/>
                                <s:fielderror fieldName="userLogin.senha" cssStyle="color:sienna;font-size:9pt"/>
                            </td>
                            
                        </tr>
                        <tr>
                            <td></td>
                            <td class="text">
                                
                                <a class="btn-blue" onclick="document.login.submit();">Entrar</a>
                                <a class="btn-blue">Esqueci minha senha</a>
                                <%--<a class="btn-blue" onclick="showRegister('reg')">Cadastre-se</a>--%>
                                <sj:a  id="botao" cssClass="btn-blue" onclick="showRegister('reg')" onClickTopics="exibeForm">Cadastre-se</sj:a>                             
                            </td>
                        </tr>
                    </table>                   
                </form>                             
            </div>
            <div class="form-register">
            	<h2>Cadastro</h2>
                <input style="display: none"  value="true" id="param"/>

                <sj:div id="cadastroPage" reloadTopics="exibeForm" src="cadastro" elementIds="param" formIds="cadastroForm"/>
                          
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>