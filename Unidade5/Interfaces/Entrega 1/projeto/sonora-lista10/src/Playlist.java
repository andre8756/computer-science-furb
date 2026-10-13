import java.util.ArrayList;

public class Playlist {
    private String nome;
    private Usuario dono;
    private ArrayList<Conteudo> conteudos = new ArrayList<>();

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

        for (Conteudo conteudo : conteudos) {
            if (conteudo != null) {
                contador++;
            }
        }

        return contador;
    }

    public boolean adicionar(Conteudo conteudo) {
        if (conteudo != null) {
            conteudos.add(conteudo);
            return true;
        }

        return false;
    }

    public Conteudo getNaPosicao(int indice) {
        indice--;

        if (indice < 0 || indice >= conteudos.size()) {
            throw new IndexOutOfBoundsException(
                    "Erro na getNaPosicao() da Playlist! O índice (" + (indice + 1) + ") é inválido.");
        }

        return conteudos.get(indice);
    }

    public boolean removerNaPosicao(int indice) {
        indice--;

        if (indice < 0 || indice >= conteudos.size()) {
            throw new IndexOutOfBoundsException(
                    "Erro na removerNaPosicao() da Playlist! O ídice (" + (indice + 1) + ") é inválido.");
        }
        Conteudo conteudoRemover = conteudos.get(indice);
        conteudos.remove(conteudoRemover);
        return true;
    }

    public int getDuracaoTotalSegundos() {
        int duracaoTotalSeg = 0;

        for (Conteudo conteudo : conteudos) {
            if (conteudo != null) {
                duracaoTotalSeg += conteudo.getDuracaoSegundos();
            }
        }

        return duracaoTotalSeg;
    }

    public ArrayList<Conteudo> getConteudos(){
        return conteudos;
    }

    public void reproduzirTudo() {
        for (Conteudo conteudo : conteudos) {
            if (conteudo != null) {
                conteudo.reproduzir();
            }
        }
    }

}