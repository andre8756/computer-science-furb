import java.util.Scanner;

public class Plataforma {
    Scanner scan = new Scanner(System.in);

    private final int MAX = 500;
    private Musica musicas[] = new Musica[MAX];
    private Usuario usuarios[] = new Usuario[MAX];
    private Playlist playlists[] = new Playlist[15];

    // ------- Cadastros

    public boolean cadastrarMusica(Musica musica) {

        for (int i = 0; i < (MAX - 1); i++) {
            if (musicas[i] == null && musicaNova(musica)) {
                musicas[i] = musica;
                return true;
            }
        }

        return false;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        for (int i = 0; i < (MAX - 1); i++) {
            if (usuarios[i] == null && usuarioNovo(usuario)) {
                usuarios[i] = usuario;
                return true;
            }
        }

        return false;
    }

    public boolean cadastrarPlaylist(Playlist playlist) {
        for (int i = 0; i < (MAX - 1); i++) {
            if (playlists[i] == null && playlistNova(playlist)) {
                playlists[i] = playlist;
                return true;
            }
        }

        return false;
    }

    // -------- Métodos de busca

    public Musica buscarMusicaPorId(int id) {
        for (int i = 0; i < (MAX - 1); i++) {
            if (musicas[i].getId() == id) {
                return musicas[i];
            }
        }

        return null;
    }

    public Musica buscarMusica(String titulo) {
        for (int i = 0; i < (MAX - 1); i++) {

            if (musicas[i] != null) {
                if (musicas[i].getTitulo().equals(titulo)) {
                    return musicas[i];
                }
            }
        }

        System.out.println("Música não encontrada!");
        return null;
    }

    public int getTotalMusicas() {
        int contador = 0;

        for (int i = 0; i < (MAX - 1); i++) {
            if (musicas[i] != null) {
                contador++;
            }
        }

        return contador;
    }

    public Usuario buscarUsuario(String nome) {
        for (int i = 0; i < (MAX - 1); i++) {

            if (usuarios[i] != null) {
                if (nome.equals(usuarios[i].getNome())) {
                    return usuarios[i];
                }
            }

        }

        System.out.println("Usuário não encontrado!");
        return null;
    }

    public int getTotalUsuarios() {
        int contador = 0;

        for (int i = 0; i < (MAX - 1); i++) {
            if (usuarios[i] != null) {
                contador++;
            }
        }

        return contador;
    }

    public Playlist buscarPlaylist(String nome) {
        for (int i = 0; i < 14; i++) {
            if (playlists[i].getNome().equals(nome)) {
                return playlists[i];
            }
        }

        return null;
    }

    // --------------- Métodos Auxiliares:

    private boolean musicaNova(Musica musica) {
        for (int i = 0; i < (MAX - 1); i++) {
            if (musicas[i] != null) {
                if (musica.getTitulo().equals(musicas[i].getTitulo())) {
                    System.out.println("Já existe uma música com este título!!");
                    return false;
                }
            }
        }

        return true;
    }

    private boolean usuarioNovo(Usuario usuario) {
        for (int i = 0; i < (MAX - 1); i++) {

            if (usuarios[i] != null) {
                if (usuario.getNome().equals(usuarios[i].getNome())) {
                    System.out.println("Nome de usuário já utilizado");
                    return false;
                }

                if (usuario.getEmail().equals(usuarios[i].getEmail())) {
                    System.out.println("E-mail de usuário já utilizado");
                    return false;
                }
            }
        }

        return true;
    }

    private boolean playlistNova(Playlist playlist) {
        for (int i = 0; i < (14); i++) {
            if (playlist.getNome().equals(playlists[i].getNome())) {
                System.out.println("Já existe uma playlist com este nome!!");
                return false;
            }
        }

        return true;
    }

    // -------------- Métodos (Main):

