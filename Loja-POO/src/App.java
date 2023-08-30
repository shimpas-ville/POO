import java.util.*;
public class App {



    public static void main(String args[]){
       Scanner in = new Scanner(System.in);
       Catalogo catalogo = new Catalogo();
       Estoque estoque = new Estoque();
       int opcao=-1;
       int option=-1;
       int opt=-1;
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
                           String description = in.nextLine();
                           System.out.println("Digite o preço unitário do produto: ");
                           double precoUnit = in.nextDouble();
                           System.out.println("Digite o preço unitário do produto: ");
                           int quantia = in.nextInt();
                           Produto p = new Produto(cod, description, precoUnit);
                           ItemEstoque item = new ItemEstoque(p,quantia);
                           estoque.add(item);
                           break;
                       case 2:
                           System.out.println("Digite o código do produto: ");
                           int codigo = in.nextInt();
                           System.out.println("Digite a descrição do produto: ");
                           String descricao = in.nextLine();
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
                       default:
                           System.out.println("Erro");
                           break;
                   }
               } while (opcao != 4);
                   break;
               case 2:
                   do {
                       menuC();
                       opt = in.nextInt();
                       switch (opt) {
                           case 1:

                       }
                   } while (opt != 4);
                   break;
               case 3:
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
                "4- voltar");
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
