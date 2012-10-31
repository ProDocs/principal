<%-- 
    Document   : login
    Created on : 03/10/2012, 18:02:38
    Author     : ASUS
--%>



<%@include file="header_limpo.jsp"%>
<div class="wrapper">
    <div class="container-login shadows bordering">
        <div class="box-left-login shadows bordering">
            <img src="images/imagem-front.jpg" alt=""/>
        </div>
        <div class="box-enter-login bordering">
            <div class="form-login">
                
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
                            <td class="">
                                <a class="btn-blue" name="fullName" onclick="document.login.submit();">Entrar</a>
                                <a class="btn-blue">Esqueci minha senha</a>
                                <a class="btn-blue" href="cadastro.jsp">Registrar</a>
                            </td>
                        </tr>
                        
                    </table>                   
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>