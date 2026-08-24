import java.util.Scanner;

public class Plataforma {
    Scanner scan = new Scanner(System.in);

    private final int MAX = 500;
    private Musica musicas[] = new Musica[MAX];
    private Usuario usuarios[] = new Usuario[MAX];
    private Playlist playlists[] = new Playlist[15];

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
            if(usuarios[i] == null && usuarioNovo(usuario)){
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

    public Usuario buscarUsuario(String nome){
        for(int i = 0; i < (MAX - 1); i++){
            if(nome == usuarios[i].getNome()){
                return usuarios[i];
            }
        }

        System.out.println("Usuário não encontrado!");
        return null;
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

    // --------------- Métodos Auxiliares:

    public boolean usuarioNovo(Usuario usuario){
        for(int i = 0; i < (MAX-1); i++){
            if(usuario.getNome() == usuarios[i].getNome()){
                System.out.println("Nome de usuário já utilizado");
                return false;
            }

            if(usuario.getEmail() == usuarios[i].getEmail()){
                System.out.println("E-mail de usuário já utilizado");
                return false;
            }
        }

        return true;
    }



    // -------------- Métodos (Main):

    public void cadastrarMusicaManualmente(){
        Musica musica;
        String titulo;
        String artista;
        int duracaoSegundos;

        System.out.print("Digite o titulo da música: ");
        titulo = scan.next();
        System.out.print("Digite o artista da música: ");
        artista = scan.next();
        System.out.print("Digite a duração total em segundos da música: ");
        
        while(!scan.hasNextInt()){
            System.out.print("Duração da música inválida! Tente novamente...");
            System.out.print("Digite a duração total em segundos da música: ");

            scan.nextInt();
        }
        duracaoSegundos = scan.nextInt();

        musica = new Musica(titulo, artista, duracaoSegundos);
        cadastrarMusica(musica);
    }

    public void cadastrarUsuarioManualmente(){
        Usuario usuario;
        String nome;
        String email;

        System.out.print("Digite o nome do ususário: ");
        nome = scan.next();
        System.out.print("Digite o email do usuario: ");
        email = scan.next();

        usuario = new Usuario(nome, email);
        cadastrarUsuario(usuario);
    }

    public void criarPlaylistEAdicionarMusicas(){
        Playlist playlist;
        String nome;
        Usuario dono;

        System.out.print("Digite o nome da playlist: ");
        nome = scan.next();
        System.out.print("Digite o nome do usuário: ");
        dono = buscarUsuario(scan.next());
    }

        
}
