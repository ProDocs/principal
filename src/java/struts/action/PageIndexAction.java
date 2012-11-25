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
import tipo.TipoPerfilUsuario;
import tipo.TipoSessionObjects;

/**
 *
 * @author discover
 */
public class PageIndexAction extends ActionSupport{
    
    private Usuario userLogado;
    private int changeGroup;

    public Usuario getUserLogado() {
        return userLogado;
    }

    public void setUserLogado(Usuario userLogado) {
        this.userLogado = userLogado;
    }

    public int getChangeGroup() {
        return changeGroup;
    }

    public void setChangeGroup(int changeGroup) {
        this.changeGroup = changeGroup;
    }
    

    @Override
    public String execute() throws Exception {

        if(ActionContext.getContext().getSession().get(TipoSessionObjects.USER_LOGADO.getDescricao()) == null){
        
            return "naoLogado";
        }
        
        //Captura usuario logado
        userLogado = (Usuario) ActionContext.getContext().getSession().get(TipoSessionObjects.USER_LOGADO.getDescricao());
        
        //Captura grupos do usuario Logado
        FiltroGruposUsuarioDTO filtro = new FiltroGruposUsuarioDTO();
        filtro.setIdUsuario(userLogado.getIdUsuario());
        List<PerfilUsuarioGrupoDTO> gruposUsuario = obterGruposUsuario(filtro);

        
        if(changeGroup == 0){
        //Obtem grupo definido no login     
        changeGroup = (Integer) ActionContext.getContext().getSession().get(TipoSessionObjects.SELECTED_GROUP.getDescricao());
        }
        else{
        //Obtem grupo selecionado     
        ActionContext.getContext().getSession().put(TipoSessionObjects.SELECTED_GROUP.getDescricao(), changeGroup);
        }
        System.out.println("Grupo Selecionado: "+changeGroup);
        for(PerfilUsuarioGrupoDTO perfilGrupo : gruposUsuario){
            
            if(perfilGrupo.getIdGrupo() == changeGroup){
                
                if(!perfilGrupo.getAprovado()){
                
                    return "pendente";
                }
                
                if(perfilGrupo.getPerfil().equalsIgnoreCase(TipoPerfilUsuario.LEITOR.getDescricao())){
                
                    System.out.println("Index Leitor");
                    return TipoPerfilUsuario.LEITOR.getDescricao();
                
                }
                else if(perfilGrupo.getPerfil().equalsIgnoreCase(TipoPerfilUsuario.SYSADMIN.getDescricao())){
                
                    System.out.println("Index SysAdmin");
                    return TipoPerfilUsuario.SYSADMIN.getDescricao();
                
                }
                else{
                    
                    System.out.println("Index Gestor/Editor");
                    return SUCCESS;

                }

            }

        }

        return null;

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
