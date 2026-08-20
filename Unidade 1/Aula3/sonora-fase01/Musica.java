public class Musica {
    private int id;
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private int reproducoes;

    public Muica(String titulo, String artista, int duracaoSegundos ){
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
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
        reproduzir++;
    }

}
