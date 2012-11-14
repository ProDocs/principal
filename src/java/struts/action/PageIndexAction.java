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
public class PageIndexAction extends ActionSupport{
    
    private int selectedGroup;
    private Usuario userLogado;
    private List<PerfilUsuarioGrupoDTO> gruposUsuario = new ArrayList<PerfilUsuarioGrupoDTO>();
    
     public int getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(int selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public List<PerfilUsuarioGrupoDTO> getGruposUsuario() {
        return gruposUsuario;
    }

    public void setGruposUsuario(List<PerfilUsuarioGrupoDTO> gruposUsuario) {
        this.gruposUsuario = gruposUsuario;
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
        gruposUsuario = (List<PerfilUsuarioGrupoDTO>) ActionContext.getContext().getSession().get(TipoSessionObjects.USER_GROUPS.getDescricao());

        //Obtem grupo selecionado
        selectedGroup = (Integer) ActionContext.getContext().getSession().get(TipoSessionObjects.SELECTED_GROUP.getDescricao());
        
        if (gruposUsuario.get(selectedGroup).getPerfil().equalsIgnoreCase(TipoPerfilUsuario.LEITOR.getDescricao())){

            System.out.println("Index Leitor");
            return TipoPerfilUsuario.LEITOR.getDescricao();
        }
        else if (gruposUsuario.get(selectedGroup).getPerfil().equalsIgnoreCase(TipoPerfilUsuario.SYSADMIN.getDescricao())){

            System.out.println("Index SysAdmin");
            return TipoPerfilUsuario.SYSADMIN.getDescricao();
        }
        System.out.println("Index Gestor/Editor");
        return SUCCESS;
    }
    
}
