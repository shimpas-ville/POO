import java.util.*;

public class Historico {
    private Stack<Venda> vendas;

    public Historico() {
        vendas = new Stack<>();
    }

    public void insere(Venda venda) {
        vendas.push(venda);
    }

    public void getUltimasVendas() {
        int numVendas = Math.min(5, vendas.size());

        if (numVendas == 0) {
            System.out.println("Não foram encontrados registros de venda.");
            return;
        }

        for (int i = 0; i < numVendas; i++) {
            Venda venda = vendas.get(vendas.size() - 1 - i);
            venda.imprimeRecibo();
        }

        if (numVendas < 5) {
            System.out.println("Foi encontrado apenas " + numVendas + " registro(S) de venda(s).");
            System.out.println(" ");
        }
    }

    public Venda getVendaRecibo(int numero) {
        for (Venda venda : vendas) {
            if (numero == venda.getNumero()) {
                venda.imprimeRecibo();
            }
        }
        return null;
    }
}

