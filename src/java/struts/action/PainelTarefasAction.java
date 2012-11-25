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
public class PainelTarefasAction extends ActionSupport{
    
    private int selectedGroup;
    private Usuario userLogado;

    public int getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(int selectedGroup) {
        this.selectedGroup = selectedGroup;
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

        //Obtem grupo selecionado
        selectedGroup = (Integer) ActionContext.getContext().getSession().get(TipoSessionObjects.SELECTED_GROUP.getDescricao());
        
        //Verifica perfil do usuario
        for(PerfilUsuarioGrupoDTO perfilGrupo : gruposUsuario){
            if(perfilGrupo.getIdGrupo() == selectedGroup){
            
                if(perfilGrupo.getPerfil().equalsIgnoreCase(TipoPerfilUsuario.EDITOR.getDescricao())){
                
                    return TipoPerfilUsuario.EDITOR.getDescricao();
                    
                }
                else if(perfilGrupo.getPerfil().equalsIgnoreCase(TipoPerfilUsuario.GESTOR.getDescricao())){
                
                    return TipoPerfilUsuario.GESTOR.getDescricao();
                    
                }
            }
        }
        
        return "negado";
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
