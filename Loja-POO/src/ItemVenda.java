import java.util.Enumeration;

public class ItemVenda {
    private int numero;
    private Produto produto;
    private double precoUnitario;
    private int quantidade;

    public ItemVenda(int numero, Produto produto, int quantidade) {
        this.numero = numero;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPrecoUnitario();
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorItem() {
        return quantidade * precoUnitario;
    }

    public double getDesconto() {
        if (precoUnitario > 250) {
            return quantidade * precoUnitario * 0.1;
        } else {
            return 0;
        }
    }

    public double getImposto() {
        return quantidade * precoUnitario * 0.25;
    }

    public String getDescricao() {
        return produto.getDescricao();
    }

    public int getNumero() {
        return numero;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getPrecoUnitarioCobrado() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

}

