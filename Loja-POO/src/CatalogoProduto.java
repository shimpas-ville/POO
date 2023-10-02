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

//        for (Produto p : catalogoProdutos) {
//            if (p.getCodigo() == produto.getCodigo()) {
//            }
//        }
        for (ItemEstoque item : itensEstoque) {
            if (item.getProduto().getCodigo() == produto.getCodigo()) {
                item.setQuantidadeEmEstoque(item.getQuantidade()+quantidadeEmEstoque);
                return true;
            }
        }
        ItemEstoque item = new ItemEstoque(produto,quantidadeEmEstoque);
        catalogoProdutos.add(produto);
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
            Produto produto = item.getProduto();
            System.out.println("Item: " + produto.getDescricao());
            System.out.println("Código do produto: " + produto.getCodigo());
            System.out.println("Preço Unitário: R$" + produto.getPrecoUnitario());

            if (item.getQuantidade() > 0) {
                System.out.println("==========================");
            } else {
                System.out.println("-X- ESGOTADO -X-");
            }
        }
    }

    public List<ItemEstoque> getItensEstoque() {
        return itensEstoque;
    }

    public boolean baixaCatalogo(int codigo, int quantidade) {
        boolean sucesso = false;

        for (ItemEstoque item : itensEstoque) {
            if (item.getCodigo() == codigo) {
                if (item.getQuantidade() >= quantidade) {
                    item.setQuantidadeEmEstoque(item.getQuantidade() - quantidade);
                    sucesso = true;
                } else if (item.getQuantidade() > 0 && item.getQuantidade() < quantidade) {
                    item.setQuantidadeEmEstoque(0);
                    sucesso = true;
                }
                break;
            }
        }

        return sucesso;
    }

    public boolean repoeCatalogo(int codigo, int quantidade) {
        for (ItemEstoque item : itensEstoque) {
            if(item.getCodigo() == codigo){
                item.setQuantidadeEmEstoque(item.getQuantidade()+quantidade);
                return true;
            }
        }
        return false;
    }

}
