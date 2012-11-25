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
 * @author discover
 */
public class ListarGruposUsuarioAjaxAction extends ActionSupport{
    
    private int selectedGroup;
    private List<PerfilUsuarioGrupoDTO> gruposUsuario = new ArrayList<PerfilUsuarioGrupoDTO>();

    public int getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(int selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public List<PerfilUsuarioGrupoDTO> getGruposUsuario() {
        return gruposUsuario;
    }

    public void setGruposUsuario(List<PerfilUsuarioGrupoDTO> gruposUsuario) {
        this.gruposUsuario = gruposUsuario;
    }

    
    @Override
    public String execute() throws Exception {

        //Captura usuario logado
        Usuario userLogado = (Usuario) ActionContext.getContext().getSession().get(TipoSessionObjects.USER_LOGADO.getDescricao());
        
        //Captura grupos do usuario Logado
        FiltroGruposUsuarioDTO filtro = new FiltroGruposUsuarioDTO();
        filtro.setIdUsuario(userLogado.getIdUsuario());
        gruposUsuario = obterGruposUsuario(filtro);

        //Obtem grupo selecionado
        selectedGroup = (Integer) ActionContext.getContext().getSession().get(TipoSessionObjects.SELECTED_GROUP.getDescricao());
        
        return SUCCESS;
    }
    
    public List<PerfilUsuarioGrupoDTO> obterGruposUsuario(FiltroGruposUsuarioDTO filtro) throws Exception{

        System.out.println("Listando Grupos do usuário ");
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
