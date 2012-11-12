<%-- 
    Document   : login
    Created on : 03/10/2012, 18:02:38
    Author     : ASUS
--%>



<%@include file="header_limpo.jsp"%>


<div class="wrapper">
    <div class="container-login shadows bordering">
        <div class="box-left-login shadows bordering">
            <img src="images/Prodocs-login.png" alt=""/>
        </div>
        <div class="box-enter-login bordering">
            <div class="form-login">
            	<h2>Login</h2>            
                <form action="userLogin" method="post" name="login">
                    <table>
                        <tr>
                            <td><label>Nome de usuário</label></td>
                            <td class="text"><input type="text" name="userLogin.login" id="userLogin.login"/></td>
                        </tr>
                        <tr>
                            <td><label>Senha</label></td>
                            <td class="text"><input type="password" name="userLogin.senha" id="userLogin.senha"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="text">
                                <!--<input type="button" value="Entrar"/>
                                <input type="button" value="Esqueci minha senha"/>
                                <input type="button" value="Registrar"/>-->
                                <a class="btn-blue" onclick="document.login.submit();">Entrar</a>
                                <a class="btn-blue">Esqueci minha senha</a>
                                <a class="btn-blue" onclick="showRegister('reg')">Cadastre-se</a>
                            </td>
                        </tr>
                    </table>                   
                </form>
            </div>
            <div class="form-register">
            	<h2>Cadastro</h2>
                <form name="cadastroForm" action="cadastroUsuario">
                    <table>
                        <tr>
                            <td><label>Nome</label></td>
                            <td class="text"><input type="text" name="novoUsuario.nome"/></td>
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
                                <a class="btn-blue" onclick="showRegister('login')">Cancelar</a>
                            </td>
                        </tr>
                    </table>                   
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>