    public void cadastrarMusicaManualmente() {
        Musica musica;
        String titulo;
        String artista;
        int duracaoSegundos;

        System.out.print("Digite o titulo da música: ");
        titulo = scan.next();
        System.out.print("Digite o artista da música: ");
        artista = scan.next();
        System.out.print("Digite a duração total em segundos da música: ");

        while (!scan.hasNextInt()) {
            System.out.print("Duração da música inválida! Tente novamente...");
            System.out.print("Digite a duração total em segundos da música: ");

            scan.nextInt();
        }
        duracaoSegundos = scan.nextInt();

        musica = new Musica(titulo, artista, duracaoSegundos);
        cadastrarMusica(musica);
        System.out.println("Música cadastrada com sucessso!");
    }

    public void cadastrarUsuarioManualmente() {
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

    public void criarPlaylistEAdicionarMusicas() {
        Playlist playlist;
        String nome;
        Usuario dono;
        char continuar;

        System.out.print("Digite o nome da playlist: ");
        nome = scan.next();

        do {
            System.out.print("Digite o nome do usuário: ");
            dono = buscarUsuario(scan.next());
        } while (dono == null);

        playlist = new Playlist(nome, dono);

        System.out.println("");
        System.out
                .println("Playlist criada com sucesso, vocẽ deseja adicionar uma música existente à playlist? (s/n) ");
        System.out.print(">> ");
        continuar = scan.next().toUpperCase().charAt(0);

        while (continuar == 'S') {
            Musica musica;

            System.out.println("Digite o título da música: ");
            musica = buscarMusica(scan.next());

            if (musica != null) {
                playlist.adicionar(musica);
            }

            System.out.println();
            System.out.println("Deseja adicionar outra música? (s/n) ");
            System.out.print(">> ");
            continuar = scan.next().toUpperCase().charAt(0);

        }

        System.out.println("Saindo da playlist!! ");
        System.out.println();
    }

    public void buscarMusicaPorId() {
        int indice;
        Musica musicaTemp;
        System.out.println("Digite o id da música: ");
        System.out.print(">> ");

        while (!scan.hasNextInt()) {
            System.out.println("Dígito inválido, tente novamente!");
            System.out.print(">> ");
            scan.nextInt();
        }

        indice = scan.nextInt();
        musicaTemp = buscarMusicaPorId(indice);

        System.out.println("Titulo da Música: " + musicaTemp.getTitulo());
        System.out.println("Artista da Música: " + musicaTemp.getArtista());
        System.out.println("Duração: " + musicaTemp.getDuracaoFormatada());
        System.out.println("Reproduções: " + musicaTemp.getReproducoes());

    }

    public void buscarMusicaPorTitulo() {
        String titulo;
        Musica musicaTemp;
        System.out.println("Digite o titulo da música: ");
        System.out.print(">> ");
        titulo = scan.next();
        musicaTemp = buscarMusica(titulo);

        System.out.println("Titulo da Música: " + musicaTemp.getTitulo());
        System.out.println("Artista da Música: " + musicaTemp.getArtista());
        System.out.println("Duração: " + musicaTemp.getDuracaoFormatada());
        System.out.println("Reproduções: " + musicaTemp.getReproducoes());
    }

    public void reproduzirUmaMusica() {
        String titulo;
        Musica musicaTemp;
        System.out.println("Digite o título da música que você deseja reproduzir: ");
        System.out.print(">> ");
        titulo = scan.next();

        musicaTemp = buscarMusica(titulo);
        if (musicaTemp != null) {
            musicaTemp.reproduzir();
        }
    }

    public void listarAcervo(){
        System.out.println("    Id   Nome    Artista     Duração   Reproduções");
        for(int i = 0; i < (MAX-1); i++){
            if(musicas[i] != null){
                System.out.printf("   %d   %s    %s    %s     %d\n", 
                musicas[i].getId(), musicas[i].getTitulo(),
            musicas[i].getArtista(), musicas[i].getDuracaoFormatada(),
            musicas[i].getReproducoes());
            }
        }
    }

}
