/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.io.Serializable;

/**
 *
 * @author discover
 */
public class FiltroGruposUsuarioDTO implements Serializable{
    
    private Integer idUsuario;
    private Integer idGrupo;

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
}
