package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    /**
     * Mapeando os elementos da tela de login.
     */
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id = "mensagem")
    public WebElement mensagemErro;

    /**
     * Construtor padrão para criação de uma nova instancia da pagina de login.
     * @param driver Driver da página de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
}
