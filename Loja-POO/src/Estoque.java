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
                return false;
            }
        }
        itens.add(item);
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
                    catalogoProduto.cadastra(item.getProduto(), quantidade);
                }else if(item.getQuantidade()>0 && item.getQuantidade()<quantidade){
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
                for(int i = 0; i < quantidade;i++){
                    itens.add(item);
                }
                return true;
            }
        }
        return false;
    }

    public void Imprime() {
        for (ItemEstoque item : itens) {
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

}