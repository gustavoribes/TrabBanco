/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavoribes
 */
public class PlayerDao {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public String selectmusic(int id) throws SQLException, ClassNotFoundException {
        con = ConectaBanco.conectabanco();
        String sql = "Select diretorio from usuarios where id = ? and senha = ? ";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            return rs.getString(1);
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return null;
        }
    }
    
    
}
