package src;

import java.util.ArrayList;

public class Playlist {
    private String nome;
    private Usuario dono;
    private ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome, Usuario dono) {
        setNome(nome);
        setDono(dono);
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if (nome.isBlank() || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome da playlist precisa estar preenchido!");
        }

        this.nome = nome;
    }

    public Usuario getDono() {
        return dono;
    }

    private void setDono(Usuario dono) {

        if (dono == null) {
            throw new IllegalArgumentException("Erro ao vincular dono à playlist.");
        }

        this.dono = dono;
    }

    public int getQuantidade() {
        int contador = 0;

        for (Musica musica : musicas) {
            if (musica != null) {
                contador++;
            }
        }

        return contador;
    }

    public boolean adicionar(Musica musica) {
        if (musica != null) {
            musicas.add(musica);
            return true;
        }

        return false;
    }

    public Musica getNaPosicao(int indice) {
        indice--;

        if (indice < 0 || indice >= musicas.size()) {
            throw new IndexOutOfBoundsException(
                    "Erro na getNaPosicao() da Playlist! O índice (" + (indice + 1) + ") é inválido.");
        }

        return musicas.get(indice);
    }

    public boolean removerNaPosicao(int indice) {
        indice--;

        if (indice < 0 || indice >= musicas.size()) {
            throw new IndexOutOfBoundsException(
                    "Erro na removerNaPosicao() da Playlist! O ídice (" + (indice + 1) + ") é inválido.");
        }
        Musica musicaRemover = musicas.get(indice);
        musicas.remove(musicaRemover);
        return true;
    }

    public int getDuracaoTotalSegundos() {
        int duracaoTotalSeg = 0;

        for (Musica musica : musicas) {
            if (musica != null) {
                duracaoTotalSeg += musica.getDuracaoSegundos();
            }
        }

        return duracaoTotalSeg;
    }

    public void reproduzirTudo() {
        for (Musica musica : musicas) {
            if (musica != null) {
                musica.reproduzir();
            }
        }
    }

}