package automatizado.teste;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.LoginPO;

public class LoginTest extends BaseTest {
    
    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test //comando para identifar que método é um caso de teste
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaBrancos(){
        
        loginPage.inputEmail.sendKeys("");
        loginPage.inputSenha.sendKeys("");

        loginPage.buttonEntrar.click();
        String mensagem = loginPage.obterMensagemDeErro();

        Assert.assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");

    }

}
