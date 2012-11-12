/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.io.Serializable;
import model.Grupo;

/**
 *
 * @author discover
 */
public class PerfilUsuarioGrupoDTO extends Grupo implements Serializable{
    
    private String perfil;

    private Boolean aprovado;

    
    
    public PerfilUsuarioGrupoDTO() {
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }
    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
    
}
