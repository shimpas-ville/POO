import java.util.*;
public class CatalogoProduto {

    private List<Produto> catalogoProdutos;
    private List<ItemEstoque> itensEstoque;

    public CatalogoProduto() {
        catalogoProdutos = new ArrayList<>();
        itensEstoque = new ArrayList<>();
    }
    public Produto consulta(int codigo) {
        for (Produto produto : catalogoProdutos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public boolean cadastra(Produto produto, int quantidadeEmEstoque) {
        for (Produto p : catalogoProdutos) {
            if (p.getCodigo() == produto.getCodigo()) {
                return false;
            }
        }
        catalogoProdutos.add(produto);
        ItemEstoque item = new ItemEstoque(produto,quantidadeEmEstoque);
        itensEstoque.add(item);
        return true;
    }

    public Produto consultaQuantidadeEmEstoque(int codigo) {
        for (ItemEstoque item : itensEstoque) {
            if (item.getProduto().getCodigo() == codigo) {
                return item.getProduto();
            }
        }
        return null;
    }

    public void imprime() {
        for (ItemEstoque item : itensEstoque) {
            if(item.getQuantidade()>0) {
                Produto produto = item.getProduto();
                System.out.println("Item: " + produto.getDescricao());
                System.out.println("Código do produto: " + produto.getCodigo());
                System.out.println("Preço Unitário: R$" + produto.getPrecoUnitario());
                System.out.println("==========================");
            }else{
                Produto produto = item.getProduto();
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
