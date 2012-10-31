/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo;

/**
 *
 * @author discover
 */
public enum TipoPerfilUsuario {
    
    GESTOR("gestor"),
    EDITOR("editor"),
    LEITOR("leitor"),
    SYSADMIN("sysadmin");
    
    private String descricao;

    private TipoPerfilUsuario(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
