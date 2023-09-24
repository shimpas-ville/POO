import java.util.*;
public class Catalogo {

    private List<ItemEstoque> itensEstoque;

    public Catalogo() {
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

    public void cadastra(Produto produto, int quantidadeEmEstoque) {
        ItemEstoque itemEstoque = new ItemEstoque(produto, quantidadeEmEstoque);
        itensEstoque.add(itemEstoque);
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

    public void Imprime() {
        for (ItemEstoque item : itensEstoque) {
            Produto produto = item.getProduto();
            System.out.println("Item: " + produto.getDescricao());
            System.out.println("Código do produto: " + produto.getCodigo());
            System.out.println("Preço Unitário: R$" + produto.getPrecoUnitario());
            System.out.println("==========================");
        }
    }

    public List<ItemEstoque> getItensEstoque() {
        return itensEstoque;
    }
}
