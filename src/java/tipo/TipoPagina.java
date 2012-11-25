/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo;

/**
 *
 * @author discover
 */
public enum TipoPagina {
    
    MINHAS_TAREFAS("minhas_tarefas"),
    DOCUMENTO("documento"),
    TRECHO("trecho"),
    BUSCA("busca"),
    MODELO("modelo"),
    INDEX("index");
    
    private String descricao;

    private TipoPagina(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
