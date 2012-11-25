/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import model.dto.PerfilUsuarioGrupoDTO;
import tipo.TipoPerfilUsuario;
import tipo.TipoSessionObjects;

/**
 *
 * @author discover
 */
public class PainelAdministracaoAction extends ActionSupport{
    
    private int selectedGroup;
    private Usuario userLogado;

    public int getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(int selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public Usuario getUserLogado() {
        return userLogado;
    }

    public void setUserLogado(Usuario userLogado) {
        this.userLogado = userLogado;
    }
    
    @Override
    public String execute() throws Exception {

        //Captura usuario logado
        userLogado = (Usuario) ActionContext.getContext().getSession().get(TipoSessionObjects.USER_LOGADO.getDescricao());
        
        //Captura grupos do usuario Logado
        List<PerfilUsuarioGrupoDTO> gruposUsuario = (List<PerfilUsuarioGrupoDTO>) ActionContext.getContext().getSession().get(TipoSessionObjects.USER_GROUPS.getDescricao());

        //Obtem grupo selecionado
        selectedGroup = (Integer) ActionContext.getContext().getSession().get(TipoSessionObjects.SELECTED_GROUP.getDescricao());
        
        //Verifica perfil do usuario
        for(PerfilUsuarioGrupoDTO perfilGrupo : gruposUsuario){
            if(perfilGrupo.getIdGrupo() == selectedGroup){
                if(perfilGrupo.getPerfil().equalsIgnoreCase(TipoPerfilUsuario.EDITOR.getDescricao())){
                
                    return TipoPerfilUsuario.EDITOR.getDescricao();
                    
                }
                else if(perfilGrupo.getPerfil().equalsIgnoreCase(TipoPerfilUsuario.GESTOR.getDescricao())){
                
                    return TipoPerfilUsuario.GESTOR.getDescricao();
                    
                }
                
            return "negado";
            
            }
        
        }
        return "negado";
    }
    
    
}
