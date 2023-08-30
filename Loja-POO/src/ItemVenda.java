import java.util.*;
public class ItemVenda {

    private Random rdm;
    private int codigo;
    private Produto produto;
    private double precoUnitarioCobrado;
    private int quantidade;
    Stack produtos;

    public ItemVenda(Produto produto, int quantidade){
        this.produto=produto;
        this.quantidade=quantidade;
        precoUnitarioCobrado=produto.getPrecoUnitario();
        rdm = new Random(1000000);
        codigo = rdm.nextInt();
        produtos = new Stack<>();
        for(int i=0; i<quantidade; i++){
            produtos.push(produto);
        }
    }

    public double getValorItem() {
        double valor = quantidade*precoUnitarioCobrado;
        return valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getPrecoUnitarioCobrado() {
        return precoUnitarioCobrado;
    }

    public int getQuantidade() {
        return quantidade;
    }

}