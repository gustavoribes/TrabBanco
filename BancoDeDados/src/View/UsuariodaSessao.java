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
    private static int id;  
    private static String nome;    
    private static String login;    
    private static String email;  
    private static int nivel; // define se ele é usuario comum ou adm do sistema 
    
    public UsuariodaSessao(int id, String nome,String login,String email,int nivel){
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.nivel = nivel;     
        
    } 

    public static void setId(int id) {
        UsuariodaSessao.id = id;
    }

    public static void setNome(String nome) {
        UsuariodaSessao.nome = nome;
    }

    public static void setLogin(String login) {
        UsuariodaSessao.login = login;
    }

    public static void setEmail(String email) {
        UsuariodaSessao.email = email;
    }

    public static void setNivel(int nivel) {
        UsuariodaSessao.nivel = nivel;
    }

    static int getId() {
        return id;
    }

    static String getNome() {
        return nome;
    }

    static String getLogin() {
        return login;
    }

    static String getEmail() {
        return email;
    }

    static int getNivel() {
        return nivel;
    }
    
    
}
