package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

    private ArrayList<String> perguntasRespondidas = new ArrayList<>();
    private ArrayList<String> respostasDadas = new ArrayList<>();

    public Arquivo() {
        try (FileWriter fw = new FileWriter("QuestoesRespondidas.txt")) {
            for (int i = 0; i < perguntasRespondidas.size(); i++) {
                fw.write(perguntasRespondidas.get(i) + ": " + respostasDadas.get(i) + "\n");
            }
            System.out.println("Conteúdo dos arrays gravado no arquivo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }

    public void salvarRespostas() {
        try (FileWriter fw = new FileWriter("QuestoesRespondidas.txt")) {
            for (int i = 0; i < perguntasRespondidas.size(); i++) {
                fw.write(perguntasRespondidas.get(i) + ": " + respostasDadas.get(i) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }

    public ArrayList<String> getPerguntasRespondidas() {
        return perguntasRespondidas;
    }

    public ArrayList<String> getRespostasDadas() {
        return respostasDadas;
    }
}
