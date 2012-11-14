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
 * @author Jones
 **/

/* Valida se o usuario esta logado
 * Bloqueia acesso indevido do usuario sysadmin 
 */

public class RestringirAcessoSysInterceptor implements Interceptor {
  
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
        List<PerfilUsuarioGrupoDTO> gruposUsuario = (List<PerfilUsuarioGrupoDTO>) ai.getInvocationContext().getSession().get(TipoSessionObjects.USER_GROUPS.getDescricao());
        //Obtendo grupo selecionado
        int selectedGroup = (Integer) ai.getInvocationContext().getSession().get(TipoSessionObjects.SELECTED_GROUP.getDescricao());
        
        if(usuarioLogado != null){
            if(gruposUsuario.get(selectedGroup).getAprovado()){

                if (gruposUsuario.get(selectedGroup).getPerfil().equalsIgnoreCase(TipoPerfilUsuario.SYSADMIN.getDescricao())){
                    //restringe o acesso do Leitor ao painel de administração
                    System.out.println("Acesso negado");
                    return "negado";
                
                }
                else{
                    
                    System.out.println("Acesso autorizado");
                    return ai.invokeActionOnly();

                }
                    
            }
            else{
                System.out.println("Retornando global result pendente");
                return "pendente";
            
            }
        
        }
        else{
        
            return "naoLogado";
        
        }
        

    }
}
