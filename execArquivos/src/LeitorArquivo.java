import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {

    private String pergunta;
    private String resposta;

    public LeitorArquivo() {

    }

    public LeitorArquivo(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;

    }

    ArrayList<LeitorArquivo> arquivosLidos = new ArrayList<LeitorArquivo>();

    public void leitorArquivos () {

        try {
            FileReader fw = new FileReader("Questoes.txt");
            BufferedReader br = new BufferedReader(fw);
            String linha = "";

            while ((linha = br.readLine()) != null) {
                String div[] = linha.split("\\.");
                setPergunta(div[0]);
                setResposta(div[1]);
                arquivosLidos.add(new LeitorArquivo(getPergunta(), getResposta()));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }





    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
