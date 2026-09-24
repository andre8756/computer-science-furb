
public class Musica extends Conteudo {
    private String artista;
    private String album;

    public Musica(String titulo, String artista, String album, int duracaoSegundos) {
        super(titulo, duracaoSegundos);
        setArtista(artista);
    }

    public String getArtista() {
        return artista;
    }

    private void setArtista(String artista) {
        if (artista == null || artista.isBlank()) {
            throw new IllegalArgumentException("O artista não pode estar vazio!");
        }

        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        if (album.isBlank() || album == null) {
            throw new IllegalArgumentException("O album não pode estar vazio!!");
        }

        this.album = album;
    }

    public String getDuracaoFormatada() {
        int minutos = super.getDuracaoSegundos() / 60;
        int segundos = super.getDuracaoSegundos() % 60;

        return String.format("%02d:%02d", minutos, segundos);
    }

    @Override
    public String toString() {
        return super.toString() + " - " + artista
                + " (" + album + ")";
    }

}
