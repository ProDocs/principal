/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo;

/**
 *
 * @author Jones
 */
public enum TipoPerfilUsuario {
    
    SYSADMIN("sysadmin"),
    GESTOR("Gestor"),
    EDITOR("Editor"),
    LEITOR("Leitor");
    
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
