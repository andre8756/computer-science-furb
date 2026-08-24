public class Plataforma {

    private final int MAX = 500;
    private Musica musicas[] = new Musica[MAX];
    private Usuario usuarios[] = new Usuario[MAX];

    public boolean cadastrarMusica(Musica musica){
        
        for(int i = 0; i < MAX; i++){
            if(musicas[i] == null){
                musicas[i] = musica;
                return true;
            }
        }

        return false;
    }

    public boolean cadastrarUsuario(Usuario usuario){
        for(int i = 0; i < MAX; i++){
            if(usuarios[i] == null){
                usuarios[i] = usuario;
                return true;
            }
        }

        return false;
    }

    public Musica buscarMusicaPorId(int id){
        for(int i = 0; i < (MAX-1); i++){
            if(musicas[i].getId() == id){
                return musicas[i];
            }
        }

        return null;
    }

    public Musica buscarMusica(String titulo){
        for(int i = 0; i < (MAX-1); i++){
            if(musicas[i].getTitulo().equals(titulo)){
                return musicas[i];
            }
        }
    
        return null;
    }
    
    public int getTotalMusicas(){
        int contador = 0;

        for(int i = 0; i < (MAX - 1); i++){
            if(musicas[i] != null){
                contador++;
            }
        }

        return contador;
    }

    public int getTotalUsuarios(){
        int contador = 0;

        for (int i = 0; i < (MAX - 1); i++){
            if(usuarios[i] != null){
                contador++;
            }
        }

        return contador;
    }
        
}
