import java.util.*;
public class App {



    public static void main(String args[]){
       Scanner in = new Scanner(System.in);
       Catalogo catalogo = new Catalogo();
       Estoque estoque = new Estoque();
       Historico historico = new Historico();
       int opcao=-1;
       int option=-1;
       int opt=-1;
       int op=-1;
       do {
           menu1();
           option=in.nextInt();
           switch (option){
               case 1: do {
                   menuF();
                   opcao = in.nextInt();
                   switch (opcao) {
                       case 1:
                           System.out.println("Digite o código do produto: ");
                           int cod = in.nextInt();
                           System.out.println("Digite a descrição do produto: ");
                           String description = in.next();
                           System.out.println("Digite o preço unitário do produto: ");
                           double precoUnit = in.nextDouble();
                           System.out.println("Digite a quantia do produto: ");
                           int quantia = in.nextInt();
                           Produto p = new Produto(cod, description, precoUnit);
                           ItemEstoque item = new ItemEstoque(p,quantia);
                           estoque.add(item);
                           break;
                       case 2:
                           System.out.println("Digite o código do produto: ");
                           int codigo = in.nextInt();
                           System.out.println("Digite a descrição do produto: ");
                           String descricao = in.next();
                           System.out.println("Digite o preço unitário do produto: ");
                           double precoUnitario = in.nextDouble();
                           Produto prod = new Produto(codigo, descricao, precoUnitario);
                           catalogo.cadastra(prod);
                           break;
                       case 3:
                           System.out.println("Digite o código do produto: ");
                           int codigo2 = in.nextInt();
                           catalogo.remove(codigo2);
                           break;
                       case 4:
                           System.out.println("Saindo");
                           break;
                       default:
                           System.out.println("Erro");
                           break;
                   }
               } while (opcao != 4);
                   break;
               case 2:
                   Venda venda=null;
                   do {
                       menuC();
                       opt = in.nextInt();
                       switch (opt) {

                           case 1:
                               System.out.println("------NOVA VENDA------");
                               System.out.println("Catálogo de itens:\n");
                               catalogo.Imprime();
                               System.out.println("\n");
                               System.out.println("Digite o código do produto a ser adicionado: ");
                               int cod = in.nextInt();

                               double subtotal = 0;

                               for (Produto p  : catalogo.getProdutos()) {
                                   if(p.getCodigo()==cod){
                                       System.out.println("Quantas unidades deseja adicionar? ");
                                       int q = in.nextInt();
                                       ItemVenda item = new ItemVenda(p,q);
                                       venda= new Venda();
                                       venda.insereItem(item);
                                     //estoque.baixaEstoque(p.getCodigo(),q);
                                   }else{
                                       System.out.println("Não há produto com tal código");
                                   }
                               }

                               double desconto = venda.getDesconto();
                               double imposto = venda.getImposto();
                               double totalVenda = venda.getTotalVenda() - (desconto * venda.getTotalVenda()) + (imposto * venda.getTotalVenda());

                               System.out.println("Desconto: " + (desconto * totalVenda));
                               System.out.println("Imposto: " + (imposto * totalVenda));
                               System.out.println("Total da venda: " + totalVenda);
                               //historico.insere(venda);
                               //System.out.println("Venda fechada");
                               break;
                           case 2:
                               venda.getProdutos();
                               System.out.println("Digite o código do item a ser excluído: ");
                               int c = in.nextInt();
                               venda.removeItem(c);
                               //estoque.repoeEstoque(c, venda.removeItem(c).getQuantidade());
                               break;
                           case 3:
                               historico.insere(venda);
                               System.out.println("Venda fechada");
                               break;
                           case 4:
                               System.out.println("Saindo do Menu Cliente");
                               break;
                           default:
                               System.out.println("Número inválido");
                               break;
                       }
                   } while (opt != 4);
                   break;
               case 3:
                   do {
                       menuG();
                       op = in.nextInt();
                       switch (op) {
                           case 1:
                               List<Venda> ultimasVendas = historico.getUltimasVendas();
                               System.out.println("Últimas 5 vendas: ");
                               for (Venda venda1:ultimasVendas) {
                                   // arrumar
                                   System.out.print("Número: " + venda1.getNumero() + "\nValor: " + venda1.getTotalVenda()+ "Produto: ");
                                   venda1.getProdutos();
                               }
                               break;

                           case 2:
                               System.out.println("Digite o número do recibo: ");
                               int numero = in.nextInt();
                               System.out.println(historico.getVendaRecibo(numero));
                               break;

                           case 3:
                               System.out.println("Saindo do Menu Gerente");
                               break;

                           default:
                               System.out.println("Número inválido");
                               break;
                       }
                   } while (op != 3);
                   break;
               case 4:
                   System.out.println("Fim");
                       break;
               default:
                   System.out.println("Erro");
                   break;
           }

       }while(option!= 4);
    }

    public static void menu1(){
        System.out.println("1- Fornecedor\n2- Cliente\n3- Gerente\n4- Sair");
    }

    public static void menuF(){
        System.out.println("1- Inserir\tum produto no estoque\n" +
                "2- Inserir\tum\tproduto\tno\tcatálogo\n" +
                "3- Remover um produto do catálogo\n"+
                "4- Voltar");
    }

    public static void menuC(){
        System.out.println("1- Abrir\tuma\tvenda\n"+"2- Remover\tum\titem\tde\tvenda\n" +
                "3- Fechar\tuma\tvenda\n"+
                "4- Voltar");
    }

    public static void menuG(){
        System.out.println("1- Listar\tas\túltimas\t5\tvendas\n" +
                "2- Listar\tuma\tvenda\t(pelo\tnúmero\tdo\trecibo)\n"+
                "3- Voltar");
    }
}
