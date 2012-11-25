/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.GrupoDAO;
import dao.Grupo_UsuarioDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Grupo;
import model.Grupo_Usuario;
import model.Usuario;

/**
 *
 * @author discover
 */
public class CadastrarUsuarioAction extends ActionSupport{
    //Combo Grupos formCadastro
    private List<Grupo>grupos = new ArrayList<Grupo>();
    
    //Parametro de chamada da action
    private boolean carregaForm;

    public boolean isCarregaForm() {
        return carregaForm;
    }

    public void setCarregaForm(boolean carregaForm) {
        this.carregaForm = carregaForm;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    
    //Dados recebidos via form
    
    private Usuario novoUsuario;
    private Integer idGrupo;
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
        
        if(carregaForm){
            
            System.out.println("Validando campos do formulario");
           
           if(idGrupo == 0){
                super.addFieldError("novoUsuario.idGrupo", "O grupo deve ser selecionado!");
           }
                        
           if(perfil.equalsIgnoreCase("0")){
                super.addFieldError("novoUsuario.perfil", "O perfil deve ser selecionado!");
           }
           
           if(novoUsuario.getNome()==null || novoUsuario.getNome().isEmpty()){
                super.addFieldError("novoUsuario.nome", "O nome deve ser preenchido!");
           }
           
           if(novoUsuario.getSobrenome() == null || novoUsuario.getSobrenome().isEmpty()){
              super.addFieldError("novoUsuario.sobrenome", "O sobrenome deve ser preenchido!");  
           }
           
           if(novoUsuario.getEmail() == null || novoUsuario.getEmail().isEmpty()){
              super.addFieldError("novoUsuario.email", "O e-mail deve ser preenchido!");  
           }
           
           if(loginExistente(novoUsuario.getLogin())){
                
                super.addFieldError("novoUsuario.login", "O login informado ja existe");
           }
           
           if(novoUsuario.getLogin() == null || novoUsuario.getLogin().isEmpty()){
                
                super.addFieldError("novoUsuario.login", "O login deve ser preenchido");
           }
           
           if(novoUsuario.getSenha()==null || novoUsuario.getSenha().isEmpty()){
                super.addFieldError("novoUsuario.senha", "A senha deve ser informada!");
           }
           
        }

        
    }
    
    
    @Override
    public String execute() throws Exception {
        
        if(!carregaForm){
            System.out.println("Exibindo formulario de cadastro");
            
            //Populando combo dos grupos
            grupos = obterGrupos();
            
            return "formulario";
        }
        else if(carregaForm){
            
            System.out.println("Recebendo dados do formulario");
            
            UsuarioDAO usuarioDao = new UsuarioDAO();
            int idUsuario;
            
            //Inserção usuario
            try{
                usuarioDao.create(novoUsuario);
            
            }catch(SQLException e){ 
                  e.printStackTrace();
                  return ERROR;
            }
            
            idUsuario = usuarioDao.loginExistente(novoUsuario.getLogin());
            
            //Inserção usuario grupo  
            try{                    
                  Grupo_Usuario grupoUsuario = new Grupo_Usuario();
                  grupoUsuario.setAprovado(false);
                  grupoUsuario.setIdGrupo(idGrupo);
                  grupoUsuario.setIdUsuario(idUsuario);
                  grupoUsuario.setPerfil(perfil);

                  Grupo_UsuarioDAO grupoUsuarioDao = new Grupo_UsuarioDAO();

                  grupoUsuarioDao.create(grupoUsuario);
              }
              catch(SQLException e){
                  usuarioDao.delete(idUsuario);
                  e.printStackTrace();
                  return ERROR;
              }
          return SUCCESS;
            
        }

        return ERROR;
    }  
          
    
    private Boolean loginExistente(String login){
        
        try{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        int validaLogin = usuarioDAO.loginExistente(login);
        
        if(validaLogin > 0){ 
            return true;
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return false;

    }
    
    private List<Grupo> obterGrupos(){
        
        try{
             GrupoDAO grupoDao = new GrupoDAO();
             List <Grupo> gruposTMP = new ArrayList<Grupo>();
             gruposTMP = grupoDao.listarTodosGrupos();
             
             return gruposTMP;
             
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
            
   }
    
}
