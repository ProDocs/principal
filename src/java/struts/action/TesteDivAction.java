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
    private String[] tags;

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
    
    

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
            System.out.println("No if");
        
            mensagem = "Mensagem tipo 1 carregada com sucesso!";
            return SUCCESS;
        }
        
        if(tipoMensagem.equalsIgnoreCase("2")){
            
            mensagem = "Mensagem tipo 2 carregada com sucesso!";
            return SUCCESS;
        
        }
        
        else{
            System.out.println("No else");
            for(String imprime : tags){
                System.out.println("Recebeu parametros: "+imprime);
            }
            
             return SUCCESS;
             
        
        }
        
        }
        
         System.out.println("Em nenhum");
        
         for(String imprime : tags){
                System.out.println("Recebeu parametros: "+imprime);
            }
        
        return SUCCESS;
    }
    
    
    
}
