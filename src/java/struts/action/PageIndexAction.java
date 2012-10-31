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
import model.Grupo;
import model.Usuario;
import tipo.TipoSessionObjects;

/**
 *
 * @author discover
 */
public class PageIndexAction extends ActionSupport{
    
    private TipoSessionObjects objSession;
    
    Map<String, Object> session = ActionContext.getContext().getSession();
    
    private String selectedGroup;
    private Usuario userLogado;
    private List<Grupo> gruposUsuario = new ArrayList<Grupo>();
    
     public String getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(String selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public List<Grupo> getGruposUsuario() {
        return gruposUsuario;
    }

    public void setGruposUsuario(List<Grupo> gruposUsuario) {
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
        gruposUsuario = (List<Grupo>) ActionContext.getContext().getSession().get(objSession.USER_GROUPS.getDescricao());

        //Obtem grupo selecionado
        selectedGroup = (String) ActionContext.getContext().getSession().get(objSession.SELECTED_GROUP.getDescricao());
        
        return SUCCESS;
    }
    
}
