import java.util.*;
public class CatalogoProduto {

    private List<ItemEstoque> itensEstoque;

    public CatalogoProduto() {
        itensEstoque = new ArrayList<>();
    }
    public Produto consulta(int codigo) {
        for (ItemEstoque item : itensEstoque) {
            if (item.getProduto().getCodigo() == codigo) {
                return item.getProduto();
            }
        }
        return null;
    }

    public boolean cadastra(Produto produto, int quantidadeEmEstoque) {
        ItemEstoque itemEstoque = new ItemEstoque(produto, quantidadeEmEstoque);
        for (ItemEstoque item: itensEstoque) {
            if(produto.getCodigo() == item.getCodigo()){
                itensEstoque.add(itemEstoque);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int codigo) {
        Iterator<ItemEstoque> iterator = itensEstoque.iterator();
        while (iterator.hasNext()) {
            ItemEstoque item = iterator.next();
            if (item.getProduto().getCodigo() == codigo) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean remove2(int codigo){
        boolean removido = false;
        for (ItemEstoque item : itensEstoque) {
            if(item.getCodigo()==codigo) {
                itensEstoque.remove(item);
                removido=true;
            }
        }
        return removido;
    }

    public void Imprime() {
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
