import java.util.Random;
import java.util.Stack;

public class Venda {

    Random rdm = new Random();
    private Stack<ItemVenda> itens;
    private int numero;
    private double valor=0;


    public Venda(){
        itens = new Stack<>();
        numero = rdm.nextInt(10000000);
    }

    public double getDesconto() {
        if(itens.size()>=10) {
            return valor * 0.1;
        }
        return 0;
    }

    public double getImposto() {
        double subtotal = getTotalVenda();
        double imposto;

        imposto = subtotal * 0.25;

        return imposto;
    }

    public Stack<ItemVenda> getItens(){
        return itens;
    }

    public double getTotalVenda() {
        for (ItemVenda item : itens) {
            valor= valor+item.getValorItem();
        }
        return valor;
    }

    public void insereItem(ItemVenda item) {
        itens.push(item);
    }

    public ItemVenda removeItem(int numero) {
        for (ItemVenda item : itens) {
            if(item.getCodigo()==numero){
                itens.remove(item);
                return item;
            }
        }
        return null;
    }

    public boolean imprimeRecibo() {
        return false;
    }

    public int getNumero() {
        return numero;
    }

    public void getProdutos(){
        for (ItemVenda item : itens) {
            System.out.println("Produto : "+item.getProduto()+" Quantidade : "+item.getQuantidade()+" Código : "+item.getCodigo());
        }
    }
}
