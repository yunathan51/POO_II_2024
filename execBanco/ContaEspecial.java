package execBanco;

public class ContaEspecial extends ContaBancaria{

    private int limiteSaque;

    @Override
    public String toString() {
        return "Conta Especial: " + getNomeCorrentista() + " - " + getNumeroConta() + " R$:" + getSaldoConta() + "limite saque: R$" + getLimite();
    }

    public ContaEspecial() {
        super();
        setLimite(0);
    }

    public ContaEspecial(String nome, int numeroConta, int saldoConta, int limite) {
        super(nome, numeroConta, saldoConta);
        setLimite(limite);
    }

    @Override
    public boolean sacar(int valor) {
        if (getSaldoConta() >= valor && valor <= limiteSaque) {
            setSaldoConta(getSaldoConta() - valor);
            return true;
        } else {
            return false;
        }
    }




    public int getLimite() {
        return limiteSaque;
    }

    public void setLimite(int limite) {
        this.limiteSaque = limite;
    }
}
