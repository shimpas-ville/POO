import java.util.*;
public class CatalogoProduto {

    private List<Produto> catalogoProdutos;
    private List<ItemEstoque> itensEstoque;

    public CatalogoProduto() {
        catalogoProdutos = new ArrayList<>();
    }
    public Produto consulta(int codigo) {
        for (Produto produto : catalogoProdutos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public boolean cadastra(Produto produto) {
        for (Produto p : catalogoProdutos) {
            if (p.getCodigo() == produto.getCodigo()) {
                return false;
            }
        }
        catalogoProdutos.add(produto);
        return true;
    }

    private int consultaQuantidadeEmEstoque(int codigo) {
        for (ItemEstoque item : itensEstoque) {
            if (item.getProduto().getCodigo() == codigo) {
                return item.getQuantidade();
            }
        }
        return 0;
    }

    public void imprime() {
        for (Produto produto : catalogoProdutos) {
            int quantidadeEmEstoque = consultaQuantidadeEmEstoque(produto.getCodigo());
            if (quantidadeEmEstoque > 0) {
                System.out.println("Item: " + produto.getDescricao());
                System.out.println("Código do produto: " + produto.getCodigo());
                System.out.println("Preço Unitário: R$" + produto.getPrecoUnitario());
                System.out.println("Quantidade em Estoque: " + quantidadeEmEstoque);
                System.out.println("==========================");
            } else {
                System.out.println("Item: " + produto.getDescricao());
                System.out.println("Código do produto: " + produto.getCodigo());
                System.out.println("-X- ESGOTADO -X-");
            }
        }
    }

    public List<ItemEstoque> getItensEstoque() {
        return itensEstoque;
    }
}
