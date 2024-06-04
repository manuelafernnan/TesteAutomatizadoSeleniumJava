package automatizado.teste;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;

public class GoogleTest extends BaseTest {
   
    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        googlePage = new GooglePO(driver);
    }

    @Test //comando para identifar que método é um caso de teste
    public void TC001_deveSerPossivelPesquisarNoGoogleBatataFrita(){
        
        //googlePage.inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);//encontrar o elemento (busca do google)
        googlePage.pesquisar("Batata frita");

        //executando   
        String resultado = googlePage.obterResultadoDaPesquisa(); //getText pra retornar o que há no elemento

        //válidar resultado
        Assert.assertTrue(resultado, resultado.contains("Receitas"));

    }

}
