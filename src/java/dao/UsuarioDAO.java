package dao;
import model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements Dao {

    private DataSource dataSource;

    public UsuarioDAO() throws SQLException {
        dataSource = new DataSource();
    }
    

    /* inserção no BD */
    @Override
    public void create(Object object) throws SQLException {

        System.out.println("Dao CREATE");
        
        try{
            
            Usuario usuario = (Usuario) object;
            String sql = "insert into usuario (nome, sobrenome,  email, login, senha) "
                    + "values(?,?,?,?,?)";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getSobrenome());
            stm.setString(3, usuario.getEmail());
            stm.setString(4, usuario.getLogin());
            stm.setString(5, usuario.getSenha());    

            stm.executeUpdate();
            System.out.println(stm.toString());
            System.out.println("Insersao de usuario ok!");
        
        }catch(Exception e){
            e.printStackTrace();
        }

        
    }
    
    /* remoçao no BD */
    @Override
    public void delete(Object object) throws SQLException {

        Usuario user = (Usuario) object;
        String sql = "delete from usuario where idUsuario=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setInt(1, user.getIdUsuario());
        stm.executeUpdate();
        System.out.println("Usuario Excluido");

    }
    
     /* consulta no BD */
    @Override
    public Object read(Object key) throws SQLException {

        int cod_user = (Integer) key;
        ResultSet rs;
        String sql = "select * from usuario where idUsuario=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setLong(1, cod_user);
        rs = stm.executeQuery();

        if (rs.next()) {
            Usuario user = new Usuario();
            user.setIdUsuario(rs.getInt(1));
            user.setNome(rs.getString(2));
            user.setSobrenome(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setLogin(rs.getString(5));
            user.setSenha(rs.getString(6));
       
            return user;
        }
        return null;
    }
    
    
    /******************************Metodos Customizados*********************************/

    
    public int cadastrarUsuario(Usuario usuario){
    
        try{
  
            create(usuario);

            int idUsuario = loginExistente(usuario.getLogin());

            return idUsuario;
        
        }
        catch(Exception e){
            System.out.println("Não encontrou o novo usuário");
            e.printStackTrace();
        
        }
        return 0;
    }
    
    

    public int loginExistente(String login)throws SQLException{
        
        int pkUser = 0;
        
        try{
            String sql = "select idUsuario from usuario where login=?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs;
            rs = stm.executeQuery();
            
            if(rs.next())
            pkUser = rs.getInt("idUsuario");
            
            return pkUser;
            

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return pkUser;
    }

    public Usuario readUserLoginPassWord(Object object) throws SQLException {
        Usuario userObject = (Usuario)object;

        String sql = "select * from usuario where login=? and senha=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        System.out.println("Consultou 0");
        stm.setString(1, userObject.getLogin());
        stm.setString(2,userObject.getSenha());
        System.out.println("Consultou 1");
        ResultSet rs;
        rs = stm.executeQuery();

        System.out.println(stm.toString());

        if (rs.next()) {
            System.out.println("Encontrou usuario");
            Usuario user = new Usuario();
            user.setIdUsuario(rs.getInt(1));
            user.setNome(rs.getString(2));
            user.setSobrenome(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setLogin(rs.getString(5));
            user.setSenha(rs.getString(6));
           
            return user;
        }

        return null;
    }


    @Override
    public void update(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    public void desbloquearUsuario(Object object) throws SQLException {
        Usuario user = (Usuario) object;
        String sql = "update usuario set bloqueado = 0  where idUsuario=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setInt(1, user.getIdUsuario());
        stm.executeUpdate();
        System.out.println("Usuario Desbloqueado");
    }
}
