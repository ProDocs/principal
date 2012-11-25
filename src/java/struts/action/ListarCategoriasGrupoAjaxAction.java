/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import tipo.TipoSessionObjects;

/**
 *
 * @author discover
 */
public class ListarCategoriasGrupoAjaxAction extends ActionSupport{
    
    private List<Categoria> categoriasGrupo = new ArrayList<Categoria>();

    public List<Categoria> getCategoriasGrupo() {
        return categoriasGrupo;
    }

    public void setCategoriasGrupo(List<Categoria> categoriasGrupo) {
        this.categoriasGrupo = categoriasGrupo;
    }

    
    @Override
    public String execute() throws Exception {
        
        int selectedGrouup = (Integer) ActionContext.getContext().getSession().get(TipoSessionObjects.SELECTED_GROUP.getDescricao());
        
        //Captura categorias do grupo selecionado
        categoriasGrupo = obterCategoriasGrupo(selectedGrouup);

        return SUCCESS;
    }
    
    public List<Categoria> obterCategoriasGrupo(int idGrupo) throws Exception{

        System.out.println("Listando categorias do Grupo");
        try{
            CategoriaDAO categoriaDao = new CategoriaDAO();
            List<Categoria>categoriasTMP = new ArrayList<Categoria>();
            Categoria catDefault = new Categoria();
            catDefault.setNome("-- Selecione --");
            catDefault.setIdCategoria(0);

            categoriasTMP = categoriaDao.listarCategoriasGrupo(idGrupo);
            categoriasTMP.add(catDefault);
            return categoriasTMP;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
            
        }
    }
    
    
    
}
