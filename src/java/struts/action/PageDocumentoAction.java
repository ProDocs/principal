/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Usuario;
import model.dto.PerfilUsuarioGrupoDTO;
import tipo.TipoSessionObjects;

/**
 *
 * @author discover
 */
public class PageDocumentoAction extends ActionSupport{
    
    private TipoSessionObjects objSession;
    
    Map<String, Object> session = ActionContext.getContext().getSession();
    
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
        userLogado = (Usuario) ActionContext.getContext().getSession().get(objSession.USER_LOGADO.getDescricao());
        
        //Captura grupos do usuario Logado
        gruposUsuario = (List<PerfilUsuarioGrupoDTO>) ActionContext.getContext().getSession().get(objSession.USER_GROUPS.getDescricao());

        //Obtem grupo selecionado
        selectedGroup = (Integer) ActionContext.getContext().getSession().get(objSession.SELECTED_GROUP.getDescricao());
        
        return SUCCESS;
    }
    
}
