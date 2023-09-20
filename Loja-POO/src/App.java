import java.util.*;
public class App {

    public static void main(String args[]){
       Scanner in = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        Estoque estoque = new Estoque(catalogo);
       Historico historico = new Historico();
        Stack<Venda> pilhaVendas = new Stack<>();

       int opcao = 0;
       int option = 0;
       int op = 0;
       int escolha = 0;

       do {
           menu();
           option=in.nextInt();
           switch (option) {
               case 1 -> {
                   do {
                       menuF();
                       opcao = in.nextInt();
                       switch (opcao) {
                           case 1 -> {
                               System.out.println("Digite o código do produto: ");
                               int cod = in.nextInt();
                               System.out.println("Digite a descrição do produto: ");
                               String description = in.next();
                               System.out.println("Digite o preço unitário do produto: ");
                               double precoUnit = in.nextDouble();
                               System.out.println("Digite a quantidade em estoque do produto: ");
                               int quantia = in.nextInt();

                               Produto p = new Produto(cod, description, precoUnit);
                               catalogo.cadastra(p, quantia);
                           }
                           case 2 -> {
                               System.out.println("Digite o código do produto: ");
                               int codigo2 = in.nextInt();
                               System.out.println("Digite a quantidade que deseja remover: ");
                               int quant = in.nextInt();
                               catalogo.remove(codigo2);
                               estoque.baixaEstoque(codigo2, quant);
                           }
                           case 3 -> System.out.print(" ");
                           default -> System.out.println("Opção inválida");
                       }
                   } while (opcao != 3);
               }
               case 2 -> {
                   Venda venda = new Venda();
                   //ArrayList<ItemVenda> itensVenda = new ArrayList<>();
                   int numVenda = (pilhaVendas.size() + 1);
                   boolean continuarAdicionando = true;
                   do {
                       menuC();
                       System.out.println("Digite a opção desejada: ");
                       escolha = in.nextInt();

                       if (escolha == 1) {
                           System.out.println("Catálogo de itens:\n");
                           catalogo.Imprime();
                           System.out.println("\n");
                           System.out.println("Digite o código do produto a ser adicionado: ");
                           int cod = in.nextInt();
                           double subtotal = 0;

                           List<ItemEstoque> itensEstoque = catalogo.getItensEstoque();
                           boolean produtoEncontrado = false;

                           for (ItemEstoque item : itensEstoque) {
                               Produto p = item.getProduto();
                               if (p.getCodigo() == cod) {
                                   System.out.println("Quantas unidades deseja adicionar? ");
                                   int q = in.nextInt();
                                   ItemVenda itemVenda = new ItemVenda(p, q);
                                   venda.insereItem(itemVenda);
                                   estoque.baixaEstoque(p.getCodigo(), q);
                                   System.out.println("Produto adicionado ao carrinho.");

                                   System.out.println("Item: " + itemVenda.getProduto().getDescricao());
                                   System.out.println("Quantidade: " + itemVenda.getQuantidade());
                                   System.out.println("Subtotal item: R$" + itemVenda.getValorItem());
                                   System.out.println("Desconto: R$" + itemVenda.getDesconto());
                                   System.out.println("Imposto: " + itemVenda.getImposto());
                                   System.out.println("Total item: " + (itemVenda.getValorItem() + itemVenda.getImposto() - itemVenda.getDesconto()));

                                   produtoEncontrado = true;
                                   break;
                               }
                           }

                           if (!produtoEncontrado) {
                               System.out.println("Não há produto com tal código");
                           }

                           System.out.println("Total da venda: " + venda.getTotalVenda());

                       } else if (escolha == 2) {
                           if (!venda.getItens().isEmpty()) {
                               venda.getProdutos();
                               System.out.println("Digite o código do item a ser excluído: ");
                               int c = in.nextInt();
                               boolean removedItem = venda.removeItem(c);
                               if (removedItem) {
                                   estoque.repoeEstoque(c, Estoque.getQuantidade(c));
                                   //itensVenda.removeIf(item -> item.getCodigo() == c);
                                   System.out.println("Item removido do carrinho.");
                               } else {
                                   System.out.println("Item não encontrado no carrinho.");
                               }
                           } else {
                               System.out.println("Não há produtos no carrinho.");
                           }
                       } else if (escolha == 3) {
                           continuarAdicionando = false;
                           venda.imprimeRecibo();
                           escolha=4;
                       } else if (escolha == 4)
                           System.out.print(" ");
                       else
                           System.out.println("Opção inválida");
                   } while (escolha != 4 /*&& escolha != 3*/);
               }
               case 3 -> {
                   do {
                       menuG();
                       op = in.nextInt();
                       switch (op) {
                           case 1 -> {
                               List<Venda> ultimasVendas = historico.getUltimasVendas();
                               System.out.println("Últimas 5 vendas: ");
                               for (Venda venda1 : ultimasVendas) {
                                   // arrumar
                                   System.out.print("Número: " + venda1.getNumero() + "\nValor: " + venda1.getTotalVenda() + "Produto: ");
                                   venda1.getProdutos();
                               }
                           }
                           case 2 -> {
                               System.out.println("Digite o número do recibo: ");
                               int numero = in.nextInt();
                               System.out.println(historico.getVendaRecibo(numero));
                           }
                           case 3 -> System.out.println("Saindo do Menu Gerente");
                           default -> System.out.println("Número inválido");
                       }
                   } while (op != 3);
               }
               case 4 -> System.out.println("Fim");
               default -> System.out.println("Erro");
           }

       }while(option!= 4 && escolha!=3);
    }

    public static void menu(){
        String mensagem = """
                ==== MENU PRINCIPAL ====
                Por favor, identifique-se:
                1 - Fornecedor
                2 - Cliente
                3 - Gerente
                4 - Sair
                """;
        System.out.println(mensagem);
    }

    public static void menuF(){
        String mensagem = """
                ==== MENU FORNECEDOR ====
                1 - Inserir produto no estoque
                2 - Remover produto do estoque
                3 - Voltar
                """;
        System.out.println(mensagem);
    }

    public static void menuC(){
        String mensagem = """
                ==== MENU CLIENTE ====
                1 - Adicionar produto ao carrinho
                2 - Remover produto do carrinho
                3 - Fechar pedido
                4 - Sair
                """;
        System.out.println(mensagem);
    }

    public static void menuG(){
        String mensagem = """
                ==== MENU GERÊNCIA ====
                1 - Listar últimas 5 vendas
                2 - Procurar venda por número de recibo
                3 - Voltar
                """;
        System.out.println(mensagem);
    }
}
