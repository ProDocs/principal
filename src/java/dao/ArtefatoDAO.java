/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Artefato;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Documento_Trecho;

/**
 *
 * @author ASUS
 */
public class ArtefatoDAO  implements Dao{
    
    private DataSource dataSource;

    public ArtefatoDAO() throws SQLException {
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

    public List<Artefato> readAll(String logado) throws SQLException{
        int i = 0;
        String loga = logado;
        ResultSet rs;
        String sql = "SELECT * FROM ARTEFATO";


        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setString(1,loga);

        System.out.println(stm.toString());

        rs = stm.executeQuery();
	LinkedList<Artefato> lista = new LinkedList<Artefato>();

	while (rs.next()) {
		Artefato tmp = new Artefato();
		tmp.setAprovado(rs.getBoolean("aprovado"));
                tmp.setBloqueado(rs.getBoolean("bloqueado"));     
                tmp.setConteudo(rs.getString("conteudo"));
                tmp.setData_aprovacao(rs.getString("data_aprovacao"));
                tmp.setData_criacao(rs.getString("data_criacao"));
                tmp.setIdAprovador(rs.getInt("idAprovador"));
                tmp.setIdArtefato(rs.getInt("idArtefato"));
                tmp.setIdAutor(rs.getInt("idAutor"));
                tmp.setIdCategoria(rs.getInt("idCategoria"));
                tmp.setTags(rs.getString("tags"));
                tmp.setTipo(rs.getInt("tipo"));
                tmp.setTitulo(rs.getString("titulo"));
                tmp.setVersao(rs.getFloat("versao"));
		
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
