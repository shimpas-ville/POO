public class ItemEstoque {
    private Produto produto;
    private int quantidade;
    private int codigo;

    public ItemEstoque(Produto produto, int quantidadeEmEstoque) {
        this.produto = produto;
        this.quantidade = quantidadeEmEstoque;
        this.codigo = produto.getCodigo();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setQuantidadeEmEstoque(int novaQuantidade) {

        quantidade = novaQuantidade;
    }
}

