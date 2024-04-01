package execBanco;

public class ContaUniversitaria extends ContaBancaria{

    @Override
    public String toString() {
        return "Conta Universitaria: " + getNomeCorrentista() + " - " + getNumeroConta() + " R$:" + getSaldoConta();
    }


    public ContaUniversitaria() {
        super();
    }

    public ContaUniversitaria(String nome, int numeroConta, int saldoConta) {
        super(nome, numeroConta, saldoConta);
    }

    @Override
    public boolean depositar(int valor) {
        if (valor >= 0 && valor + getSaldoConta() <= 2000) {
            setSaldoConta(getSaldoConta() +valor);
            return true;
        } else {
            return false;
        }
    }

}
