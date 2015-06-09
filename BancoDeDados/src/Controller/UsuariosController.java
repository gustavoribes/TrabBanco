/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UsuariosDao;
import java.sql.SQLException;

/**
 *
 * @author gustavoribes
 */
public class UsuariosController {
    
    public boolean adduser(String nome, String login, String email, String senha, String confsenha, int nivel) throws SQLException, ClassNotFoundException {
        if (Integer.parseInt(senha) == Integer.parseInt(confsenha)) {
            UsuariosDao user = new UsuariosDao();
            return user.adduser(nome, login, senha, email, nivel);
        } else {
            return false;
        }
    }
    
    public boolean updateuser(String nome, String login, String email, String senha, int nivel) throws SQLException, ClassNotFoundException {
        UsuariosDao user = new UsuariosDao();
        return user.updateuser(nome, login, senha, email, nivel, nivel);
    }
    
    public boolean deleteuser(int id) throws SQLException, ClassNotFoundException {
        UsuariosDao user = new UsuariosDao();
        return user.deleteuser(id);
    }
}
