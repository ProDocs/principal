/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.*;
import dao.*;
import org.apache.struts2.ServletActionContext;
/**
 *
 * @author ASUS
 */
public class BuscaAction extends ActionSupport {
    
     HttpServletRequest request = ServletActionContext.getRequest();
     Map<String, Object> session = ActionContext.getContext().getSession();
     
     private Artefato artefato = new Artefato();
     private List<Artefato> lista;

    public List<Artefato> getLista() {
        return lista;
    }

    public void setLista(List<Artefato> lista) {
        this.lista = lista;
    }

    public Artefato getTrecho() {
        return artefato;
    }

    public void setMusica(Artefato artefato) {
        this.artefato = artefato;
    }
    
    public String BuscaTrechos() {
        try {
            String user;
            ArtefatoDAO dao = new ArtefatoDAO();
            Login logado = (Login)session.get("USER_LOGADO");
            user = (String) logado.getLogin();
            
            if(logado != null){
            lista = dao.readAll(user);
                return "success";
            }else{return "error";}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
