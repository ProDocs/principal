/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Usuario;
import org.apache.struts2.ServletActionContext;


/**
 *
 * @author discover
 */
public class paginaBuscaAction extends ActionSupport{
    
    
    Map<String, Object> session = ActionContext.getContext().getSession();
    private Usuario userLogin;

    public Usuario getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(Usuario userLogin) {
        this.userLogin = userLogin;
    }
    @Override
    public String execute() throws Exception {
        userLogin = (Usuario) ActionContext.getContext().getSession().get("USER_LOGADO");
                
         System.out.println("Imprimindo Login pagina busca: "+userLogin.getLogin());
        return "success";
    }
    
    
   
    
}
