/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.Grupo_UsuarioDAO;
import dao.UsuarioDAO;
import model.Grupo_Usuario;
import model.Usuario;

/**
 *
 * @author discover
 */
public class CadastrarUsuarioAction extends ActionSupport{
    
    
    private Usuario novoUsuario;
    private int idGrupo;
    private String perfil;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
    
    
    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }


    @Override
    public void validate() {
        
            if(loginExistente(novoUsuario.getLogin())){
            //super.addFieldError("user.nome", "O login informado já existe!");  
            }
            
            if(novoUsuario.getNome()==null || novoUsuario.getNome().isEmpty()){
            System.out.println("deu xabu");
                super.addFieldError("novoUsuario.nome", "O nome deve ser informado!");
            
            }
  
           
           // super.addFieldError("user.login", "Login deve ser informado!");
   
        
           // super.addFieldError("user.senha", "Senha deve ser informado!");
     
        
           // super.addFieldError("user.email", "Email deve ser informado!");
        
        
           //super.addFieldError("user.sexo", "Sexo deve ser informado!");
        
    }
    
    
    @Override
    public String execute() throws Exception {
        
        try{
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        int inserido = usuarioDao.cadastrarUsuario(novoUsuario);
        
        if(inserido == 0){
            return ERROR;
        }
        else{
        
            Grupo_Usuario grupoUsuario = new Grupo_Usuario();
            grupoUsuario.setAprovado(Boolean.FALSE);
            grupoUsuario.setIdGrupo(idGrupo);
            grupoUsuario.setIdUsuario(inserido);
            grupoUsuario.setPerfil(perfil);
            
            Grupo_UsuarioDAO grupoUsuarioDAO = new Grupo_UsuarioDAO();
           
            grupoUsuarioDAO.create(grupoUsuario);
            
            try{
            }catch(Exception e){
                System.out.println("Erro ao associar ao grupo");
                e.printStackTrace();
                
            }

        }
        
        return SUCCESS;
        
        }
        catch(Exception e){
            System.out.println("Erro ao cadastrar Usuario");
            e.printStackTrace();
        }

        return ERROR;
    }
    
    
    
    private Boolean loginExistente(String login){
        
        try{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        int validaLogin = usuarioDAO.loginExistente(login);
        
        if(validaLogin > 0);{ 
            return true;
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return false;

    }
    
}
