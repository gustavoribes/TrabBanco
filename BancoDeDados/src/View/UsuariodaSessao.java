/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author gustavoribes
 */

/*
 * Classe criada para que se possa autenticar permissões do usuario atravez da sua seção sendo assim,
 * fazendo somente uma consulta ao banco de dados e armazenando esses valores em variavel acessiveis 
 * atraves de getNOMEDAVARIAVEL
 * 
 */
public class UsuariodaSessao {
    private int id;  
    private String nome;    
    private String login;    
    private String email;  
    private int nivel; // define se ele é usuario comum ou adm do sistema 
    
    public UsuariodaSessao(int id, String nome,String login,String email,int nivel){
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.nivel = nivel;     
        
    } 

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public int getNivel() {
        return nivel;
    }
    
    
}
