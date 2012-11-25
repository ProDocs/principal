/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import tipo.TipoSessionObjects;

/**
 *
 * @author discover
 */
public class LogoutAction extends ActionSupport{
    
    @Override
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove(TipoSessionObjects.USER_LOGADO.getDescricao());
        session.remove(TipoSessionObjects.SELECTED_GROUP.getDescricao());
        
       return "success";
    }
    
    
}
