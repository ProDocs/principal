/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
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
        Categoria categoria = (Categoria) object;
        String sql = "INSERT INTO CATEGORIA (nome,id,descricao) " +
                "values(?,?,?)";        
        
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setString(1, categoria.getNome());
        stm.setInt(2, categoria.getIdGrupo());
        stm.setString(3, categoria.getDescricao());

        System.out.println(sql);
        stm.executeUpdate();
        System.out.println("Inserção ok!");
    
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

