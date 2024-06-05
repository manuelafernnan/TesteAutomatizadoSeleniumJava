package automatizado.teste;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Realizar testes na ordem
public class LoginTest extends BaseTest {
    
    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test //comando para identifar que método é um caso de teste
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaBrancos(){
        
        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagemDeErro();

        Assert.assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test 
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia(){
        
        loginPage.executarAcaoDeLogar("teste", "");
        String mensagem = loginPage.obterMensagemDeErro();

        Assert.assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");

    }

    
    @Test 
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){
        
        loginPage.executarAcaoDeLogar("", "teste");
        String mensagem = loginPage.obterMensagemDeErro();

        Assert.assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test 
    public void TC004_naoDeveLogarNoSistemaComEmailESenhaIncorretos(){
        
        loginPage.executarAcaoDeLogar("teste", "teste");
        String mensagem = loginPage.obterMensagemDeErro();

        Assert.assertEquals(mensagem,"E-mail ou senha inválidos");

    }

    @Test 
    public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaIncorreta(){
        
        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");
        String mensagem = loginPage.obterMensagemDeErro();

        Assert.assertEquals(mensagem,"E-mail ou senha inválidos");

    }

    @Test 
    public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta(){
        
        loginPage.executarAcaoDeLogar("teste", "admin@123");
        String mensagem = loginPage.obterMensagemDeErro();

        Assert.assertEquals(mensagem,"E-mail ou senha inválidos");

    }

    @Test 
    public void TC007_DeveLogarNoSistemaComEmailESenhaCorretos(){
        
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        
        Assert.assertEquals(loginPage.obterTituloPagina(),"Controle de Produtos");

    }


}
