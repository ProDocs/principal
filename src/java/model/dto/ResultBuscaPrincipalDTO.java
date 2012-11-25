/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.Date;

/**
 *
 * @author discover
 */
public class ResultBuscaPrincipalDTO {
    private int idArtefato;
    private int versao;
    private Date dataCriacao;
    private String titulo;
    private String conteudo;
    private Date dataAprovacao;
    private String nomeAutor;
    private String autoresTrechos;

    public String getAutoresTrechos() {
        return autoresTrechos;
    }

    public void setAutoresTrechos(String autoresTrechos) {
        this.autoresTrechos = autoresTrechos;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getIdArtefato() {
        return idArtefato;
    }

    public void setIdArtefato(int idArtefato) {
        this.idArtefato = idArtefato;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }
    
    

}
