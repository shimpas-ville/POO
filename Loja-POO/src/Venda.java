import java.util.Random;
import java.util.Stack;

public class Venda {

    private Random rdm;
    private Stack<ItemVenda> itens;
    private int numero;
    private double valor;


    public Venda(){
        itens=new Stack<>();
        rdm = new Random(1000000);
        numero = rdm.nextInt();
    }

    public double getDesconto() {
        return 0;
    }

    public double getImposto() {
        return 0;
    }

    public double getTotalVenda() {

        return valor;
    }

    public void insereItem(ItemVenda item) {
        itens.push(item);
    }

    public void removeItem(int numero) {

    }

    public boolean fecha() {
        return false;
    }

    public double getSubtotal() {
        return 0;
    }

    public boolean imprimeRecibo() {
        return false;
    }

    public int getNumero() {
        return 0;
    }

}
