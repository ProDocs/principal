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
        Artefato artefato = (Artefato) object;
        String sql = "INSERT INTO ARTEFATOS (aprovado,bloqueado,conteudo,data_aprovacao,data_criacao,idAprovador,idArtefato,idAutor,idCategoria,tags,tipo,titulo,versao ) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";        
        
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setInt(1, artefato.getIdAprovador());
        stm.setInt(2, artefato.getIdArtefato());
        stm.setInt(3, artefato.getIdAutor());
        stm.setInt(4, artefato.getIdCategoria());
        stm.setString(5, artefato.getConteudo());
        stm.setString(6, artefato.getData_aprovacao());
        stm.setString(3, artefato.getData_criacao());
        stm.setString(4, artefato.getTitulo());
        stm.setInt(5, artefato.getTipo());
        stm.setFloat(6, artefato.getVersao());


        System.out.println(sql);
        stm.executeUpdate();
        System.out.println("Inserção ok!");
    
    }

    /* consulta no BD */
    @Override
    public Object read(Object key) throws SQLException
    {
             String nome = (String) key;

		String sql = "SELECT * FROM ARTEFATO WHERE idArtefato=?";
		PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
		stm.setString(1, nome);
                System.out.println(nome);
		ResultSet rs = stm.executeQuery();
                
		if (rs.next()) {
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
			return tmp;                      
		}

	return null;
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
    
    
     public List<Artefato> buscaConteudo(String conteudo) throws SQLException{
        int i = 0;
        String nome = conteudo;
        ResultSet rs;
        String sql = "SELECT * FROM ARTEFATO WHERE conteudo LIKE ?";

        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setString(1, "%" + nome + "%");

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
    
      public List<Artefato> buscaTrecho(String conteudo) throws SQLException{
        String nome = conteudo;
        ResultSet rs;
        String sql = "SELECT * FROM ARTEFATO WHERE conteudo LIKE ? "+
                     "AND tipo = 2 " +
                     "AND aprovado = 1 ";

        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setString(1, "%" + nome + "%");

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
        	Artefato a = (Artefato)object;

                String sql="UPDATE Artefato SET conteudo=?, data_aprovacao=?, data_criacao=?, tags=?, titulo=?, idAprovador=?, idArtefato=?, idAutor=?, idCategoria=?, tipo=?, versao=?, isAprovado=?, isBloqueado=?"
                        + " where titulo=?";

                PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

                stm.setString(1, a.getConteudo());
                stm.setString(2, a.getData_aprovacao());
                stm.setString(3, a.getData_criacao());
                stm.setString(4, a.getTags());
                stm.setString(5, a.getTitulo());
                stm.setInt(6, a.getIdAprovador());
                stm.setInt(7, a.getIdArtefato());
                stm.setInt(8, a.getIdAutor());
                stm.setInt(9, a.getIdCategoria());
                stm.setInt(10, a.getTipo());
                stm.setFloat(11, a.getVersao());
                stm.setBoolean(12, a.isAprovado());
                stm.setBoolean(13, a.isBloqueado());
                
                stm.setString(14, a.getTitulo());

                stm.executeUpdate();
    }

    /* exclusao no BD */
    @Override
    public void delete(Object object) throws SQLException
    {
        Artefato a = (Artefato)object;

        String sql = "DELETE FROM ARTEFATO WHERE titulo=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setString(1, a.getTitulo());

        stm.executeUpdate();
    }
    
}
