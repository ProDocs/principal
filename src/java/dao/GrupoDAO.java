/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Grupo;
import model.dto.FiltroGruposUsuarioDTO;
import model.dto.PerfilUsuarioGrupoDTO;

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
        
        List<String> teste = new ArrayList<String>();
        
        
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
    
    public List<Grupo> listarTodosGrupos() throws SQLException{
    
        List<Grupo> grupos = new ArrayList<Grupo>();
        
        try{
            
            ResultSet rs;
            String sql;
            sql = ("Select * from grupo");
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            
            rs = stm.executeQuery();
            
            while(rs.next()){
               
               Grupo grupo = new Grupo();
               
               grupo.setDescricao(rs.getString("descricao"));
               grupo.setIdGrupo(rs.getInt("idGrupo"));
               grupo.setNome(rs.getString("nome"));
               
               grupos.add(grupo);

            }
            
        }catch(Exception e){}
        
        return grupos;
    }
    
    public List<PerfilUsuarioGrupoDTO> listarGrupos(FiltroGruposUsuarioDTO idUsuario) throws SQLException{
    
        List<PerfilUsuarioGrupoDTO> grupos = new ArrayList<PerfilUsuarioGrupoDTO>();
        
        try{
            ResultSet rs;
            String sql;
            sql = ("Select distinct g.idGrupo, g.nome, gu.perfil, gu.aprovado "+
                            "from grupo g, grupo_usuario gu, usuario u "+ 
                            "where g.idGrupo = gu.idGrupo and gu.idUsuario = ?");

            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            stm.setInt(1, idUsuario.getIdUsuario());
            rs = stm.executeQuery();

            while (rs.next()) {
            PerfilUsuarioGrupoDTO grupo = new PerfilUsuarioGrupoDTO();

            grupo.setPerfil(rs.getString("perfil"));
            grupo.setIdGrupo(rs.getInt("idGrupo"));
            grupo.setNome(rs.getString("nome"));
            grupo.setAprovado(rs.getBoolean("aprovado"));

            grupos.add(grupo);
 
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("retornou " + grupos.size() + " grupos");
        return grupos;
    }
    
}

