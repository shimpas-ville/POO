import java.util.*;
public class Catalogo {

    private List<Produto> produtos;

    public Catalogo(){
        produtos = new ArrayList<>();
    }
    public Produto consulta(int codigo) {
        for (Produto produto : produtos) {
            if(produto.getCodigo()==codigo){
                return produto;
            }
        }
        return null;
    }

    public void cadastra(Produto produto) {
        produtos.add(produto);
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

    public void Imprime(){
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public List<Produto> getProdutos(){
        return produtos;
    }
}
