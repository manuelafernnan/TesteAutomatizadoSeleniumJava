package automatizado.builder;

import automatizado.page.ProdutoPO;


/**
 * Classe que sabe construir ou adicionar um produto na tela
 */
public class ProdutoBuilder {
    
    public String codigo = "0001";
    public String nome = "Produto Padrão";
    public Integer quantidade = 1;
    public Double valor = 1.00;
    public String data = "01/01/2024";

    private ProdutoPO produtoPO;

    /**
     * Construtor do ProdutoBuilder que recebe a pagina de controle de produtos
     * @param produtoPO
     */
    public ProdutoBuilder (ProdutoPO produtoPO){
        this.produtoPO = produtoPO;

    }

    //CRIAÇÃO DOS METODOS QUE ADICIONAM INFO NOS INPUTS  
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }
 
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /**
     * Metodo que constroi o produto, ou seja, adiciona o produto pela tela de cadastro de produtos,
     */
    public void builder(){

        produtoPO.escrever(produtoPO.inputCodigo, codigo);
        produtoPO.escrever(produtoPO.inputNome, nome);
        produtoPO.escrever(produtoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : ""); //? se ... for diferente de ... : senao ...
        produtoPO.escrever(produtoPO.inputData, data);

        produtoPO.buttonSalvar.click();
    }
}
