/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Windows
 */
public class Artefato {
    private boolean aprovado;
    private boolean bloqueado;
    private String conteudo;
    private String data_aprovacao;
    private String data_criacao;
    private int idAprovador;
    private int idArtefato;
    private int idAutor;
    private int idCategoria;
    private String tags;
    private int tipo;
    private String titulo;
    private float versao;

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData_aprovacao() {
        return data_aprovacao;
    }

    public void setData_aprovacao(String data_aprovacao) {
        this.data_aprovacao = data_aprovacao;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    public int getIdAprovador() {
        return idAprovador;
    }

    public void setIdAprovador(int idAprovador) {
        this.idAprovador = idAprovador;
    }

    public int getIdArtefato() {
        return idArtefato;
    }

    public void setIdArtefato(int idArtefato) {
        this.idArtefato = idArtefato;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getVersao() {
        return versao;
    }

    public void setVersao(float versao) {
        this.versao = versao;
    }
}
