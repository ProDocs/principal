/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.GrupoDAO;
import java.util.ArrayList;
import java.util.List;
import model.Grupo;
import tipo.TipoPerfilUsuario;

/**
 *
 * @author discover
 */
public class PageCadastroAction extends ActionSupport {
    
    private List<String> perfisUsuario = listarPerfisUsuario();
    private List<Grupo> todosGrupos = listarGrupos();

    
    public List<Grupo> getTodosGrupos() {
        return todosGrupos;
    }

    public void setTodosGrupos(List<Grupo> todosGrupos) {
        this.todosGrupos = todosGrupos;
    }

    public List<String> getPerfisUsuario() {
        return perfisUsuario;
    }

    public void setPerfisUsuario(List<String> perfisUsuario) {
        this.perfisUsuario = perfisUsuario;
    }
    
    
    
    
    @Override
    public String execute() throws Exception {
    
        return SUCCESS;
    }
    
    private List<String> listarPerfisUsuario(){
        
        List<String> tiposPerfil = new ArrayList<String>();
        
        for(TipoPerfilUsuario perfil : TipoPerfilUsuario.values()){

            tiposPerfil.add(perfil.getDescricao());
        }
        
         return tiposPerfil;
    }
    
    
    private List<Grupo> listarGrupos(){
            
        try{
            List<Grupo> grupos = new ArrayList<Grupo>();
            GrupoDAO grupoDAO = new GrupoDAO();
            grupos = grupoDAO.listarTodosGrupos();
            
            return grupos;
        
        }catch(Exception e){
            e.printStackTrace();
        }

         return null;
    }
    
    
    
}
