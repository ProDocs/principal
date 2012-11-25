/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import filtro.FiltroBuscaPrincipal;
import java.util.List;
import model.Artefato;
import tipo.TipoSessionObjects;
/**
 *
 * @author ASUS
 */
public class BuscaPrincipalAction extends ActionSupport {
    
    
    FiltroBuscaPrincipal filtro = new FiltroBuscaPrincipal();

    public FiltroBuscaPrincipal getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroBuscaPrincipal filtro) {
        this.filtro = filtro;
    }
    
    
    
    @Override
    public String execute(){
        int idGrupo = (Integer) ActionContext.getContext().getSession().get(TipoSessionObjects.SELECTED_GROUP.getDescricao());
        filtro.setIdGrupo(idGrupo);
        
    
        return null;
    }

    
    public String[]splitCSV(String csv){
        String delimiter = ",";
        String[]tags;
        tags = csv.split(delimiter);

        return tags;
    }
    public List<Artefato> resultadoBusca(FiltroBuscaPrincipal filtro){
        
        return null;
    
    }
    
}
