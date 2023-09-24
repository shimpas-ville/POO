public class ItemVenda {
    private Produto produto;
    private double precoUnitario;
    private int quantidade;

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPrecoUnitario();
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

    public int getCodigo() {
        return produto.getCodigo();
    }

    public Produto getProduto() {
        return produto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

}

