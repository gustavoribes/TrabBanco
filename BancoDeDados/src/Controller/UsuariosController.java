/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author gustavoribes
 */
public class UsuariosController {
//
//    private int id;
//    private String nome;
//    private String login;
//    private String email;
//    private String senha;
//    private int nivel;

    public boolean adduser(String nome, String login, String email, String senha, String confsenha, int nivel) {
        if (Integer.parseInt(senha) == Integer.parseInt(confsenha)) {
            
            return true;
        } else {
            return false;
        }
    }

}
