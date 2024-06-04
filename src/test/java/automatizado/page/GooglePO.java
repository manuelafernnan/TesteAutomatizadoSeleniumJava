package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(name = "q")
    public WebElement inputPesquisa;
    
    @FindBy(className = "RES9jf")
    public WebElement divResultadoPesquisa;

    /**
     * Construtor para a criação da página do Google
     * @param driver Driver da pagina do Google.
     */
    public GooglePO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
    /**
     * Metodo que irá efetuar uma pesquisa no google baseando-se no texto informado
     * @param texto Texto a ser pesquisado
     */
    public void pesquisar (String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**
     * Metodo que retorna o resultado da pesquisa
     * @return Retorna o resultado da pesquisa
     */
    public String obterResultadoDaPesquisa(){
        return divResultadoPesquisa.getText();
    }

}
