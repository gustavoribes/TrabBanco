
package Controller;
import Dao.ConectaBanco;
import Dao.LoginDao;
import java.sql.SQLException;
/**
 *
 * @author gustavoribes
 */
public class LoginController {
    private String login;
    private String senha;
    
    public boolean login (String login, String senha) throws SQLException, ClassNotFoundException {
        this.login = login;
        this.senha = senha;
        LoginDao testalogin = new LoginDao(this.login, this.senha);
        if(testalogin.valida() == true){
            return true;
        }else{
            return false;
        }
    }
}
