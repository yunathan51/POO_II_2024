package execBanco;

public class ContaCorrente extends ContaBancaria{

    @Override
    public String toString() {
        return "Conta Corrente: " + getNomeCorrentista() + " - " + getNumeroConta() + " R$:" + getSaldoConta();
    }

    public ContaCorrente() {
        this("", 0, 0);
    }

    public ContaCorrente(String nome, int numeroConta, int saldoConta) {
        super(nome, numeroConta, saldoConta);
    }
}
