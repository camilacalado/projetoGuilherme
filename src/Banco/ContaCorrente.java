package Banco;

public class ContaCorrente extends Conta {
    private double taxaManutencao;

    public ContaCorrente(int numAgencia, int numConta, double saldo, Cliente cliente) {
        super(numAgencia, numConta, saldo, cliente);
        this.taxaManutencao = 50;
    }

    public double simularOperacao(int meses) {
        return this.getSaldo() - (this.taxaManutencao * meses);
     }

     public double getTaxaManutencao() {
        return taxaManutencao;
    }

}
