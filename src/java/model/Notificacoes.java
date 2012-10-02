/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Windows
 */
public class Notificacoes {
    private int idArtetafo;
    private int idGestor;
    private int idNotificacoes;
    private String mensagem;

    public int getIdArtetafo() {
        return idArtetafo;
    }

    public void setIdArtetafo(int idArtetafo) {
        this.idArtetafo = idArtetafo;
    }

    public int getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(int idGestor) {
        this.idGestor = idGestor;
    }

    public int getIdNotificacoes() {
        return idNotificacoes;
    }

    public void setIdNotificacoes(int idNotificacoes) {
        this.idNotificacoes = idNotificacoes;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
