/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Documento_Trecho;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Documento_TrechoDAO implements Dao{
    
    private DataSource dataSource;

    public Documento_TrechoDAO() throws SQLException {
        dataSource = new DataSource();
    }
    
        /* inserao no BD */
    @Override
    public void create(Object object) throws SQLException
    {
        System.out.println("Dao CREATED");

        Documento_Trecho group_user = (Documento_Trecho) object;
        String sql = "insert into documento_trecho () "
                + "values(?)";

        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        
      

        stm.executeUpdate();
        System.out.println(stm.toString());
        System.out.println("Insersao de documento_trecho ok!");
    }

    /* consulta no BD */
    @Override
    public Object read(Object key) throws SQLException
    {
        int doc_trecho = (Integer) key;
        ResultSet rs;
        String sql = "select * from documento_trecho where idDocumento=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setLong(1, doc_trecho);
        rs = stm.executeQuery();

        if (rs.next()) {
            Documento_Trecho documento_trecho = new Documento_Trecho();
            documento_trecho.setIdDocumento(rs.getInt(1));
            documento_trecho.setIdTrecho(rs.getInt(2));
       
            return documento_trecho;
        }
        return null;
    }
    
    /* atualizaao no BD */
    @Override
    public void update(Object object) throws SQLException
    {
        Documento_Trecho doc_trecho = (Documento_Trecho) object;
        
        String sql = "update grupo_usuario set perfil=? where idUsuario=?";
        
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        
        stm.executeUpdate();
    }

    /* exclusao no BD */
    @Override
    public void delete(Object object) throws SQLException
    {
        Documento_Trecho group = (Documento_Trecho) object;
        String sql = "delete from documento_trecho where IdDocumento=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setInt(1, group.getIdDocumento());
        stm.setInt(2, group.getIdTrecho());
        stm.executeUpdate();
        System.out.println("Documento_trecho Excluido");
    }
    
}

