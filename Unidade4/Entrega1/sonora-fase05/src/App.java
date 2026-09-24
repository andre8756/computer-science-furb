
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String args[]) {
        Plataforma plataforma = new Plataforma();

        // ----- Apenas testando

        Musica musica1 = new Musica("titulo1", "artista1", "djavan", 65);
        Musica musica2 = new Musica("titulo2", "artista2", "album2", 70);
        Musica musica3 = new Musica("titulo3", "artista3", "album3", 75);

        Podcast podcast1 = new Podcast("podcast1", 5400, "apresentador1", 1);
        Podcast podcast2 = new Podcast("podcast2", 5450, "apresentador2", 2);
        Podcast podcast3 = new Podcast("podcast3", 5600, "apresentador3", 3);

        plataforma.cadastrarMusica(musica1);
        plataforma.cadastrarMusica(musica2);
        plataforma.cadastrarMusica(musica3);

        // ----- Tela inicial

        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("=== Sonora ===");
            System.out.println("1 - Cadastrar música manualmente");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Criar playlist e adicionar músicas");
            System.out.println("4 - Buscar música por id");
            System.out.println("5 - Buscar música por título");
            System.out.println("6 - Reproduzir uma música");
            System.out.println("7 - Listar acervo");
            System.out.println("8 - Seguir usuário");
            System.out.println("9 - Deixar de seguir usuário");
            System.out.println("10 - Ver quantidade de usuários seguindo");
            System.out.println("0 - Sair");
            System.out.println();

            while (true) {
                try {
                    System.out.print(">> ");
                    opcao = Integer.parseInt(scan.nextLine());
                    break;
                } catch (NumberFormatException exception) {
                    System.out.println("Valor inválido! Digite um número:");
                }
            }

            System.out.println();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do sonora... ");
                    break;
                case 1:
                    cadastrarMusicaManualmente(scan, plataforma);
                    break;
                case 2:
                    cadastrarUsuarioManualmente(scan, plataforma);
                    break;
                case 3:
                    criarPlaylistEAdicionarMusicas(scan, plataforma);
                    break;
                case 4:
                    buscarMusicaPorId(scan, plataforma);
                    break;
                case 5:
                    buscarMusicaPorTitulo(scan, plataforma);
                    break;
                case 6:
                    reproduzirUmaMusica(scan, plataforma);
                    break;
                case 7:
                    listarAcervo(plataforma);
                    break;
                case 8:
                    seguirUsuario(scan, plataforma);
                    break;

                case 9:
                    deixarDeSeguirUsuario(scan, plataforma);
                    break;

                case 10:
                    consultarQuantidadeSeguindo(scan, plataforma);
                    break;
                default:
                    System.out.println("Dígito inválido, tente novamente!");

            }

        } while (opcao != 0);

        scan.close();

    }

    // -------------- Métodos (Main):

    public static void cadastrarMusicaManualmente(Scanner scan, Plataforma plataforma) {
        Musica musica;
        String titulo;
        String artista;
        String album;
        int duracaoSegundos;

        scan.nextLine(); // Limpando buffer

        System.out.print("Digite o titulo da música: ");
        titulo = scan.nextLine();
        System.out.print("Digite o artista da música: ");
        artista = scan.nextLine();
        System.out.print("Digite o album da música: ");
        album = scan.nextLine();

        while (true) {
            try {
                System.out.print("Digite a duração total em segundos da música: ");
                duracaoSegundos = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException exception) {
                System.out.print("Valor invalido. Digite um número válido.");
            }
        }

        try {
            musica = new Musica(titulo, artista, album, duracaoSegundos);
            plataforma.cadastrarMusica(musica);
            if (plataforma.cadastrarMusica(musica)) {
                System.out.println("Música cadastrada com sucesso!");
            } else {
                System.out.println("Não foi possível cadastrar a música.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Houve um erro: " + exception.getMessage());
        }
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

        try {

            usuario = new Usuario(nome, email);
            plataforma.cadastrarUsuario(usuario);
            if (plataforma.cadastrarUsuario(usuario)) {
                System.out.println("Usuário cadastrado com sucesso!");
            } else {
                System.out.println("Não foi possível cadastrar o usuário.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Houve um erro ao cadastrar o usuário: " + exception.getMessage());
        }

    }

    public static int criarPlaylistEAdicionarMusicas(Scanner scan, Plataforma plataforma) {
        Playlist playlist;
        String nome;
        Usuario dono;
        char continuar;

        scan.nextLine(); // Limpando buffer

        System.out.print("Digite o nome da playlist: ");
        nome = scan.nextLine();

        System.out.print("Digite o nome do usuário: ");
        dono = plataforma.buscarUsuario(scan.nextLine());

        if (dono == null) {
            return 1;
        }

        try {
            playlist = new Playlist(nome, dono);

            if (!plataforma.cadastrarPlaylist(playlist)) {
                System.out.println("Não foi possível cadastrar a playlist.");
                return 1;
            }

            System.out.println("");
            System.out
                    .println(
                            "Playlist criada com sucesso, vocẽ deseja adicionar uma música existente à playlist? (s/n) ");
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
                scan.nextLine(); // limpando buffer

            }

            System.out.println("Saindo da playlist!! ");
            System.out.println();

            return 0;
        } catch (IllegalArgumentException exception) {
            System.out.println("Não foi possível criar a Playlist: " + exception.getMessage());
            return 1;
        }

    }

    public static void buscarMusicaPorId(Scanner scan, Plataforma plataforma) {
        int indice;
        Musica musicaTemp;
        scan.nextLine(); // Limpando buffer
        System.out.println("Digite o id da música: ");

        try {
            System.out.print(">> ");
            indice = Integer.parseInt(scan.nextLine());

            musicaTemp = plataforma.buscarMusicaPorId(indice);

            if (musicaTemp != null) {
                System.out.println("Titulo da Música: " + musicaTemp.getTitulo());
                System.out.println("Artista da Música: " + musicaTemp.getArtista());
                System.out.println("Duração: " + musicaTemp.getDuracaoFormatada());
                System.out.println("Reproduções: " + musicaTemp.getReproducoes());
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("A posição precisa ser um número.");
        } catch (NumberFormatException exception) {
            System.out.println("Esta posição não existe na Plataforma");
        } finally {
            System.out.println("--- Fim da busca ---");
        }
    }

    public static void buscarMusicaPorTitulo(Scanner scan, Plataforma plataforma) {
        String titulo;
        Musica musicaTemp;
        scan.nextLine(); // Limpando buffer
        System.out.println("Digite o titulo da música: ");
        System.out.print(">> ");

        titulo = scan.nextLine();
        musicaTemp = plataforma.buscarMusica(titulo);

        if (musicaTemp != null) {
            System.out.println("Titulo da Música: " + musicaTemp.getTitulo());
            System.out.println("Artista da Música: " + musicaTemp.getArtista());
            System.out.println("Duração: " + musicaTemp.getDuracaoFormatada());
            System.out.println("Reproduções: " + musicaTemp.getReproducoes());
        }
    }

    public static void reproduzirUmaMusica(Scanner scan, Plataforma plataforma) {
        scan.nextLine(); // Limpando buffer

        String titulo;
        Musica musicaTemp;
        System.out.println("Digite o título da música que você deseja reproduzir: ");
        System.out.print(">> ");

        titulo = scan.nextLine();

        musicaTemp = plataforma.buscarMusica(titulo);
        if (musicaTemp != null) {
            musicaTemp.reproduzir();
        }
    }

    // Precisa acabar esse método
    public static void removerMusica(Scanner scan, Plataforma plataforma) {
        System.out.println();
    }

    public static void listarAcervo(Plataforma plataforma) {
        System.out.println("\n--- Acervo Sonora ---");

        ArrayList<Musica> acervo = plataforma.getMusicas();
        for (Musica musica : acervo) {
            System.out.printf(musica.toString() + "\n");
        }
    }

    public static void seguirUsuario(Scanner scan, Plataforma plataforma) {

        scan.nextLine();

        System.out.print("Digite o nome do usuário que irá seguir: ");
        String nomeSeguidor = scan.nextLine();

        System.out.print("Digite o nome do usuário que deseja seguir: ");
        String nomeSeguido = scan.nextLine();

        try {
            if (plataforma.seguir(nomeSeguidor, nomeSeguido)) {
                System.out.println(
                        nomeSeguidor + " agora está seguindo " + nomeSeguido + "!");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Não foi possível seguir o usuário: "
                    + exception.getMessage());
        }
    }

    public static void deixarDeSeguirUsuario(Scanner scan, Plataforma plataforma) {

        scan.nextLine();

        System.out.print("Digite o nome do usuário: ");
        String nomeSeguidor = scan.nextLine();

        System.out.print("Digite o nome do usuário que deseja deixar de seguir: ");
        String nomeSeguido = scan.nextLine();

        try {
            if (plataforma.deixarDeSeguir(nomeSeguidor, nomeSeguido)) {
                System.out.println(
                        nomeSeguidor + " deixou de seguir " + nomeSeguido + "!");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Não foi possível deixar de seguir: "
                    + exception.getMessage());
        }
    }

    public static void consultarQuantidadeSeguindo(
            Scanner scan, Plataforma plataforma) {

        scan.nextLine();

        System.out.print("Digite o nome do usuário: ");
        String nome = scan.nextLine();

        Usuario usuario = plataforma.buscarUsuario(nome);

        if (usuario != null) {
            System.out.println(
                    usuario.getNome()
                            + " está seguindo "
                            + usuario.getQuantidadeSeguindo()
                            + " usuário(s).");
        }
    }

}
