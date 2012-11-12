/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.List;
import model.Usuario;
import model.dto.PerfilUsuarioGrupoDTO;
import tipo.TipoPerfilUsuario;
import tipo.TipoSessionObjects;

/**
 *
 * @author Pablo
 */
public class AutorizarAcessoInterceptor implements Interceptor {

    private TipoSessionObjects objSession;
    private TipoPerfilUsuario tipoPerfil;
    
    @Override
    public void destroy() {
        
    }

    @Override
    public void init() {
        
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Usuario usuarioLogado = (Usuario) ai.getInvocationContext().getSession().get(objSession.USER_LOGADO.getDescricao());
        List<PerfilUsuarioGrupoDTO> perfilUsuario = (List<PerfilUsuarioGrupoDTO>) ai.getInvocationContext().getSession().get(objSession.USER_GROUPS.getDescricao());
        System.out.println("Pegando sessao user");
        if (usuarioLogado == null) {
            
            System.out.println("Retornando global result nao logado");
            return "naoLogado";
        } 
        else if(perfilUsuario.get(0).getPerfil().equalsIgnoreCase(tipoPerfil.SYSADMIN.getDescricao())){
            
            System.out.println("Retornando global result sysadmin bad request");
            return "negado";
        
        }
        
        else {
             System.out.println("O nome do usuario é: "+usuarioLogado.getNome());
             System.out.println("Passou pelo interceptador");
             
             System.out.println("O que vai retornar "+ai.invokeActionOnly());
             return ai.invokeActionOnly();
        }

    }
}
