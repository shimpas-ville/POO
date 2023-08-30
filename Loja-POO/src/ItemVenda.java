import java.util.Stack;

public class ItemVenda {

    private int codigo;
    private Produto produto;
    private double precoUnitarioCobrado;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade){
        this.produto=produto;
        this.quantidade=quantidade;
        produtos = new Stack<>();
        for(int i=0; i<quantidade; i++){
            produtos.push(produto);
        }
    }

    public double getValorItem() {
        return 0;
    }

    public int getCodigo() {
        return 0;
    }

    public Produto getProduto() {
        return null;
    }

    public double getPrecoUnitarioCobrado() {
        return 0;
    }

    public int getQuantidade() {
        return 0;
    }

}