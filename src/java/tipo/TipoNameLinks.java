/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo;

/**
 *
 * @author discover
 */
public enum TipoNameLinks {
    
    BUSCA("busca"),
    DOCUMENTO("documento"),
    MODELO("modelo"),
    TRECHO("trecho"),
    INDEX("index");
    
    private String descricao;

    private TipoNameLinks(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public static TipoNameLinks obterPorDescricao(String descricao){
        for(TipoNameLinks item : TipoNameLinks.values()){
            
            if (item.getDescricao().equals(descricao)){
                return item;
            }
        
        }
        return null;
        
    }
    
    
    
}
