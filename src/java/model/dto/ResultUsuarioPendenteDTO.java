/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import model.Usuario;

/**
 *
 * @author discover
 */
public class ResultUsuarioPendenteDTO extends Usuario {
    
private String perfil;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }


    
}
