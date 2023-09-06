import java.util.*;
public class Catalogo {

    private List<Produto> produtos;
    private Produto produto;

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

    public boolean cadastra(Produto produto) {
        produtos.add(produto);
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

    public void Imprime(){
        for (Produto p : produtos) {
            System.out.println(p + " : " + p.getCodigo()+ "\n");
        }
    }

    public List<Produto> getProdutos(){
        return produtos;
    }
}
