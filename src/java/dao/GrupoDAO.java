/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Grupo;
import java.sql.SQLException;
import model.Grupo;

/**
 *
 * @author ASUS
 */
public class GrupoDAO implements Dao{
    
    private DataSource dataSource;

    public GrupoDAO() throws SQLException {
        dataSource = new DataSource();
    }
    
        /* inserao no BD */
    @Override
    public void create(Object object) throws SQLException
    {
        System.out.println("Dao CREATED");

        Grupo grupo = (Grupo) object;
        String sql = "insert into grupo (nome, descricao) "
                + "values(?,?)";

        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
       
        stm.setString(1, grupo.getNome());
        stm.setString(2, grupo.getDescricao());
       
      

        stm.executeUpdate();
        System.out.println(stm.toString());
        System.out.println("Insersao de grupo ok!");
    
    }

    /* consulta no BD */
    @Override
    public Object read(Object object) throws SQLException
    {
        int cod_group = (Integer) object;
        ResultSet rs;
        String sql = "select * from grupo where idGrupo=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setLong(1, cod_group);
        rs = stm.executeQuery();

        if (rs.next()) {
            Grupo grupo = new Grupo();
            grupo.setIdGrupo(rs.getInt(1));
            grupo.setNome(rs.getString(2));
            grupo.setDescricao(rs.getString(3));
       
            return grupo;
        }
        return null;
    }

    /* atualizaao no BD */
    @Override
    public void update(Object object) throws SQLException
    {
        Grupo group = (Grupo) object;
        
        String sql = "update grupo set nome=?, descricao=? where idGrupo=?";
        
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setString(1, group.getNome());
        stm.setString(2, group.getDescricao());
        
        stm.executeUpdate();
    }

    /* exclusao no BD */
    @Override
    public void delete(Object object) throws SQLException
    {
        Grupo group = (Grupo) object;
        String sql = "delete from grupo where IdGrupo=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setInt(1, group.getIdGrupo());
        stm.executeUpdate();
        System.out.println("Grupo Excluido");
    }
    
}

