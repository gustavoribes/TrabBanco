package Dao;

import java.sql.*;
import javax.swing.JOptionPane;
import View.UsuariodaSessao;

/**
 *
 * @author gustavoribes
 */
public class LoginDao {

    private String login;
    private String senha;

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public LoginDao(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean valida() throws SQLException, ClassNotFoundException {
        Connection con = ConectaBanco.conectabanco();
        String sql = "Select * from usuarios where login = ? and senha = ? ";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, this.login);
            pst.setString(2, this.senha);
            rs = pst.executeQuery();
            if (rs.next()) {                
                UsuariodaSessao.setId(rs.getInt(1));
                UsuariodaSessao.setNome( rs.getString(2));
                UsuariodaSessao.setLogin(rs.getString(3));
                UsuariodaSessao.setEmail(rs.getString(4));
                UsuariodaSessao.setNivel( rs.getInt(5));
                return true;
            } else {
                return false;
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }
}
