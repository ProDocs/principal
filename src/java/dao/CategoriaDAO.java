/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Categoria;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class CategoriaDAO implements Dao{
    
    private DataSource dataSource;

    public CategoriaDAO() throws SQLException {
        dataSource = new DataSource();
    }
    
        /* inserao no BD */
    @Override
    public void create(Object object) throws SQLException
    {
    
    }

    /* consulta no BD */
    @Override
    public Object read(Object key) throws SQLException
    {
     return "";
    }

    /* atualizaao no BD */
    @Override
    public void update(Object object) throws SQLException
    {
        
    }

    /* exclusao no BD */
    @Override
    public void delete(Object object) throws SQLException
    {
        
    }
    
}

