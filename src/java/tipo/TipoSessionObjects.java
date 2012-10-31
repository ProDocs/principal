/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo;

/**
 *
 * @author discover
 */
public enum TipoSessionObjects {
    
    USER_LOGADO("USER_LOGADO"),
    USER_GROUPS("USER_GROUPS"),
    SELECTED_GROUP("SELECTED_GROUP");
    
    private String descricao;

    private TipoSessionObjects(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public static TipoSessionObjects obterPorDescricao(String descricao){
        for(TipoSessionObjects item : TipoSessionObjects.values()){
            
            if (item.getDescricao().equals(descricao)){
                return item;
            }
        
        }
        return null;
        
    }
    
    
    
}
