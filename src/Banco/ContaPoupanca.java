package Banco;

public class ContaPoupanca extends Conta{
    private double taxaRendimento;

    public ContaPoupanca(int numAgencia, int numConta, double saldo, Cliente cliente) {
        super(numAgencia, numConta, saldo, cliente);
        this.taxaRendimento = 0.05;
    }
    public double simularOperacao(int meses){
        double rendimento = 0;
        for (int i = 0; i < meses; i++) {
            rendimento = (this.getSaldo() * this.taxaRendimento) + this.getSaldo();
        }
        return rendimento;
    }


}
