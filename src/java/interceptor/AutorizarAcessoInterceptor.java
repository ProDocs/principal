/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import model.Usuario;
import tipo.TipoSessionObjects;

/**
 *
 * @author Pablo
 */
public class AutorizarAcessoInterceptor implements Interceptor {

    public TipoSessionObjects objSession;
    
    @Override
    public void destroy() {
        
    }

    @Override
    public void init() {
        
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Usuario usuarioLogado = (Usuario) ai.getInvocationContext().getSession().get(objSession.USER_LOGADO.getDescricao());

        System.out.println("Pegando sessao user");
        if (usuarioLogado == null) {
            
            System.out.println("Retornando global result nao logado");
            return "naoLogado";
        } else {
             System.out.println("O nome do usuario é: "+usuarioLogado.getNome());
             System.out.println("Passou pelo interceptador");
             
             //String result = ai.getResultCode();
             System.out.println("O que vai retornar"+ai.invokeActionOnly());
             return ai.invokeActionOnly();
        }

    }
}
