package Banco;
import java.util.ArrayList;
import java.util.Scanner;

public class testeOperacoes {

    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Conta> listaContas = new ArrayList<>();

    public void criarConta() {
        Scanner in = new Scanner(System.in);

        System.out.println("Informe o nome do cliente:");
        String nome = in.nextLine();

        System.out.println("Informe o endereço do cliente:");
        String endereco = in.nextLine();

        System.out.println("Informe a profissão do cliente:");
        String profissao = in.nextLine();

        Cliente cliente = new Cliente(nome, endereco, profissao);
        listaClientes.add(cliente);

        System.out.println("Informe o tipo de conta (poupança ou corrente):");
        String tipoConta = in.nextLine();

        System.out.println("Informe o número da agência:");
        int numeroAgencia = in.nextInt();

        System.out.println("Informe o número da conta:");
        int numeroConta = in.nextInt();

        System.out.println("Informe o saldo inicial:");
        double saldoInicial = in.nextDouble();

        try {
            Conta novaConta;
            if (tipoConta.equalsIgnoreCase("poupança")) {
                novaConta = new ContaPoupanca(numeroAgencia, numeroConta, saldoInicial, cliente);
            } else if (tipoConta.equalsIgnoreCase("corrente")) {
                novaConta = new ContaCorrente(numeroAgencia, numeroConta, saldoInicial, cliente);
            } else {
                throw new IllegalArgumentException("Tipo de conta inválido");
            }

            listaContas.add(novaConta);
            System.out.println("Conta criada com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }
    }

    public void realizarOperacoes() {
        Scanner in = new Scanner(System.in);

        System.out.println("Informe o número da agência e conta do remetente:");
        int agenciaRemetente = in.nextInt();
        int contaRemetente = in.nextInt();

        System.out.println("Informe o número da agência e conta do destinatário:");
        int agenciaDestinatario = in.nextInt();
        int contaDestinatario = in.nextInt();

        System.out.println("Informe o valor a ser transferido:");
        double valorTransferencia = in.nextDouble();

        Conta remetente = buscarConta(agenciaRemetente, contaRemetente);
        Conta destinatario = buscarConta(agenciaDestinatario, contaDestinatario);

        if (remetente != null && destinatario != null) {
            remetente.transferencia(destinatario, valorTransferencia);
        } else {
            System.out.println("Conta não encontrada.");
        }
        in.close();
    }

    public void exibirSaldo() {
        Scanner in = new Scanner(System.in);

        System.out.println("Informe o número da agência e conta para consultar o saldo:");
        int agencia = in.nextInt();
        int conta = in.nextInt();

        Conta contaConsultada = buscarConta(agencia, conta);

        if (contaConsultada != null) {
            contaConsultada.exibirSaldo();
        } else {
            System.out.println("Conta não encontrada.");
        }
        in.close();
    }

    public void apresentarMenu() {
        Scanner in = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Criar conta");
            System.out.println("2. Realizar operações");
            System.out.println("3. Exibir saldo");
            System.out.println("0. Sair");

            System.out.println("Escolha uma opção:");
            opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    realizarOperacoes();
                    break;
                case 3:
                    exibirSaldo();
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        in.close();
    }

    private Conta buscarConta(int agencia, int conta) {
        for (Conta c : listaContas) {
            if (c.getNumAgencia() == agencia && c.getNumConta() == conta) {
                return c;
            }
        }
        return null;
    }

}

