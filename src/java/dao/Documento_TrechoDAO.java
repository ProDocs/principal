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
    
    }

    /* consulta no BD */
    @Override
    public Object read(Object key) throws SQLException
    {
     return "";
    }

    public List<Documento_Trecho> readAll(String logado) throws SQLException{
        int i = 0;
        String loga = logado;
        ResultSet rs;
        String sql = "SELECT musicas.nomeMusica, artista, album, ano, valor, genero from musicas "
             +   "JOIN carrinho on musicas.nomeMusica = carrinho.nomeMusica where carrinho.login =?";


        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setString(1,loga);

        System.out.println(stm.toString());

        rs = stm.executeQuery();
	LinkedList<Documento_Trecho> lista = new LinkedList<Documento_Trecho>();

	while (rs.next()) {
		Documento_Trecho tmp = new Documento_Trecho();
		tmp.setIdDocumento(rs.getInt("nomeMusica"));
		tmp.setIdTrecho(rs.getInt("artista"));
		
		lista.add(tmp);
        }
		return lista;
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

