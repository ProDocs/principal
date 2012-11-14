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
import tipo.TipoSessionObjects;

/**
 * @author Jones
 **/

/*
 * Interceptor utilizado para chamada dos links
 * Valida se o usuário esta logado
 * Valida se o usuario esta com o perfil aprovado para o grupo da sessão
 * 
 */

public class AutorizarAcessoInterceptor implements Interceptor {

    @Override
    public void destroy() {
        
    }

    @Override
    public void init() {
        
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        
        //Obtem Usuario Logado
        Usuario usuarioLogado = (Usuario) ai.getInvocationContext().getSession().get(TipoSessionObjects.USER_LOGADO.getDescricao());
        //Obtem Lista de Grupos do Usuario
        List<PerfilUsuarioGrupoDTO> perfilUsuario = (List<PerfilUsuarioGrupoDTO>) ai.getInvocationContext().getSession().get(TipoSessionObjects.USER_GROUPS.getDescricao());
        //Obtendo grupo selecionado
        int selectedGroup = (Integer) ai.getInvocationContext().getSession().get(TipoSessionObjects.SELECTED_GROUP.getDescricao());
        
        
        if(usuarioLogado != null){
            if(perfilUsuario.get(selectedGroup).getAprovado()){

                    return ai.invokeActionOnly();

            }
            else{
                System.out.println("Retornando global result pendente");
                return "pendente";
            
            }
        
        }
        
        System.out.println("Retornando global result nao logado");
        return "naoLogado";
        
       

    }
}
