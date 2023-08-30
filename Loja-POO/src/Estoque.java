import java.util.*;
public class Estoque {

    private Stack<ItemEstoque> itens;

    public Estoque(){
        itens=new Stack<>();
    }

    public void add(ItemEstoque item1){
        itens.push(item1);
    }

    public int getQuantidade(int codigo) {
        for (ItemEstoque item : itens) {
            if(item.getProduto().getCodigo()==codigo){
                return item.getQuantidade();
            }
        }
        return 0;
    }

    public boolean baixaEstoque(int codigo, int quantidade) {
        return false;
    }

    public boolean repoeEstoque(int codigo, int quantidade) {
        return false;
    }

}