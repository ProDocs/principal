/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Grupo_Usuario;

/**
 *
 * @author ASUS
 */
public class Grupo_UsuarioDAO implements Dao{
    
    private DataSource dataSource;

    public Grupo_UsuarioDAO() throws SQLException {
        dataSource = new DataSource();
    }
    
        /* inserao no BD */
    @Override
    public void create(Object object) throws SQLException
    {
        System.out.println("Dao CREATED");

        Grupo_Usuario group_user = (Grupo_Usuario) object;
        String sql = "insert into grupo (perfil) "
                + "values(?)";

        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
       
        stm.setString(1, group_user.getPerfil());       
      

        stm.executeUpdate();
        System.out.println(stm.toString());
        System.out.println("Insersao de grupo_usuario ok!");
    }

    /* consulta no BD */
    @Override
    public Object read(Object key) throws SQLException
    {
        int cod_group = (Integer) key;
        ResultSet rs;
        String sql = "select * from grupo_usuario where idGrupo=? or idUsuario=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setLong(1, cod_group);
        rs = stm.executeQuery();

        if (rs.next()) {
            Grupo_Usuario grupo_usuario = new Grupo_Usuario();
            grupo_usuario.setIdGrupo(rs.getInt(1));
            grupo_usuario.setIdUsuario(rs.getInt(2));
            grupo_usuario.setPerfil(rs.getString(2));
       
            return grupo_usuario;
        }
        return null;
    }

    /* atualizaao no BD */
    @Override
    public void update(Object object) throws SQLException
    {
        Grupo_Usuario group = (Grupo_Usuario) object;
        
        String sql = "update grupo_usuario set perfil=? where idUsuario=?";
        
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setString(1, group.getPerfil());
        
        stm.executeUpdate();
    }

    /* exclusao no BD */
    @Override
    public void delete(Object object) throws SQLException
    {
        Grupo_Usuario group = (Grupo_Usuario) object;
        String sql = "delete from grupo_usuario where IdGrupo=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setInt(1, group.getIdGrupo());
        stm.executeUpdate();
        System.out.println("Grupo Excluido");
    }
    
     
    
}

