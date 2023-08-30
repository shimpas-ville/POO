import java.util.*;
public class ItemEstoque {

    private Produto produto;
    private int quantidade;
    private Estoque estoque;
    Stack<Produto> produtos;

    public ItemEstoque(Produto produto, int quantidade){
        this.produto=produto;
        this.quantidade=quantidade;
        produtos = new Stack<>();
        for(int i=0; i<quantidade; i++){
            produtos.push(produto);
        }
    }
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

}

