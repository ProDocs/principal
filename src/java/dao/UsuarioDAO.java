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

        Usuario usuario = (Usuario) object;
        String sql = "insert into usuario (nome, sobrenome,  email, login, senha, bloqueado) "
                + "values(?,?,?,?,?,?)";

        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);

        stm.setString(1, usuario.getNome());
        stm.setString(2, usuario.getSobrenome());
        stm.setString(3, usuario.getEmail());
        stm.setString(4, usuario.getLogin());
        stm.setString(5, usuario.getSenha());    
        stm.setBoolean(6, usuario.isBloqueado());
       
      

        stm.executeUpdate();
        System.out.println(stm.toString());
        System.out.println("Insersao de usuario ok!");
    }

    @Override
    public void delete(Object object) throws SQLException {

        Usuario user = (Usuario) object;
        String sql = "delete from usuario where idUsuario=?";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setInt(1, user.getIdUsuario());
        stm.executeUpdate();
        System.out.println("Usuario Excluido");

    }

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
            user.setBloqueado(rs.getBoolean(7));
       
            return user;
        }
        return null;
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
            user.setLogin(rs.getString(2));
            user.setSenha(rs.getString(3));
            user.setNome(rs.getString(4));
            user.setEmail(rs.getString(5));
            user.setSobrenome(rs.getString(6));
            user.setBloqueado(rs.getBoolean(7));
           
            return user;
        }

        return null;
    }

   /* public void update(Object object) throws SQLException {
        Usuario user = (Usuario) object;

        String sql = "update usuario set "
                + "login=?,senha=?, nome=?, email=?, sobrenome=?, endereco=?, cidade=?, estado=?, tel=?, tipo_user=?, status=? "
                + "where cod_user=?";

        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setString(1, user.getLogin());
        stm.setString(2, user.getSenha());
        stm.setString(3, user.getNome());
        stm.setString(4, user.getEmail());
        stm.setString(5, user.getSexo());
        stm.setString(6, user.getEndereco());
        stm.setString(7, user.getCidade());
        stm.setString(8, user.getEstado());
        stm.setString(9, user.getTel());
        stm.setInt(10, user.getTipo_user());
        stm.setInt(11, user.getStatus());
        stm.setInt(12, user.getCod_user());

        stm.executeUpdate();

        System.out.println("Atualizacao OK");
    } */

     /*   public void updateUser(Usuario userLogado, Usuario userEdit) throws SQLException {


        String sql = "update usuario set "
                + "senha=?, email=?, endereco=?, tel=?"
                + "where cod_user=?";

        PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
        stm.setString(1, userEdit.getSenha());
        stm.setString(2, userEdit.getEmail());
        stm.setString(3, userEdit.getEndereco());
        stm.setString(4, userEdit.getTel());
        stm.setInt(5, userLogado.getCod_user());

        stm.executeUpdate();

            System.out.println(stm.toString());

        System.out.println("Atualizacao OK - updateUser");
    }*/

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
