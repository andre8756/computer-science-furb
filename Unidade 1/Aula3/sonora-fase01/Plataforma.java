public class Plataforma {

    int MAX = 500;
    Musica musicas[] = new Musica[MAX];
    Usuario usuarios[] = new Usuario[MAX];

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

    public boolean verificarEspacoMusicas(){
        for(int i = 0; i < MAX-1; i++){
            if(musicas[i] == null){
                return true;
            }
        }

        return false;
    }

        
}
