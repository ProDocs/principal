/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author discover
 */
public class DisplayAjaxAction extends ActionSupport{

    private String pagina;

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
    
    @Override
    public String execute() throws Exception {
        
        if(pagina == null){
        
            return "index";
            
        }
        
        return pagina;

    }
    
    
}
