public class Musica {
    private final int id;
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private int reproducoes;
    private static int contadorId = 0;

    public Musica(String titulo, String artista, int duracaoSegundos){
        contadorId++;
        this.id = contadorId;
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        reproducoes = 0;
    }

    public int getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getArtista(){
        return artista;
    }

    public int getDuracaoSegundos(){
        return duracaoSegundos;
    }

    public int getReproducoes(){
        return reproducoes;
    }

    public void reproduzir(){
        reproducoes++;
    }

    public String getDuracaoFormatada(){
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;

        return String.format("%02d:%02d", minutos, segundos);
    }

    @Override
    public String toString(){
        return String.format("%d - %s (%s) | Duração: %s | Reproduções: %d", 
        id, titulo, artista, getDuracaoFormatada(), reproducoes);
    }

}
