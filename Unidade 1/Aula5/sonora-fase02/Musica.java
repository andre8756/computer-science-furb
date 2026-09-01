public class Musica {
    private final int id;
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private int reproducoes;
    private static int contadorId = 0;

    public Musica(String titulo, String artista, int duracaoSegundos) {
        contadorId++;
        this.id = contadorId;
        setTitulo(titulo);
        setArtista(artista);
        setDuracaoSegundos(duracaoSegundos);
        reproducoes = 0;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        if (titulo.isBlank() || titulo.isEmpty()) {
            throw new IllegalArgumentException("O título não pode estar em branco!");
        }
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    private void setArtista(String artista){
        if(artista.isBlank() || artista.isEmpty()){
            throw new IllegalArgumentException("O artista não pode estar vazio!");
        }
        
        this.artista = artista;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    private void setDuracaoSegundos(int duracaoSegundos){
        if(duracaoSegundos <= 0){
            throw new IllegalArgumentException("A música não pode ter menos de 1 segundo!");
        }

        this.duracaoSegundos = duracaoSegundos;
    }

    public int getReproducoes() {
        return reproducoes;
    }

    public void reproduzir() {
        reproducoes++;
    }

    public String getDuracaoFormatada() {
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;

        return String.format("%02d:%02d", minutos, segundos);
    }

    @Override
    public String toString() {
        return String.format("%d - %s (%s) | Duração: %s | Reproduções: %d",
                id, titulo, artista, getDuracaoFormatada(), reproducoes);
    }

}
