import java.util.Scanner;

public class Plataforma {
    Scanner scan = new Scanner(System.in);

    private final int MAX = 500;
    private Musica musicas[] = new Musica[MAX];
    private Usuario usuarios[] = new Usuario[MAX];
    private Playlist playlists[] = new Playlist[15];

    // ------- Cadastros

    public boolean cadastrarMusica(Musica musica) {
        
        if(musica == null){
            throw new IllegalArgumentException("Erro em cadastrarMusica() da Plataforma! Não foi possível cadastrar a música.");
        }

        if(!musicaNova(musica)){
                return false;
            }

        for (int i = 0; i < MAX ; i++) {
            if (musicas[i] == null) {
                musicas[i] = musica;
                return true;
            }
        }

        return false;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        
        if(!usuarioNovo(usuario)){
            return false;
        }
        
        for (int i = 0; i < MAX; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = usuario;
                return true;
            }
        }

        return false;
    }

    public boolean cadastrarPlaylist(Playlist playlist) {

        if(!playlistNova(playlist)){
            return false;
        }

        for (int i = 0; i < MAX; i++) {
            if (playlists[i] == null) {
                playlists[i] = playlist;
                return true;
            }
        }

        return false;
    }

    // -------- Métodos de busca

    public Musica buscarMusicaPorId(int id) {
        for (int i = 0; i < MAX; i++) {
            if (musicas[i].getId() == id) {
                return musicas[i];
            }
        }

        return null;
    }

    public Musica buscarMusica(String titulo) {
        for (int i = 0; i < MAX; i++) {

            if (musicas[i] != null) {
                if (musicas[i].getTitulo().equalsIgnoreCase(titulo)) {
                    return musicas[i];
                }
            }
        }

        System.out.println("Música não encontrada!");
        return null;
    }

    public int getTotalMusicas() {
        int contador = 0;

        for (int i = 0; i < MAX; i++) {
            if (musicas[i] != null) {
                contador++;
            }
        }

        return contador;
    }

    public Usuario buscarUsuario(String nome) {
        for (int i = 0; i < MAX; i++) {

            if (usuarios[i] != null) {
                if (nome.equalsIgnoreCase(usuarios[i].getNome())) {
                    return usuarios[i];
                }
            }

        }

        System.out.println("Usuário não encontrado!");
        return null;
    }

    public int getTotalUsuarios() {
        int contador = 0;

        for (int i = 0; i < MAX; i++) {
            if (usuarios[i] != null) {
                contador++;
            }
        }

        return contador;
    }

    public Playlist buscarPlaylist(String nome) {
        for (int i = 0; i < 14; i++) {
            if (playlists[i].getNome().equalsIgnoreCase(nome)) {
                return playlists[i];
            }
        }

        return null;
    }

    // --------------- Métodos Auxiliares:

    private boolean musicaNova(Musica musica) {
        for (int i = 0; i < MAX; i++) {
            if (musicas[i] != null) {
                if (musica.getTitulo().equalsIgnoreCase(musicas[i].getTitulo())) {
                    System.out.println("Já existe uma música com este título!!");
                    return false;
                }
            }
        }

        return true;
    }

    private boolean usuarioNovo(Usuario usuario) {
        for (int i = 0; i < MAX; i++) {

            if (usuarios[i] != null) {
                if (usuario.getNome().equalsIgnoreCase(usuarios[i].getNome())) {
                    System.out.println("Nome de usuário já utilizado");
                    return false;
                }

                if (usuario.getEmail().equalsIgnoreCase(usuarios[i].getEmail())) {
                    System.out.println("E-mail de usuário já utilizado");
                    return false;
                }
            }
        }

        return true;
    }

    private boolean playlistNova(Playlist playlist) {
        for (int i = 0; i < (14); i++) {
            if (playlist.getNome().equalsIgnoreCase(playlists[i].getNome())) {
                System.out.println("Já existe uma playlist com este nome!!");
                return false;
            }
        }

        return true;
    }

    public Musica[] getMusicas(){
        return musicas;
    }

    
}
