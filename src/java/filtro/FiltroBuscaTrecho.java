/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import java.util.List;

/**
 *
 * @author discover
 */
public class FiltroBuscaTrecho {
    
    private String conteudo;
    private List<String> tags;
    private String titulo;
    private int idCategoria;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
}
