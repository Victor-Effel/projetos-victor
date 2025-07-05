import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = null;
        Produto produto = null;

        int opcao;
        do {
            System.out.println("MENU:");
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome da loja: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade de funcionários: ");
                    int qtdFunc = scanner.nextInt();
                    System.out.print("Salário base: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Rua: ");
                    String rua = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();
                    System.out.print("País: ");
                    String pais = scanner.nextLine();
                    System.out.print("CEP: ");
                    String cep = scanner.nextLine();
                    System.out.print("Número: ");
                    String numero = scanner.nextLine();
                    System.out.print("Complemento: ");
                    String complemento = scanner.nextLine();

                    Endereco endereco = new Endereco(rua, cidade, estado, pais, cep, numero, complemento);

                    System.out.print("Dia de fundação: ");
                    int dia = scanner.nextInt();
                    System.out.print("Mês de fundação: ");
                    int mes = scanner.nextInt();
                    System.out.print("Ano de fundação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    Data dataFundacao = new Data(dia, mes, ano);

                    System.out.print("Quantidade máxima de produtos da loja: ");
                    int qtdMaxProdutos = scanner.nextInt();
                    scanner.nextLine();

                    loja = new Loja(nome, qtdFunc, salario, endereco, dataFundacao, qtdMaxProdutos);
                    break;

                case 2:
                    System.out.print("Nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Dia validade: ");
                    int diaV = scanner.nextInt();
                    System.out.print("Mês validade: ");
                    int mesV = scanner.nextInt();
                    System.out.print("Ano validade: ");
                    int anoV = scanner.nextInt();
                    scanner.nextLine();

                    Data validade = new Data(diaV, mesV, anoV);
                    produto = new Produto(nomeProduto, preco, validade);
                    break;

                case 3:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);

        if (produto != null) {
            Data dataRef = new Data(20, 10, 2023);
            if (produto.estaVencido(dataRef)) {
                System.out.println("PRODUTO VENCIDO");
            } else {
                System.out.println("PRODUTO NÃO VENCIDO");
            }
        }

        if (loja != null) {
            System.out.println(loja.toString());
        }

        scanner.close();
    }
}
