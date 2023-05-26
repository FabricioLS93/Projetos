import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       System.out.print("Seja bem vindo ao ConectBank!\n\nPreencha seu cadastro abaixo.\n\n");

        Scanner leitura = new Scanner(System.in, StandardCharsets.UTF_8);
        String nome = "";
        String tipoDeConta = "";
        double saldoInicial = 0.0;

        while (nome.trim().isEmpty() || !nome.matches("[\\p{L}\\s-]+")) {
            System.out.print("Digite seu nome: ");
            nome = leitura.nextLine().trim();

            if (nome.trim().isEmpty()) {
                System.out.println("Erro: nome inválido. Por favor, tente novamente.");
            } else if (!nome.matches("[\\p{L}\\s-]+")) {
                System.out.println("Erro: o nome não pode conter números ou caracteres especiais. Por favor, tente novamente.");
            }
        }

        while (true) {
            System.out.print("Tipo de conta: ");
            tipoDeConta = leitura.nextLine().trim();

            if (tipoDeConta.equalsIgnoreCase("corrente") || tipoDeConta.equalsIgnoreCase("poupança")) {
                break;
            } else {
                System.out.println("Erro: Tipo de conta inválido. Por favor, informe 'corrente' ou 'poupança'.");
            }
        }

        while (saldoInicial <= 0) {
            System.out.print("Digite o saldo inicial: ");
            try {
                saldoInicial = Double.parseDouble(leitura.nextLine());
                if (saldoInicial <= 0) {
                    System.out.println("Erro: o saldo inicial deve ser maior que zero. Por favor, tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: valor inválido. Por favor, digite um número válido para o saldo inicial.");
            }
        }

        System.out.println("********************************");
        System.out.println("Dados iniciais do cliente\n");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de conta: " + tipoDeConta);
        System.out.println("Saldo inicial: " + saldoInicial);
        System.out.println("********************************");

        String menu = """
                ** Digite sua opção **
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor 
                4 - Sair

                """;

        int opcao = 0;
        while (opcao != 4) {
            System.out.println(menu);
            opcao = leitura.nextInt();

            if (opcao == 1){
                System.out.println("O saldo atualizado é " + saldoInicial);
            } else if (opcao == 2) {
                System.out.println("Qual o valor que deseja transferir?");
                double valor = leitura.nextDouble();
                if (valor > saldoInicial) {
                    System.out.println("Não há saldo para realizar a transferência.");
                } else {
                    saldoInicial -= valor;
                    System.out.println("Novo saldo: " + saldoInicial);
                }
            } else if (opcao == 3) {
                System.out.println("Valor recebido: ");
                double valor = leitura.nextDouble();
                saldoInicial += valor;
                System.out.println("Novo saldo: " + saldoInicial);
            } else if (opcao != 4) {
                System.out.println("Opção inválida!");
            }
            }

        }
    }