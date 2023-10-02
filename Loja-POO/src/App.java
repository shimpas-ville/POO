import java.util.*;
public class App {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        CatalogoProduto catalogoProduto = new CatalogoProduto();
        Estoque estoque = new Estoque(catalogoProduto);
        HistoricoVendas historico = new HistoricoVendas();
        Stack<Venda> pilhaVendas = new Stack<>();
        Stack<ItemEstoque> itens = new Stack<>();

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
                               in.nextLine();
                               System.out.println("Digite a descrição do produto: ");
                               String description = in.nextLine();
                               System.out.println("Digite o preço unitário do produto: ");
                               double precoUnit = in.nextDouble();
                               System.out.println("Digite a quantidade em estoque do produto: ");
                               int quantia = in.nextInt();

                               Produto p = new Produto(cod, description, precoUnit);
                               catalogoProduto.cadastra(p, quantia);
                               ItemEstoque item = new ItemEstoque(p, quantia);
                               estoque.insereProduto(item);


                           }
                           case 2 -> {
                               estoque.imprime();
                               System.out.println("Digite o código do produto: ");
                               int codigo2 = in.nextInt();
                               System.out.println("Digite a quantidade que deseja remover: ");
                               int quant = in.nextInt();
                               estoque.baixaEstoque(codigo2, quant);
                               catalogoProduto.baixaCatalogo(codigo2, quant);
                           }
                           case 3 -> System.out.print(" ");
                           default -> System.out.println("Opção inválida");
                       }
                   } while (opcao != 3);
               }
               case 2 -> {
                   int r=0;
                   Venda venda = new Venda();
                   int numVenda = (pilhaVendas.size() + 1);
                   do {
                       menuC();
                       System.out.println("Digite a opção desejada: ");
                       escolha = in.nextInt();

                       if (escolha == 1) {
                           System.out.println("Catálogo de itens:\n");
                           catalogoProduto.imprime();
                           System.out.println("\n");
                           System.out.println("Digite o código do produto que deseja adicionar ao carrinho: ");
                           int cod = in.nextInt();

                           List<ItemEstoque> itensEstoque = catalogoProduto.getItensEstoque();
                           boolean produtoEncontrado = false;

                           for (ItemEstoque item : itensEstoque) {
                               Produto p = item.getProduto();
                               int num = p.getCodigo();
                               if (num == cod) {
                                   produtoEncontrado = true;
                                   System.out.println("Quantas unidades deseja adicionar? ");
                                   int q = in.nextInt();
                                   if(item.getQuantidade()>=q) {
                                       ItemVenda itemVenda = new ItemVenda(num, p, q);
                                        venda.insereItem(p, q);
                                        estoque.baixaEstoque(p.getCodigo(), q);
                                        catalogoProduto.baixaCatalogo(p.getCodigo(), q);
                                        r=q;

                                       System.out.println("Produto adicionado ao carrinho.");

                                       System.out.println("Item: " + itemVenda.getProduto().getDescricao());
                                       System.out.println("Quantidade: " + itemVenda.getQuantidade());
                                       System.out.println("Subtotal item: R$" + itemVenda.getValorItem());
                                       System.out.println("Desconto: R$" + itemVenda.getDesconto());
                                       System.out.println("Imposto: " + itemVenda.getImposto());
                                       System.out.println("Total item: " + (itemVenda.getValorItem() + itemVenda.getImposto() - itemVenda.getDesconto()));
                                   }
                                   break;
                               }
                           }

                           if (!produtoEncontrado) {
                               System.out.println("Não foi possível completar a venda.");
                           }

                           System.out.println("Total da venda: " + venda.getTotalVenda());

                       } else if (escolha == 2) {
                           if (!venda.getItens().isEmpty()) {
                               venda.getProdutos();
                               System.out.println("Digite o código do item a ser excluído: ");
                               int c = in.nextInt();
                               boolean removedItem = venda.removeItem(c);
                               if (removedItem) {
                                   estoque.repoeEstoque(c, r);
                                   catalogoProduto.repoeCatalogo(c, r);
                                   System.out.println("Item removido do carrinho.");
                               } else {
                                   System.out.println("Item não encontrado no carrinho.");
                               }
                           } else {
                               System.out.println("Não há produtos no carrinho.");
                           }
                       } else if (escolha == 3) {
                           historico.insere(venda);
                           venda.fecha(estoque);
                           venda.imprimeRecibo();
                           escolha = 4;

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
                               System.out.println("Últimas vendas: ");
                               List<Venda> ultimasVendas = historico.getUltimasVendas();

                               for (Venda venda : ultimasVendas) {
                                   System.out.println(historico.getVendaRecibo(venda.getNumero()));
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
                1 - Listar últimas vendas
                2 - Procurar venda por número de recibo
                3 - Voltar
                """;
        System.out.println(mensagem);
    }
}
