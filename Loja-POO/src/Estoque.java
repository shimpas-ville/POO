import java.util.*;
public class Estoque {

    private static ArrayList<ItemEstoque> itens;
    private CatalogoProduto catalogoProduto;

    public Estoque(CatalogoProduto catalogoProduto){
        itens = new ArrayList<>();
        this.catalogoProduto = catalogoProduto;
    }

    public boolean insereProduto(ItemEstoque item){
        for (ItemEstoque itemEstoque: itens) {
            if(itemEstoque.getCodigo() == item.getCodigo()){
                int quantidade = itemEstoque.getQuantidade();
                itemEstoque.setQuantidadeEmEstoque(itemEstoque.getQuantidade()+quantidade);
                return true;
            }
        }
        itens.add(item);
        catalogoProduto.cadastra(item.getProduto(), 0);
        return true;
    }

    public static int getQuantidade(int codigo) {
        for (ItemEstoque item : itens) {
            if(item.getProduto().getCodigo()==codigo){
                return item.getQuantidade();
            }
        }
        return 0;
    }

    public boolean baixaEstoque(int codigo, int quantidade) {
        boolean sucesso = false;

        for (ItemEstoque item : itens) {
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


    public boolean repoeEstoque(int codigo, int quantidade) {
        for (ItemEstoque item : itens) {
            if(item.getCodigo() == codigo){
                item.setQuantidadeEmEstoque(item.getQuantidade()+quantidade);
                return true;
            }
        }
        return false;
    }

    public void imprime() {
        for (ItemEstoque item : itens) {
            if(item.getQuantidade()>0) {
                Produto produto = item.getProduto();
                System.out.println("Item: " + produto.getDescricao());
                System.out.println("Código do produto: " + produto.getCodigo());
                System.out.println("Preço Unitário: R$" + produto.getPrecoUnitario());
                System.out.println("Quantidade em estoque: " + item.getQuantidade());
                System.out.println("==========================");
            }else{
                Produto produto = item.getProduto();
                System.out.println("Item: " + produto.getDescricao());
                System.out.println("Código do produto: " + produto.getCodigo());
                System.out.println("-X- ESGOTADO -X-");
            }
        }
    }

}