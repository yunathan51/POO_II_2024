package execBanco.testes;

import execBanco.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class execBancosTeste {

    private Banco banco = new Banco();

    @BeforeEach
    void criaContas() {
        banco.adicionarConta(new ContaCorrente("Xande", 123, 1000));
        banco.adicionarConta(new ContaEspecial("Rafael", 123, 1000, 2000));
        banco.adicionarConta(new ContaUniversitaria("Kaike", 123, 1000));
    }

    @Test
    void saqueTest() {
        List<ContaBancaria> contas = banco.getContas();
        contas.get(0).sacar(50);
        contas.get(1).sacar(50);
        contas.get(2).sacar(50);

        Assertions.assertEquals(contas.get(0).getSaldoConta(), 950);
        Assertions.assertEquals(contas.get(1).getSaldoConta(), 950);
        Assertions.assertEquals(contas.get(2).getSaldoConta(), 950);

        contas.get(1).depositar(1050);
        contas.get(1).sacar(2000);

        Assertions.assertNotEquals(contas.get(1).getSaldoConta(), 2000);
    }

    @Test
    void depositoTest() {
        List<ContaBancaria> contas = banco.getContas();
        contas.get(0).depositar(100);
        contas.get(1).depositar(100);
        contas.get(2).depositar(100);

        Assertions.assertEquals(contas.get(0).getSaldoConta(), 1100);
        Assertions.assertEquals(contas.get(1).getSaldoConta(), 1100);
        Assertions.assertEquals(contas.get(2).getSaldoConta(), 1100);
    }

    @Test
    void transferenciaTest() {
        List<ContaBancaria> contas = banco.getContas();
        contas.get(0).transferencia(contas.get(1), 1000);

        Assertions.assertEquals(contas.get(0).getSaldoConta(), 0);
        Assertions.assertEquals(contas.get(1).getSaldoConta(), 2000);

        contas.get(0).depositar(2000);
        contas.get(0).transferencia(contas.get(2), 2000);

        Assertions.assertEquals(contas.get(0).getSaldoConta(), 2000);
        Assertions.assertEquals(contas.get(2).getSaldoConta(), 1000);
        Assertions.assertNotEquals(contas.get(2).getSaldoConta(), 3000);
    }




}
