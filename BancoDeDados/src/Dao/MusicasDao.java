/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavoribes
 */
public class MusicasDao {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean addMusic(String nomemusica, String diretorio, int idartista) throws SQLException, ClassNotFoundException {
        con = ConectaBanco.conectabanco();
        String sql = "insert into musicas values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nomemusica);
            pst.setString(2, diretorio);
            pst.setInt(3, idartista);
            rs = pst.executeQuery();
            return rs.rowInserted();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }

    public boolean updateMusic(String nome, String diretorio, int idartista,int idmusica) throws SQLException, ClassNotFoundException {
        con = ConectaBanco.conectabanco();
        String sql = "update musicas set nomemusica = ?, diretorio = ?,idartista = ? where idmusica = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, diretorio);
            pst.setInt(5, idartista);
            pst.setInt(6, idmusica);
            rs = pst.executeQuery();
            return rs.rowUpdated();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }

    public boolean deleteMusic(int idmusica) throws SQLException, ClassNotFoundException {
        con = ConectaBanco.conectabanco();
        String sql = "delete from musicas where idmusica = ? ";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idmusica);
            rs = pst.executeQuery();
            return rs.rowDeleted();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }

    public ResultSet getMusica(String nomemusica) throws SQLException, ClassNotFoundException {

        con = ConectaBanco.conectabanco();
        String sql = "Select * from musicas where nomemusica LIKE ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nomemusica);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return null;
        }
    }
    
    public ResultSet getMusica(int idmusica) throws SQLException, ClassNotFoundException {

        con = ConectaBanco.conectabanco();
        String sql = "Select diretorio from musicas where idmusica = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idmusica);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return null;
        }
    }
}


