/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "INSERT INTO CATEGORIA (idCategoria,idGrupo,descricao,nome) " +
                "values(?,?,?,?)";        
        
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setInt(1, categoria.getIdCategoria());
        stm.setInt(2, categoria.getIdGrupo());
        stm.setString(3, categoria.getDescricao());
        stm.setString(4, categoria.getNome());

        System.out.println(sql);
        stm.executeUpdate();
        System.out.println("Inserção ok!");
    
    }

    /* consulta no BD */
    @Override
    public Object read(Object key) throws SQLException
    {
                String nome = (String) key;

		String sql = "SELECT * FROM CATEGORIA WHERE idCategoria=?";
		PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
		stm.setString(1, nome);
                System.out.println(nome);
		ResultSet rs = stm.executeQuery();
                
		if (rs.next()) {
			Categoria tmp = new Categoria();
                        tmp.setIdCategoria(rs.getInt("idCategoria"));
                        tmp.setIdGrupo(rs.getInt("idGrupo"));     
                        tmp.setDescricao(rs.getString("descricao"));
                        tmp.setNome(rs.getString("nome"));
			return tmp;                      
		}

	return null;
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
        Categoria a = (Categoria)object;

        String sql = "DELETE FROM categoria WHERE idCategoria=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setInt(1, a.getIdCategoria());

        stm.executeUpdate();
    }
    
}
