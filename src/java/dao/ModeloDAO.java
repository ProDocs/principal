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
import model.Modelo;

/**
 *
 * @author ASUS
 */
public class ModeloDAO implements Dao{
    
    private DataSource dataSource;

    public ModeloDAO() throws SQLException {
        dataSource = new DataSource();
    }
    
        /* inserao no BD */
    @Override
    public void create(Object object) throws SQLException
    {
            
        Modelo modelo = (Modelo) object;
        String sql = "INSERT INTO MODELO (aprovado,bloqueado,idCategoria,idModelo,nome,versao) " +
                "values(?,?,?,?,?,?)";        
        
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setBoolean(1, modelo.isAprovado());
        stm.setBoolean(2, modelo.isBloqueado());
        stm.setInt(3, modelo.getIdCategoria());
        stm.setInt(4, modelo.getIdModelo());
        stm.setString(6, modelo.getNome());
        stm.setFloat(3, modelo.getVersao());


        System.out.println(sql);
        stm.executeUpdate();
        System.out.println("Inserção ok!");
    }

    /* consulta no BD */
    @Override
    public Object read(Object key) throws SQLException
    {
                String nome = (String) key;

		String sql = "SELECT * FROM MODELO WHERE idModelo=?";
		PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
		stm.setString(1, nome);
                System.out.println(nome);
		ResultSet rs = stm.executeQuery();
                
		if (rs.next()) {
			Modelo tmp = new Modelo();
                        tmp.setAprovado(rs.getBoolean("aprovado"));
                        tmp.setBloqueado(rs.getBoolean("bloqueado"));     
                        tmp.setIdCategoria(rs.getInt("idCategoria"));
                        tmp.setIdModelo(rs.getInt("idModelo"));
                        tmp.setNome(rs.getString("nome"));
                        tmp.setVersao(rs.getFloat("versao"));
			return tmp;                      
		}

	return null;
    }

    public List<Modelo> buscaTudo(String conteudo) throws SQLException{
        int i = 0;
        String nome = conteudo;
        ResultSet rs;
        String sql = "SELECT * FROM Modelo";

        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        //stm.setString(1, "%" + nome + "%");

        System.out.println(stm.toString());

        rs = stm.executeQuery();
	LinkedList<Modelo> lista = new LinkedList<Modelo>();

	while (rs.next()) {
			Modelo tmp = new Modelo();
                        tmp.setAprovado(rs.getBoolean("aprovado"));
                        tmp.setBloqueado(rs.getBoolean("bloqueado"));     
                        tmp.setIdCategoria(rs.getInt("idCategoria"));
                        tmp.setIdModelo(rs.getInt("idModelo"));
                        tmp.setNome(rs.getString("nome"));
                        tmp.setVersao(rs.getFloat("versao")); 
		
		lista.add(tmp);
        }
		return lista;
    }
    
    /* atualizaao no BD */
    @Override
    public void update(Object object) throws SQLException
    {
         	Modelo a = (Modelo)object;

                String sql="UPDATE Modelo SET aprovado=?, bloqueado=?, nome=?, idCategoria=?, versao=?"
                        + " where idModelo=?";

                PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

                stm.setBoolean(1, a.isAprovado());
                stm.setBoolean(2, a.isBloqueado());
                stm.setString(3, a.getNome());
                stm.setInt(4, a.getIdCategoria());
                stm.setFloat(5, a.getVersao());


                
                stm.setInt(6, a.getIdModelo());

                stm.executeUpdate();       
    }

    /* exclusao no BD */
    @Override
    public void delete(Object object) throws SQLException
    {
        Modelo a = (Modelo)object;

        String sql = "DELETE FROM ARTEFATO WHERE idModelo=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setInt(1, a.getIdModelo());

        stm.executeUpdate();
    }
    
}

