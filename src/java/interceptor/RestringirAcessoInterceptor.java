/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
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
 * @author Jones
 **/

/* Valida se o usuario esta logado
 * Bloqueia acesso indevido do usuario sysadmin 
 * Bloqueia acesso indevido do usuario leitor as telas de criação de artefato
 */

public class RestringirAcessoInterceptor implements Interceptor {
  
    @Override
    public void destroy() {
        
        
    }

    @Override
    public void init() {
        
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        
        //Obtem Usuario Logado
        Usuario usuarioLogado = (Usuario) ai.getInvocationContext().getSession().get(TipoSessionObjects.USER_LOGADO.getDescricao());

        if(usuarioLogado != null){
            
            //Obtendo grupo selecionado
            int selectedGroup = (Integer) ai.getInvocationContext().getSession().get(TipoSessionObjects.SELECTED_GROUP.getDescricao());

            //Obter Lista de Grupos do Usuario
            FiltroGruposUsuarioDTO filtro = new FiltroGruposUsuarioDTO();
            filtro.setIdUsuario(usuarioLogado.getIdUsuario());
            List<PerfilUsuarioGrupoDTO> gruposUsuario = obterGruposUsuario(filtro);
            
            System.out.println("Usuario Logado");
            for(PerfilUsuarioGrupoDTO perfilGrupo : gruposUsuario){
                
                System.out.println("Verificando grupo");
                if(perfilGrupo.getIdGrupo() == selectedGroup){
                    
                    System.out.println("Verificando status perfil");
                    if(perfilGrupo.getAprovado()){
                        
                        System.out.println("Verificando tipo perfil");
                        if (perfilGrupo.getPerfil().equalsIgnoreCase(TipoPerfilUsuario.SYSADMIN.getDescricao())){
                        //restringe o acesso do SysSdmin ao painel de administração
                             System.out.println("Acesso negado");
                             return "negado";

                        }
                        else if(perfilGrupo.getPerfil().equalsIgnoreCase(TipoPerfilUsuario.LEITOR.getDescricao())){
                        //restringe o acesso do Leitor aconsulta de documentos
                             System.out.println("Acesso negado");
                             return "negado";
                        
                        }
                        else{
                       
                             System.out.println("Acesso autorizado");
                             return ai.invokeActionOnly();
                        }
                    }
 
                      System.out.println("Retornando global result pendente");
                      return "pendente";
                }
                
            }
            return "negado";
        }
        
        System.out.println("Retornando global result nao logado");
        return "naoLogado";
        

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
