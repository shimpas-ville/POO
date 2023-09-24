import java.util.*;
public class Estoque {

    private static Stack<ItemEstoque> itens;
    private Catalogo catalogo;

    public Estoque(Catalogo catalogo){
        itens=new Stack<>();
        this.catalogo = catalogo;
        this.itens = new Stack<>();
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

}