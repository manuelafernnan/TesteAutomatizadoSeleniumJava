package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automatizado.builder.ProdutoBuilder;

public class ProdutoPO extends BasePO {

    //Mapear elementos da pagina
    @FindBy(id = "btn-adicionar") 
    public WebElement buttonAdicionar;

    @FindBy(className = "nav-link")
    public WebElement linkVoltar;

    @FindBy(css = "div.modal-header>h4") //usando query selector no console para encontrar codigo (document.querySelector('div.modal-header>h4').textContent))
    public WebElement tituloModal;

    //elementos do modal
    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar") 
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair") 
    public WebElement buttonSair;

    @FindBy(id = "mensagem") 
    public WebElement spanMensagem;


    public ProdutoPO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    public void cadastrarProduto(
        String codigo, 
        String nome, 
        Integer quantidade, 
        Double valor, 
        String data){

        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade.toString()); //ToString convertendo numero para string
        escrever(inputValor, valor.toString()); 
        escrever(inputData, data);

        buttonSalvar.click();

    }



}
