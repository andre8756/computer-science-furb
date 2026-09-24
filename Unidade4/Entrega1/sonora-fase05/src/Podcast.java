public class Podcast extends Conteudo {
    private String apresentador;
    private String numeroEpisodio;

    public Podcast(String titulo, int duracaoSegundos, String apresentador, String numeroEpisodio) {
        super(titulo, duracaoSegundos);
        setApresentador(apresentador);
        setNumeroEpisodio(numeroEpisodio);
    }

    public String getApresentador(){
        return apresentador;
    }

    public void setApresentador(String host){
        if(host == null || host.isBlank()){
            throw new IllegalArgumentException("O campo host não pode estar vazio!");
        }

        this.apresentador = host;
    }

    public String getNumeroEpisodio(){
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(String numeroEpisodio){
        if(numeroEpisodio == null || numeroEpisodio.isBlank()){
            throw new IllegalArgumentException("O campo album não pode estar vazio!");
        }

        this.numeroEpisodio = numeroEpisodio;
    }

    public String getDuracaoFormatada() {
        int horas = super.getDuracaoSegundos() / 3600;
        int resto = super.getDuracaoSegundos() % 3600;
        int minutos = resto / 60;
        int segundos = resto % 60;

        return String.format("%02d:%02d%02d",horas, minutos, segundos);
    }

    @Override
    public String toString() {
        return "Podcast == [" + getId() + "] " + super.toString() + ", apresentador: "+getApresentador()+", Album: "+getNumeroEpisod();
    }

}
