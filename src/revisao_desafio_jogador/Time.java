package revisao_desafio_jogador;

import java.util.ArrayList;

public class Time {

    private ArrayList<Jogador> jogadores;
    private String nome;



    @Override
    public String toString() {
        return getNome()+ " ("+getJogadores().size()+")";
    }



    public Time() {
        setNome("");
        setJogadores(new ArrayList<Jogador>());
    }

    public Time(String nome, ArrayList<Jogador> jogadores) {
        this.nome = nome;
        this.jogadores = jogadores;
    }

    public String listarJogadores() {
        String resultado = "";
        for (Jogador jogador : jogadores) {
            resultado += jogador + "\n";
        }
        return resultado;
    }

    public Jogador arilheiroTime() {
        Jogador artilheiro = new Jogador();
        for (Jogador jogador : jogadores) {
            if (jogador.getGols() > artilheiro.getGols()) {
                artilheiro = jogador;
            }
        }

        return artilheiro;
    }

    public int qtGolsTime() {
        int qtGols = 0;
        for (Jogador jogador : jogadores) {
            qtGols += jogador.getGols();
        }
        return qtGols;
    }


    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
