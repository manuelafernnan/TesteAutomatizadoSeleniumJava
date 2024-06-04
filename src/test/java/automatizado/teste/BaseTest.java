package automatizado.teste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 /** 
     * Page Object Model (ou POM como também é chamado) nos permite criar um repositório 
     * de objetos com elementos contidos numa página Web. Sob este modelo, para cada página,
     * deve haver uma classe correspondente.  
    **/

public abstract class BaseTest {
     
    protected static WebDriver driver; //webdriver inicia o navegador para o teste
    private static final String URL_BASE = "file:///C:/Users/manue/OneDrive/%C3%81rea%20de%20Trabalho/testes%20automatizados/CURSO%20UDEMY/sistema/login.html" ; //private final torna constante imutavel
    private static final String CAMINHO_DRIVER = "C:/Program Files/chromedriver-win64/chromedriver.exe" ; //crtl+D seleciona todos os iten iguais na linha

    @BeforeClass //estou dizendo que essa classe vai ser chamada antes de qualquer metodo de teste
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER); //dizer caminhos de propriedades especifica
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //após o navegador abrir eu quero gerenciar ele e que a janela abra maximizada
        driver.get(URL_BASE); //chamar a URL
    }

    @AfterClass //estou dizendo que essa classe vai ser chamada no final de todos os testes 
    public static void finalizar(){
        driver.quit(); //fecha navegador
    }
    
}
