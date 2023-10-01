import java.util.*;

public class HistoricoVendas {
    private Stack<Venda> vendas;

    public HistoricoVendas() {
        vendas = new Stack<>();
    }

    public boolean insere(Venda venda) {
        return vendas.push(venda) != null;
    }

    public List<Venda> getUltimasVendas() {
        int numVendas = vendas.size();

        if (numVendas == 0) {
            System.out.println("Não foram encontrados registros de venda.");
            return Collections.emptyList();
        }

        List<Venda> ultimasVendas = new ArrayList<>();
        for (int i = 0; i < numVendas; i++) {
            Venda venda = vendas.get(numVendas - 1 - i);
            ultimasVendas.add(venda);
        }

        System.out.println("Foram encontrados " + numVendas + " registro(s) de venda(s).");
        System.out.println(" ");

        return ultimasVendas;
    }

    public Venda getVendaRecibo(int numero) {
        for (Venda venda : vendas) {
            if (numero == venda.getNumero()) {
                venda.imprimeRecibo();
            }
        }
        return null;
    }

    public Venda getVenda(int numero) {
        for (Venda venda : vendas) {
            if (numero == venda.getNumero()) {
                return venda;
            }
        }
        return null;
    }
}

