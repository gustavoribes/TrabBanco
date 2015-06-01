package Dao;

import java.sql.*;
import Dao.ConectaBanco;
import javax.swing.JOptionPane;
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
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1 , this.login);            
            pst.setString(2 , this.senha);
            rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null,error);
            return false;
        }
   }
}
