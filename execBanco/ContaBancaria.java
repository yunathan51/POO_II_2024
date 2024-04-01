package execBanco;

public class ContaBancaria {

    private String nomeCorrentista;
    private int numeroConta;
    private int saldoConta;

    @Override
    public String toString() {
        return "Conta Bancaria: " + getNomeCorrentista() + " - " + getNumeroConta() + " R$:" + getSaldoConta();
    }

    public ContaBancaria() {
        this("", 0, 0);
    }

    public ContaBancaria(String nome, int numeroConta, int saldoConta) {
        this.nomeCorrentista = nome;
        this.numeroConta = numeroConta;
        this.saldoConta = saldoConta;
    }

    public boolean sacar(int valor) {
        if (valor >= 0 && valor <= saldoConta) {
            saldoConta -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(int valor) {
        if (valor >= 0) {
            saldoConta += valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transferencia(ContaBancaria destino, int valor) {
        if (sacar(valor)) {
            if (destino.depositar(valor)) {
                return true;
            } else {
                depositar(valor);
                return false;
            }

        }
        return false;
    }













    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(int saldoConta) {
        this.saldoConta = saldoConta;
    }
}
