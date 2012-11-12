/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;   
import dao.GrupoDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Usuario;
import model.dto.FiltroGruposUsuarioDTO;
import model.dto.PerfilUsuarioGrupoDTO;
import tipo.TipoPerfilUsuario;
import tipo.TipoSessionObjects;

/**
 *
 * @author Jones
 */
public class LoginAction extends ActionSupport {
    
    private TipoSessionObjects objSession;
    private TipoPerfilUsuario tipoPerfil;

    Map<String, Object> session = ActionContext.getContext().getSession();

    private Usuario userLogin;//recebe o usuário do request
    private Usuario userLogado;//usuario guardado na sessão
    private int selectedGroup;//grupo definido na sessão
    private List<PerfilUsuarioGrupoDTO> gruposUsuario = new ArrayList<PerfilUsuarioGrupoDTO>();//grupos do usuario guardados na sessao

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
    
    public Usuario getUserLogin() {
        return userLogin;
    }

    public Usuario getUserLogado() {
        return userLogado;
    }

    public void setUserLogado(Usuario userLogado) {
        this.userLogado = userLogado;
    }

    public void setUserLogin(Usuario userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String execute() throws Exception {
        
        Usuario userValido;
        userValido = validaLogin();

        if (userValido != null) {
           
            //Guarda o usuario na sessão
            ActionContext.getContext().getSession().put(objSession.USER_LOGADO.getDescricao(), userValido);
            
            //Carrega dados do usuário para utilizar na view
            userLogado = (Usuario) ActionContext.getContext().getSession().get(objSession.USER_LOGADO.getDescricao());
                   
            FiltroGruposUsuarioDTO filtro = new FiltroGruposUsuarioDTO();
            filtro.setIdUsuario(userLogado.getIdUsuario());
            
            //Carrega grupos do usuario que serão listados na combo
            gruposUsuario = obterGruposUsuario(filtro);
            
            //Guarda grupos do usuario na sessão
            ActionContext.getContext().getSession().put(objSession.USER_GROUPS.getDescricao(), gruposUsuario);
            
            
                for(int i = 0; i < gruposUsuario.size(); i++){
                    
                   if(gruposUsuario.get(i).getAprovado()){
                    
                        //Verifica Perfil de Usuario
                        if(gruposUsuario.get(i).getPerfil().equalsIgnoreCase(tipoPerfil.LEITOR.getDescricao())){

                            System.out.println("Grupo Default "+ gruposUsuario.get(i).getNome());
                            //Guarda grupo selecionado na sessão
                            selectedGroup = i;
                            ActionContext.getContext().getSession().put(objSession.SELECTED_GROUP.getDescricao(), selectedGroup);
                            return tipoPerfil.LEITOR.getDescricao();

                        }
                        else if(gruposUsuario.get(i).getPerfil().equalsIgnoreCase(tipoPerfil.SYSADMIN.getDescricao())){

                            System.out.println("Grupo Default "+ gruposUsuario.get(i).getNome());
                            //Guarda grupo selecionado na sessão
                            selectedGroup = i;
                            ActionContext.getContext().getSession().put(objSession.SELECTED_GROUP.getDescricao(), selectedGroup);
                            return tipoPerfil.SYSADMIN.getDescricao();

                        }
                        //Usuario Gestor ou Editor
                            System.out.println("Grupo Default "+ gruposUsuario.get(i).getNome());
                            //Guarda grupo selecionado na sessão
                            selectedGroup = i;
                            ActionContext.getContext().getSession().put(objSession.SELECTED_GROUP.getDescricao(), selectedGroup);
                            return SUCCESS;
                   }
                }
                
                        return "pendente";

        } else {
            System.out.println("invalido");
            super.addFieldError("userLogin.login", "Login/Senha inválido");
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if (getUserLogin().getLogin() == null || getUserLogin().getLogin().isEmpty()) {
            super.addFieldError("userLogin.login", "O login deve ser informado!");
        }
        if (getUserLogin().getSenha() == null || getUserLogin().getSenha().isEmpty()) {
            super.addFieldError("userLogin.senha", "A senha deve ser informada!");
        }
    }

    public Usuario validaLogin() {
        try {
                System.out.println(userLogin.getLogin());
                System.out.println(userLogin.getSenha());
                System.out.println("Validando Usuario");

                Usuario userTemp;
                UsuarioDAO userDao = new UsuarioDAO();
                userTemp = userDao.readUserLoginPassWord(userLogin);
                if (userTemp == null) {
                    return null;
                } else {
                    return userTemp;
                }
            } 
        catch (Exception e) {
                e.printStackTrace();
                return null;
            }
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
