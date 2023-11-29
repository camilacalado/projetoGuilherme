package Banco;

public class Conta {
    private int numAgencia;
    private int numConta;
    private double saldo;
    private Cliente cliente;

    public Conta(int numAgencia, int numConta, double saldo, Cliente cliente) {
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public int getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(int numAgencia) {
        this.numAgencia = numAgencia;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void deposito(double valor) {
        this.saldo += valor;
        System.out.println("Seu saldo apos o deposito é de: " + this.saldo);
    }

    public void saque(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Seu saldo apos o saque é de: " + this.saldo);
        } else {
            System.out.println("Saldo para saque insuficiente.");
        }
    }

    public void transferencia(Conta outraConta, double valor) {
        if (valor <= this.saldo) {
            this.saque(valor);
            outraConta.deposito(valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void exibirSaldo() {
        System.out.println("O usuário " + cliente.getNome() + " possui R$" + this.saldo + " na conta.");
    }
}
