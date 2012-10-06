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
     
     private Documento_Trecho trecho = new Documento_Trecho();
     private List<Documento_Trecho> lista;

    public List<Documento_Trecho> getLista() {
        return lista;
    }

    public void setLista(List<Documento_Trecho> lista) {
        this.lista = lista;
    }

    public Documento_Trecho getTrecho() {
        return trecho;
    }

    public void setMusica(Documento_Trecho trecho) {
        this.trecho = trecho;
    }
    
    public String BuscaTrechos() {
        try {
            String user;
            Documento_TrechoDAO dao = new Documento_TrechoDAO();
            Login logado = (Login)session.get("login");
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
