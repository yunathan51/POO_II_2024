package revisao_desafio_jogador.testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import revisao_desafio_jogador.Jogador;

import static org.junit.jupiter.api.Assertions.*;

class JogadorTest {

    Jogador j1;
    Jogador j2;

    @BeforeEach
    public void inicializaJogador() {
        j1 = new Jogador();
        j2 = new Jogador("A", 12, 5);
    }

    @Test
    public void construtorVazioTest() {
        assertEquals(0, j1.getCamisa());
        assertEquals(0, j1.getGols());
        assertEquals("", j1.getNome());
    }


}
