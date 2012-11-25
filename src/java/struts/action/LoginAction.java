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
import javassist.bytecode.stackmap.BasicBlock.Catch;
import model.Usuario;
import model.dto.FiltroGruposUsuarioDTO;
import model.dto.PerfilUsuarioGrupoDTO;
import tipo.TipoSessionObjects;

/**
 *
 * @author Jones
 */
public class LoginAction extends ActionSupport {
    
    private Usuario userLogin;//recebe o usuário do request
    private Usuario userLogado;//usuario guardado na sessão
    
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
        
       userLogado = (Usuario) ActionContext.getContext().getSession().get(TipoSessionObjects.USER_LOGADO.getDescricao());
       if(userLogado!=null && userLogado.getLogin().equalsIgnoreCase(userLogin.getLogin())){
           System.out.println("Login ok ");
           
           return SUCCESS;
       }
        
        Usuario userValido;
        userValido = validaLogin();

        if (userValido != null) {
           
            //Guarda o usuario na sessão
            ActionContext.getContext().getSession().put(TipoSessionObjects.USER_LOGADO.getDescricao(), userValido);
            
            //Carrega dados do usuário para utilizar na view
            userLogado = userValido;
            
            //Carrega grupos do usuario que serão listados na combo       
            FiltroGruposUsuarioDTO filtro = new FiltroGruposUsuarioDTO();
            filtro.setIdUsuario(userLogado.getIdUsuario());
            List<PerfilUsuarioGrupoDTO> gruposUsuario = obterGruposUsuario(filtro);
            
               
                for(PerfilUsuarioGrupoDTO grupoDefault : gruposUsuario){    
                   if(grupoDefault.getAprovado()){
                       
                    //Guarda grupo selecionado na sessão
                       int selectedGroup = grupoDefault.getIdGrupo();
                       ActionContext.getContext().getSession().put(TipoSessionObjects.SELECTED_GROUP.getDescricao(), selectedGroup);
                       return SUCCESS;
                       
                   }
                   
                }
                int selectedGroup = gruposUsuario.get(0).getIdGrupo();
                ActionContext.getContext().getSession().put(TipoSessionObjects.SELECTED_GROUP.getDescricao(), selectedGroup);
                return SUCCESS;

        } else {
            System.out.println("Invalido");
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
