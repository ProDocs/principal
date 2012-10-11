/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Notificacoes;

/**
 *
 * @author ASUS
 */
public class NotificacoesDAO implements Dao{
    
    private DataSource dataSource;

    public NotificacoesDAO() throws SQLException {
        dataSource = new DataSource();
    }
    
        /* inserao no BD */
    @Override
    public void create(Object object) throws SQLException
    {    
        Notificacoes notificacoes = (Notificacoes) object;
        String sql = "INSERT INTO NOTIFICACOES (idArtetafo,idGestor,idNotificacoes,mensagem) " +
                "values(?,?,?,?)";        
        
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setInt(1, notificacoes.getIdArtetafo());
        stm.setInt(2, notificacoes.getIdGestor());
        stm.setInt(3, notificacoes.getIdNotificacoes());
        stm.setString(4, notificacoes.getMensagem());

        System.out.println(sql);
        stm.executeUpdate();
        System.out.println("Inserção ok!");
    }

    /* consulta no BD */
    @Override
    public Object read(Object key) throws SQLException
    {
                String nome = (String) key;

		String sql = "SELECT * FROM NOTIFICACOES WHERE idArtetafo=?";
		PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
		stm.setString(1, nome);
                System.out.println(nome);
		ResultSet rs = stm.executeQuery();
                
		if (rs.next()) {
			Notificacoes tmp = new Notificacoes();
                        tmp.setIdArtetafo(rs.getInt("idArtetafo"));
                        tmp.setIdGestor(rs.getInt("idGestor"));     
                        tmp.setIdNotificacoes(rs.getInt("idNotificacoes"));
                        tmp.setMensagem(rs.getString("mensagem"));
			return tmp;                      
		}

	return null;
    }

    /* atualizaao no BD */
    @Override
    public void update(Object object) throws SQLException
    {
             	Notificacoes a = (Notificacoes)object;

                String sql="UPDATE NOTIFICACOES SET idGestor=?, idNotificacoes=?, mensagem=?"
                        + " where idArtetafo=?";

                PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

                stm.setInt(1, a.getIdGestor());
                stm.setInt(2, a.getIdNotificacoes());
                stm.setString(3, a.getMensagem());
                stm.setInt(5, a.getIdArtetafo());

                stm.executeUpdate();      
    }

    /* exclusao no BD */
    @Override
    public void delete(Object object) throws SQLException
    {
        Notificacoes a = (Notificacoes)object;

        String sql = "DELETE FROM NOTIFICACOES WHERE idArtefato=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setInt(1, a.getIdArtetafo());

        stm.executeUpdate();
    }
}
