public class Podcast extends Conteudo {
    private String apresentador;
    private int numeroEpisodio;

    public Podcast(String titulo, int duracaoSegundos, String apresentador, int numeroEpisodio) {
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

    public int getNumeroEpisodio(){
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio){
        if(numeroEpisodio <= 0){
            throw new IllegalArgumentException("O número do episódio deve ser maior que zero!");
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
        return "Podcast == [" + getId() + "] " + super.toString() + ", apresentador: "+getApresentador()+", Album: "+getNumeroEpisodio();
    }

}
