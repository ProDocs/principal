/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

/**
 *
 * @author discover
 */
public class FiltroBuscaPrincipal {
    private String pesquisa;
    private String categoria;
    private String tipoArtefato;
    private String tags;
    private int idGrupo;

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTipoArtefato() {
        return tipoArtefato;
    }

    public void setTipoArtefato(String tipoArtefato) {
        this.tipoArtefato = tipoArtefato;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
    
}
