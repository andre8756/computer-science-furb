public class Podcast extends Conteudo {
    private String host;
    private String tema;

    public Podcast(String titulo, int duracaoSegundos, String host, String tema) {
        super(titulo, duracaoSegundos);
        
    }

    public String getHost(){
        return host;
    }

    public void setHost(String host){
        if(host == null || host.isBlank()){
            throw new IllegalArgumentException("O campo host não pode estar vazio!");
        }

        this.host = host;
    }
}
