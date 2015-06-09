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
public class UsuariosDao {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean adduser(String nome, String login, String senha, String email, int nivel) throws SQLException, ClassNotFoundException {
        con = ConectaBanco.conectabanco();
        String sql = "insert into usuarios values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, login);
            pst.setString(3, senha);
            pst.setString(4, email);
            pst.setInt(5, nivel);
            rs = pst.executeQuery();
            return rs.rowInserted();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }

    public boolean updateuser(String nome, String login, String senha, String email, int nivel, int id) throws SQLException, ClassNotFoundException {
        con = ConectaBanco.conectabanco();
        String sql = "update usuarios set nome = ?, login = ?,senha = ? , email = ?, nivel = ? where id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, login);
            pst.setString(3, senha);
            pst.setString(4, email);
            pst.setInt(5, nivel);
            pst.setInt(6, id);
            rs = pst.executeQuery();
            return rs.rowUpdated();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }

    public boolean deleteuser(int id) throws SQLException, ClassNotFoundException {
        con = ConectaBanco.conectabanco();
        String sql = "delete from usuarios where id =? ";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            return rs.rowDeleted();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }

    public ResultSet getuser(String nome) throws SQLException, ClassNotFoundException {

        con = ConectaBanco.conectabanco();
        String sql = "Select * from usuarios where nome LIKE ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return null;
        }
    }

}
