import java.util.*;

public class Venda {
    private Random rdm = new Random();
    private List<ItemVenda> itens;
    private int numero;
    private double totalVenda, subtotal, desconto, imposto;

    public Venda() {
        numero = rdm.nextInt(10000000);
        totalVenda = 0;
        subtotal = 0;
        desconto = 0;
        imposto = 0;
        itens = new ArrayList<>();
    }

    public List<ItemVenda> getItens() {
        return itens;
    }


    public double getSubtotal(){
        return subtotal;
    }

    public double getDesconto(){
        return desconto;
    }

    public double getImposto(){
        return imposto;
    }

    public double getTotalVenda() {
        double valor = 0;
        double descontoTotal = 0;
        double impostoTotal = 0;

        for (ItemVenda item : itens) {
            valor += item.getValorItem();
            descontoTotal += item.getDesconto();
            impostoTotal += item.getImposto();
        }

        return valor + impostoTotal - descontoTotal;
    }

    public boolean insereItem(Produto produto, int quant) {
        ItemVenda item = new ItemVenda(produto.getCodigo(), produto, quant);
        return itens.add(item);
    }

    public boolean removeItem(int codigo) {
        Iterator<ItemVenda> iterator = itens.iterator();
        while (iterator.hasNext()) {
            ItemVenda item = iterator.next();
            if (item.getNumero() == codigo) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean fecha(Estoque estoque){
        if (itens.isEmpty())
            return false;
        else {
            for (ItemVenda item : itens) {
                int codigoProduto = item.getProduto().getCodigo();
                int quantidadeVendida = item.getQuantidade();
                estoque.baixaEstoque(codigoProduto, quantidadeVendida);
            }
            return true;
        }
    }

    public void getProdutos(){
        for (ItemVenda item : itens) {
            System.out.println("Produto : "+item.getProduto()+" Quantidade : "+item.getQuantidade()+" Código : "+item.getNumero());
        }
    }

    public int getNumero() {
        return numero;
    }


    public void imprimeRecibo() {
        double subtotal = 0;
        double impostoTotal = 0;
        double descontoTotal = 0;

        System.out.println("=======================================");
        System.out.println("Recibo da Venda #" + numero);

        Map<Integer, ItemVenda> mapaItens = new HashMap<>();

        for (ItemVenda item : itens) {
            int codigoProduto = item.getNumero();

            if (mapaItens.containsKey(codigoProduto)) {
                ItemVenda itemExistente = mapaItens.get(codigoProduto);
                itemExistente.setQuantidade(itemExistente.getQuantidade() + item.getQuantidade());
            } else {
                mapaItens.put(codigoProduto, item);
            }
        }

        for (ItemVenda item : mapaItens.values()) {
            System.out.println("---------------------------------------");
            System.out.println("Descrição do Produto: " + item.getDescricao());
            System.out.println("Código do Produto: " + item.getNumero());
            System.out.println("Preço Unitário: R$" + item.getPrecoUnitarioCobrado());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("Subtotal: R$" + item.getValorItem());
            System.out.println("Desconto do Item: R$" + item.getDesconto());
            System.out.println("Imposto do Item: R$" + item.getImposto());
            System.out.println("Total a pagar: R$" + (item.getValorItem() + item.getImposto() - item.getDesconto()));

            subtotal += item.getValorItem();
            impostoTotal += item.getImposto();
            descontoTotal += item.getDesconto();
        }

        System.out.println("=======================================");
        System.out.println("SUBTOTAL: R$" + subtotal);
        System.out.println("IMPOSTO COBRADO: R$" + impostoTotal);
        System.out.println("DESCONTO APLICADO: R$" + descontoTotal);
        System.out.println("TOTAL A PAGAR: R$" + (subtotal + impostoTotal - descontoTotal));
        System.out.println("=======================================");
    }
}