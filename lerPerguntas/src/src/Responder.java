package src;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Responder {

    public Responder(ArrayList<String> perguntas, ArrayList<String> respostas) {
        Arquivo arquivo = new Arquivo();
        int numPerguntas = 10;
        for (int i = 0; i < numPerguntas; i++) {
            int index = new Random().nextInt(perguntas.size());
            String respostaUsuario = JOptionPane.showInputDialog(perguntas.get(index));
            String respostaCorreta = respostas.get(index);

            String resultado = respostaUsuario.equalsIgnoreCase(respostaCorreta) ? "ACERTOU" : "ERROU";
            arquivo.getPerguntasRespondidas().add(perguntas.get(index) + " | " + resultado);
        }
        arquivo.salvarRespostas();
        System.out.println("Respostas salvas no arquivo 'QuestoesRespondidas.txt'.");
    }
}
