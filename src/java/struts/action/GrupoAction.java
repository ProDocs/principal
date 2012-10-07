/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Grupo;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ASUS
 */
public class GrupoAction extends ActionSupport {
    
     HttpServletRequest request = ServletActionContext.getRequest();
     Map<String, Object> session = ActionContext.getContext().getSession();
     
     private Grupo grupo = new Grupo();
     private List<Grupo> lista;

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Grupo> getLista() {
        return lista;
    }

    public void setLista(List<Grupo> lista) {
        this.lista = lista;
    }
    
    
    
}
