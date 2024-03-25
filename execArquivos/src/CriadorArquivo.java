import java.io.BufferedWriter;
import java.io.FileWriter;

public class CriadorArquivo {

    public void criarArquivo(String pergunta, String resposta) {
        try {
            FileWriter fw = new FileWriter("Resultado.txt");
            BufferedWriter bw = new BufferedWriter(fw);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
