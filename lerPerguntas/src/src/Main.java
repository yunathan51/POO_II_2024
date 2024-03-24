package src;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        switch (escolheMenu()) {
            case 1:
                new CarregarArquivo();
                break;
            case 2:
                new Jogar();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    private static int escolheMenu() {
        String menu = "Escolha uma opção:\n" +
                "1 - Carregar Arquivo\n" +
                "2 - Jogar\n" +
                "3 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    private static class CarregarArquivo {

        public CarregarArquivo() {
            Perguntas perguntasPerguntar = new Perguntas();
            ArrayList<String> perguntas = perguntasPerguntar.getPerguntas();
            ArrayList<String> respostas = perguntasPerguntar.getRespostas();

            if (perguntas.isEmpty()) {
                System.out.println("Não há perguntas disponíveis. Verifique o arquivo 'Questions.txt'.");
            } else {
                System.out.println("Perguntas carregadas com sucesso!");

            }
        }
    }


    private static class Jogar {

        public Jogar() {
            Perguntas perguntasPerguntar = new Perguntas();
            ArrayList<String> perguntas = perguntasPerguntar.getPerguntas();
            ArrayList<String> respostas = perguntasPerguntar.getRespostas();

            if (perguntas.isEmpty()) {
                System.out.println("Não há perguntas disponíveis. Verifique o arquivo 'Questions.txt'.");
                return;
            }

            Arquivo arquivo = new Arquivo();
            int numPerguntas = 10;
            for (int i = 0; i < numPerguntas; i++) {
                int index = new Random().nextInt(perguntas.size());
                String resposta = JOptionPane.showInputDialog(perguntas.get(index));
                arquivo.getPerguntasRespondidas().add(perguntas.get(index));

                if (resposta.contains(respostas.get(index))) {
                    System.out.println("Resposta correta!");
                    arquivo.getRespostasDadas().add("Correta");
                } else {
                    System.out.println("Resposta incorreta!");
                    arquivo.getRespostasDadas().add("Incorreta");
                }

            }
            arquivo.salvarRespostas();
            System.out.println("Respostas salvas no arquivo 'QuestoesRespondidas.txt'.");
        }
    }



}
