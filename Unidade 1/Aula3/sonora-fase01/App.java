import java.util.Scanner;

public class App {
    public static void main(String args[]){
        Plataforma plataforma = new Plataforma();

        //  ----- Apenas testando
        
        Musica musica1 = new Musica("titulo1", "artista1", 65);
        Musica musica2 = new Musica("titulo2", "artista2", 70);
        Musica musica3 = new Musica("titulo3", "artista3", 75);

        plataforma.cadastrarMusica(musica1);
        plataforma.cadastrarMusica(musica2);
        plataforma.cadastrarMusica(musica3);

        //  ----- Tela inicial

        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        do{
            System.out.println();
            System.out.println("=== Sonora ===");
            System.out.println("1 - Cadastrar música manualmente");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Criar playlist e adicionar músicas");
            System.out.println("4 - Buscar música por id");
            System.out.println("5 - Buscar música por título");
            System.out.println("6 - Reproduzir uma música");
            System.out.println("7 - Listar acervo");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print(">> ");

            while(!scan.hasNextInt()) { 
                System.out.println("Dígito inválido, tente novamente!");
                System.out.print(">> ");
                scan.nextInt();
            }

            opcao = scan.nextInt();
            
            System.out.println();

            switch(opcao){
                case 0: System.out.println("Saindo do sonora... "); break;
                case 1: cadastrarMusicaManualmente(scan, plataforma); break;
                case 2: cadastrarUsuarioManualmente(scan, plataforma); break;
                case 3: criarPlaylistEAdicionarMusicas(scan, plataforma); break;
                case 4: buscarMusicaPorId(scan, plataforma); break;
                case 5: buscarMusicaPorTitulo(scan, plataforma); break;
                case 6: reproduzirUmaMusica(scan, plataforma); break;
                case 7: listarAcervo(plataforma); break;
                
                default:System.out.println("Dígito inválido, tente novamente!");

            }

        }while(opcao != 0);

        scan.close();

    }

    // -------------- Métodos (Main):

    public static void cadastrarMusicaManualmente(Scanner scan, Plataforma plataforma) {
        Musica musica;
        String titulo;
        String artista;
        int duracaoSegundos;

        scan.nextLine(); // Limpando buffer

        System.out.print("Digite o titulo da música: ");
        titulo = scan.nextLine();
        System.out.print("Digite o artista da música: ");
        artista = scan.nextLine();
        System.out.print("Digite a duração total em segundos da música: ");

        while (!scan.hasNextInt()) {
            System.out.print("Duração da música inválida! Tente novamente...");
            System.out.print("Digite a duração total em segundos da música: ");

            scan.nextInt();
        }
        duracaoSegundos = scan.nextInt();

        musica = new Musica(titulo, artista, duracaoSegundos);
        plataforma.cadastrarMusica(musica);
        System.out.println("Música cadastrada com sucessso!");
    }

    public static void cadastrarUsuarioManualmente(Scanner scan, Plataforma plataforma) {
        Usuario usuario;
        String nome;
        String email;

        scan.nextLine(); // Limpando buffer

        System.out.print("Digite o nome do ususário: ");
        nome = scan.nextLine();
        System.out.print("Digite o email do usuario: ");
        email = scan.nextLine();

        usuario = new Usuario(nome, email);
        plataforma.cadastrarUsuario(usuario);
    }

    public static void criarPlaylistEAdicionarMusicas(Scanner scan, Plataforma plataforma) {
        Playlist playlist;
        String nome;
        Usuario dono;
        char continuar;

        scan.nextLine(); // Limpando buffer

        System.out.print("Digite o nome da playlist: ");
        nome = scan.nextLine();

        do {
            System.out.print("Digite o nome do usuário: ");
            dono = plataforma.buscarUsuario(scan.nextLine());
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
            musica = plataforma.buscarMusica(scan.nextLine());

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

    public static void buscarMusicaPorId(Scanner scan, Plataforma plataforma) {
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
        musicaTemp = plataforma.buscarMusicaPorId(indice);

        System.out.println("Titulo da Música: " + musicaTemp.getTitulo());
        System.out.println("Artista da Música: " + musicaTemp.getArtista());
        System.out.println("Duração: " + musicaTemp.getDuracaoFormatada());
        System.out.println("Reproduções: " + musicaTemp.getReproducoes());

    }

    public static void buscarMusicaPorTitulo(Scanner scan, Plataforma plataforma) {
        String titulo;
        Musica musicaTemp;
        System.out.println("Digite o titulo da música: ");
        System.out.print(">> ");

        scan.nextLine(); // Limpando buffer

        titulo = scan.nextLine();
        musicaTemp = plataforma.buscarMusica(titulo);

        System.out.println("Titulo da Música: " + musicaTemp.getTitulo());
        System.out.println("Artista da Música: " + musicaTemp.getArtista());
        System.out.println("Duração: " + musicaTemp.getDuracaoFormatada());
        System.out.println("Reproduções: " + musicaTemp.getReproducoes());
    }

    public static void reproduzirUmaMusica(Scanner scan, Plataforma plataforma) {
        String titulo;
        Musica musicaTemp;
        System.out.println("Digite o título da música que você deseja reproduzir: ");
        System.out.print(">> ");

        scan.nextLine(); // Limpando buffer

        titulo = scan.nextLine();

        musicaTemp = plataforma.buscarMusica(titulo);
        if (musicaTemp != null) {
            musicaTemp.reproduzir();
        }
    }

    public static void listarAcervo(Plataforma plataforma){
        System.out.println("\n--- Acervo Sonora ---");
        
        Musica[] acervo = plataforma.getMusicas();
        for(int i = 0; i < acervo.length; i++){
            if(acervo[i] != null){
                System.out.printf(acervo[i].toString()+"\n");
            }
        }
    }

}
