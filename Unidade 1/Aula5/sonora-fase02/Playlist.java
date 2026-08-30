public class Playlist {
    private String nome;
    private Usuario dono;
    private int quantidadeMax = 100;
    private Musica musicas[] = new Musica[quantidadeMax];

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

        for (int i = 0; i < 99; i++) {
            if (musicas[i] != null) {
                contador++;
            }
        }

        return contador;
    }

    public boolean adicionar(Musica musica) {

        for (int i = 0; i < 99; i++) {
            if (musicas[i] == null && musica != null) {
                musicas[i] = musica;
                return true;
            }
        }

        return false;
    }

    public Musica getNaPosicao(int indice) {
        indice--;

        if (indice < 0 || indice >= musicas.length) {
            throw new IndexOutOfBoundsException(
                    "Erro na getNaPosicao() da Playlist! O índice (" + (indice + 1) + ") é inválido.");
        }

        return musicas[indice];
    }

    public boolean removerNaPosicao(int indice) {
        if (indice >= 0 && indice <= 99) {
            musicas[indice] = null;
            organizarPlaylist();
            return true;
        }
        return false;
    }

    public int getDuracaoTotalSegundos() {
        int duracaoTotalSeg = 0;

        for (int i = 0; i < quantidadeMax; i++) {

            if (musicas[i] != null) {
                duracaoTotalSeg += musicas[i].getDuracaoSegundos();
            }
        }

        return duracaoTotalSeg;
    }

    public void reproduzirTudo() {

        for (int i = 0; i < quantidadeMax; i++) {

            if (musicas[i] != null) {
                musicas[i].reproduzir();
            }
        }
    }

    // --------- Metodos Auxiliares

    public void organizarPlaylist() {
        boolean troca = true;
        Musica musicaTemp;

        while (troca) {
            troca = false;

            for (int i = 0; i < (quantidadeMax - 1); i++) {
                if (musicas[i] == null && musicas[i + 1] != null) {
                    troca = true;

                    musicaTemp = musicas[i];
                    musicas[i] = musicas[i + 1];
                    musicas[i + 1] = musicaTemp;
                }
            }
        }
    }

}