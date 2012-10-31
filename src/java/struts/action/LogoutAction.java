/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author discover
 */
public class LogoutAction extends ActionSupport{
    public static final String USER_LOGADO = "USER_LOGADO";
    
    @Override
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove(USER_LOGADO);
        
       return "success";
    }
    
    
}
