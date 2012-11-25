/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.GrupoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import model.dto.FiltroGruposUsuarioDTO;
import model.dto.PerfilUsuarioGrupoDTO;
import tipo.TipoSessionObjects;

/**
 *
 * @author Jones
 */
public class AlterarGrupoAction extends ActionSupport {
    
    private int changeGroup;
    private Usuario userLogado;
    

    public int getChangeGroup() {
        return changeGroup;
    }

    public void setChangeGroup(int changeGroup) {
        this.changeGroup = changeGroup;
    }

    public Usuario getUserLogado() {
        return userLogado;
    }

    public void setUserLogado(Usuario userLogado) {
        this.userLogado = userLogado;
    }
    
    @Override
    public String execute() throws Exception {

        //Captura usuario logado
        userLogado = (Usuario) ActionContext.getContext().getSession().get(TipoSessionObjects.USER_LOGADO.getDescricao());
        
        if(userLogado==null){
        
            return "naoLogado";
            
        }
        
        //Captura grupos do usuario Logado
        FiltroGruposUsuarioDTO filtro = new FiltroGruposUsuarioDTO();
        filtro.setIdUsuario(userLogado.getIdUsuario());
        List<PerfilUsuarioGrupoDTO> gruposUsuario = obterGruposUsuario(filtro);

        //Seta grupo selecionado
        ActionContext.getContext().getSession().put(TipoSessionObjects.SELECTED_GROUP.getDescricao(), changeGroup);
        
        for(PerfilUsuarioGrupoDTO perfilGrupo : gruposUsuario){
        
            if(perfilGrupo.getIdGrupo() == changeGroup){
                if(perfilGrupo.getAprovado()){
                    
                    return SUCCESS;
                    
                }
                
                return "pendente";
            
            }
        
        }
        
        return "pendente";
    }
    
    public List<PerfilUsuarioGrupoDTO> obterGruposUsuario(FiltroGruposUsuarioDTO filtro) throws Exception{

        System.out.println("Listando usuários do Grupo");
        try{
            GrupoDAO grupoDao = new GrupoDAO();
            List<PerfilUsuarioGrupoDTO>gruposTMP = new ArrayList<PerfilUsuarioGrupoDTO>();

            gruposTMP = grupoDao.listarGrupos(filtro);
            return gruposTMP;
           }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    
}
