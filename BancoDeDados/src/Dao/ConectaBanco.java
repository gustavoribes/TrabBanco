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
public class ConectaBanco {
    
    public static Connection conectabanco() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc://nome_banco://host/banco_dados?user=usuario&password=password");
            return con;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return null;
        }
    }
}
