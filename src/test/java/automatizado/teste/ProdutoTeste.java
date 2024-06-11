package automatizado.teste;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.LoginPO;
import automatizado.page.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Realizar testes na ordem
public class ProdutoTeste extends BaseTest {

    private static LoginPO loginPage; //adicionando tela de login para instanciar e realizar o login antes de ir para tela de prdutos
    private static ProdutoPO controleProdutoPage;

    //metodo para inicar a pagina de produtos
    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver); //instanciando o login
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ProdutoPO(driver);
        Assert.assertEquals(controleProdutoPage.obterTituloPagina(),"Controle de Produtos");
    }
    
    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controleProdutoPage.buttonAdicionar.click(); //clicando no botao
        //TODO: Remover esse clique assim que o sistema for corrigido
        controleProdutoPage.buttonAdicionar.click();
        
        String titulo = controleProdutoPage.tituloModal.getText();

        Assert.assertEquals("Produto", titulo);

        controleProdutoPage.buttonSair.click();
         //TODO: Remover esse clique assim que o sistema for corrigido
        controleProdutoPage.buttonSair.click();
    }

    // @Test
    // public void TC002_nãoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        
    //     controleProdutoPage.buttonAdicionar.click();

    //     controleProdutoPage.cadastrarProduto("0001", "Camel", 20, 10.00, "");

    //     //aqui vamos capturar a mensagem de erro
    //     String mensagem = controleProdutoPage.spanMensagem.getText();

    //     Assert.assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
        

    // }

    @Test
    public void TC002_nãoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        
        String mensagem = "Todos os campos são obrigatórios para o cadastro!"; 
        controleProdutoPage.buttonAdicionar.click();

        //Aqui cria o objeto para adicionar na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder( controleProdutoPage);
       
        //Aqui ele adiciona as informações na tela
        produtoBuilder
        .adicionarData("")
        .builder();

        Assert.assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        produtoBuilder
        .adicionarNome("")
        .builder();

        Assert.assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        produtoBuilder
        .adicionarQuantidade(null)
        .builder();

        Assert.assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());
   
        produtoBuilder
        .adicionarValor(null)
        .builder();

        Assert.assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());
        
        controleProdutoPage.buttonSair.click();
    }

    
}
