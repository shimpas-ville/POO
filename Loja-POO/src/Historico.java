import java.util.*;
public class Historico {

    private Stack<Venda> vendas;

    private Venda venda;

    public void insere(Venda venda) {

    }

    public List<Venda> getUltimasVendas() {
        int numVendas = Math.min(5, vendas.size());
        List<Venda> ultimasVendas = new ArrayList<>();

        if(numVendas == 0){
            return null;
        }

        for (int i =0; i < numVendas; i++){
            Venda venda = vendas.get(vendas.size() - 1 - i);
            ultimasVendas.add(venda);
        }

        return ultimasVendas;
    }

    public Venda getVendaRecibo(int numero){
        for (Venda venda:vendas) {
            if(numero == venda.getNumero()){
                return venda;
            }
        }
        return null;
    }

}

