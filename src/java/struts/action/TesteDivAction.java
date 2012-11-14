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
public class TesteDivAction extends ActionSupport{
    
    Map<String,Object> session = ActionContext.getContext().getSession();
    
    private String tipoMensagem;
    private String mensagem;

    public String getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(String tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }
    

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    

    @Override
    public String execute() throws Exception {
        
        if(tipoMensagem!= null && !tipoMensagem.isEmpty()){
        if(tipoMensagem.equalsIgnoreCase("1")){
        
            mensagem = "Mensagem tipo 1 carregada com sucesso!";
            return SUCCESS;
        }
        
        if(tipoMensagem.equalsIgnoreCase("2")){
            
            mensagem = "Mensagem tipo 2 carregada com sucesso!";
            return SUCCESS;
        
        }
        
        else{
        
             return SUCCESS;
        
        }
        
        }
        
        return SUCCESS;
    }
    
    
    
}
