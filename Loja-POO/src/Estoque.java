import java.util.*;
public class Estoque {

    private static Stack<ItemEstoque> itens;
    private Catalogo catalogo;

    public Estoque(Catalogo catalogo){
        itens=new Stack<>();
        this.catalogo = catalogo;
        //this.itens = new Stack<>();
    }

    public void add(ItemEstoque item1){
        itens.push(item1);
    }

    public static int getQuantidade(int codigo) {
        for (ItemEstoque item : itens) {
            if(item.getProduto().getCodigo()==codigo){
                return item.getQuantidadeEmEstoque();
            }
        }
        return 0;
    }

    public boolean baixaEstoque(int codigo, int quantidade) {
        boolean sucesso = false;

        for (ItemEstoque item : itens) {
            if (item.getCodigo() == codigo) {
                if (item.getQuantidadeEmEstoque() >= quantidade) {
                    item.setQuantidadeEmEstoque(item.getQuantidadeEmEstoque() - quantidade);
                    sucesso = true;
                    catalogo.cadastra(item.getProduto(), quantidade);
                }else if(item.getQuantidadeEmEstoque()>0 && item.getQuantidadeEmEstoque()<quantidade){
                    item.setQuantidadeEmEstoque(0);
                    sucesso = true;
                }
                break;
            }
        }

        return sucesso;
    }

    public void repoeEstoque(int codigo, int quantidade) {
        for (ItemEstoque item : itens) {
            if(item.getCodigo()==codigo){
                for(int i=0; i<quantidade;i++){
                    itens.push(item);
                }
            }
        }
    }

    public void Imprime() {
        for (ItemEstoque item : itens) {
            if(item.getQuantidadeEmEstoque()>0) {
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