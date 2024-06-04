package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas PagesObjects.
 * Todas as pages devem ser herdadas desta classe
 */
public abstract class BasePO {
    
    /**Driver base que será usado pelas pages.
     * Ele permite a interação entre o script de teste e o browser que está sendo utilizado
    */
    protected WebDriver driver;


    /**
     * Construtor para a criação da fabrica de elementos (PageFactory)
     * @param driver Driver da página atual
     */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
