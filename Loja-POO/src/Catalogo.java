import java.util.*;
public class Catalogo {

    private Stack<Produto> produtos;
    private Produto produto;

    public Catalogo(){
        produtos = new Stack<>();
    }
    public Produto consulta(int codigo) {
        for (Produto produto : produtos) {
            if(produto.getCodigo()==codigo){
                return produto;
            }
        }
        return null;
    }

    public boolean cadastra(Produto produto) {
        produtos.push(produto);
        return false;
    }

    public boolean remove(int codigo) {
        for (Produto produto : produtos) {
            if(produto.getCodigo()==codigo){
                produtos.remove(produto);
                return true;
            }
        }
        return false;
    }
}
