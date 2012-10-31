<%-- 
    Document   : cadastro
    Created on : 22/10/2012, 01:03:23
    Author     : discover
--%>
<%@include file="header_limpo.jsp" %>

<div class="wrapper">
    <div class="container-login shadows bordering">
        <div class="box-top-register shadows bordering">
            <h2>Cadastro</h2>
        </div>
        <div class="box-register bordering">
            <div class="form-reg">
                <form>
                    <table>
                        <tr>
                            <td><label>Nome</label></td>
                            <td class="text"><input type="text"/></td>
                        </tr>
						<tr>
                            <td><label>Sobrenome</label></td>
                            <td class="text"><input type="text"/></td>
                        </tr>
						<tr>
                            <td><label>E-mail</label></td>
                            <td class="text"><input type="text"/></td>
                        </tr>
						<tr>
                            <td><label>Login</label></td>
                            <td class="text"><input type="text"/></td>
                        </tr>
						<tr>
                            <td><label>Senha</label></td>
                            <td class="text"><input type="password"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="text">
                                <a class="btn-blue" onclick="msnSuccess()">Cadastrar</a>
                            </td>
                        </tr>
                    </table>                   
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>