import java.util.*;
public class ItemEstoque {
    private int codigo;
    private Produto produto;
    private int quantidadeEmEstoque;

    public ItemEstoque(Produto produto, int quantidadeEmEstoque){
        this.produto = produto;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        codigo = produto.getCodigo();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public int getCodigo() {
        return codigo;
    }
}

