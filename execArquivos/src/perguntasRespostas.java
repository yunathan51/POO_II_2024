import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class perguntasRespostas {

    private int acertos;

    public perguntasRespostas() {
        this.acertos = 0;
    }

    public void perguntarAoUsuario() {
        LeitorArquivo arquivosLidos = new LeitorArquivo();
        arquivosLidos.leitorArquivos();

        StringBuilder sb = new StringBuilder();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Respostas.txt"));

            for (int i = 0; i < 2; i++) {
                int index = new Random().nextInt(arquivosLidos.arquivosLidos.size());
                String pergunta = arquivosLidos.arquivosLidos.get(index).getPergunta();
                String respostaCorreta = arquivosLidos.arquivosLidos.get(index).getResposta();

                String respostaDada = JOptionPane.showInputDialog(pergunta);
                sb.append("Pergunta: ").append(pergunta).append(", Resposta: ").append(respostaCorreta).append(", Resposta fornecida: ").append(respostaDada).append("\n");

                if (respostaDada != null && respostaDada.equalsIgnoreCase(respostaCorreta)) {
                    JOptionPane.showMessageDialog(null, "Resposta correta!");
                    acertos++;
                } else {
                    JOptionPane.showMessageDialog(null, "Resposta incorreta!");
                }
            }
            writer.write("Número de acertos: " + acertos + "\n");
            writer.write(sb.toString());
            writer.close();

            JOptionPane.showMessageDialog(null, "Número de acertos: " + acertos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
