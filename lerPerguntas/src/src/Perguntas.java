package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Perguntas {

    private ArrayList<String> perguntas = new ArrayList<>();
    private ArrayList<String> respostas = new ArrayList<>();

    public Perguntas() {
        try (BufferedReader br = new BufferedReader(new FileReader("Questions.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] div = linha.split("\\.");
                if (div.length >= 2) {
                    perguntas.add(div[0].trim());
                    respostas.add(div[1].trim());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public ArrayList<String> getPerguntas() {
        return perguntas;
    }

    public ArrayList<String> getRespostas() {
        return respostas;
    }
}
