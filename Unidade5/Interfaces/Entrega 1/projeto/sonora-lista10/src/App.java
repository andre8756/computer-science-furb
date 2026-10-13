import java.util.ArrayList;
import java.util.Scanner;

import Planos.Plano;
import Planos.PlanoFamilia;
import Planos.PlanoGratuito;
import Planos.PlanoIndividual;

public class App {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro(scan, ">> ");
            System.out.println();

            try {
                switch (opcao) {
                    case 0:
                        System.out.println("Encerrando o Sonora...");
                        break;
                    case 1:
                        cadastrarMusica(scan, plataforma);
                        break;
                    case 2:
                        cadastrarPodcast(scan, plataforma);
                        break;
                    case 3:
                        cadastrarUsuario(scan, plataforma);
                        break;
                    case 4:
                        criarPlaylist(scan, plataforma);
                        break;
                    case 5:
                        adicionarConteudoNaPlaylist(scan, plataforma);
                        break;
                    case 6:
                        listarPlaylistsDeUsuario(scan, plataforma);
                        break;
                    case 7:
                        reproduzirPlaylist(scan, plataforma);
                        break;
                    case 8:
                        removerConteudoDaPlaylist(scan, plataforma);
                        break;
                    case 9:
                        buscarConteudoPorId(scan, plataforma);
                        break;
                    case 10:
                        buscarConteudoPorTitulo(scan, plataforma);
                        break;
                    case 11:
                        reproduzirConteudo(scan, plataforma);
                        break;
                    case 12:
                        listarAcervo(plataforma);
                        break;
                    case 13:
                        seguirUsuario(scan, plataforma);
                        break;
                    case 14:
                        deixarDeSeguirUsuario(scan, plataforma);
                        break;
                    case 15:
                        consultarQuantidadeSeguindo(scan, plataforma);
                        break;
                    case 16:
                        cadastrarAnuncio(scan, plataforma);
                        break;
                    case 17:
                        listarOuReproduzirAnuncio(scan, plataforma);
                        break;
                    case 18:
                        alterarPlanoUsuario(scan, plataforma);
                        break;
                    case 19:
                        consultarPlanoUsuario(scan, plataforma);
                        break;
                    case 20:
                        System.out.printf("Receita mensal estimada: R$ %.2f%n",
                                plataforma.calcularReceitaMensal());
                        break;
                    case 21:
                        listarPodcastsPorApresentador(scan, plataforma);
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha uma opção exibida no menu.");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Não foi possível concluir a operação: " + exception.getMessage());
            }

            System.out.println();
        } while (opcao != 0);

        scan.close();
    }

    private static void exibirMenu() {
        System.out.println("=== SONORA ===");
        System.out.println("1  - Cadastrar música");
        System.out.println("2  - Cadastrar podcast");
        System.out.println("3  - Cadastrar usuário");
        System.out.println("4  - Criar playlist");
        System.out.println("5  - Adicionar música ou podcast a uma playlist");
        System.out.println("6  - Listar playlists de um usuário");
        System.out.println("7  - Reproduzir playlist");
        System.out.println("8  - Remover conteúdo de uma playlist");
        System.out.println("9  - Buscar conteúdo por ID");
        System.out.println("10 - Buscar conteúdo por título");
        System.out.println("11 - Reproduzir música ou podcast");
        System.out.println("12 - Listar acervo");
        System.out.println("13 - Seguir usuário");
        System.out.println("14 - Deixar de seguir usuário");
        System.out.println("15 - Consultar quantos usuários alguém segue");
        System.out.println("16 - Cadastrar anúncio");
        System.out.println("17 - Listar ou reproduzir anúncio");
        System.out.println("18 - Alterar plano de usuário");
        System.out.println("19 - Consultar plano de usuário");
        System.out.println("20 - Consultar receita mensal estimada");
        System.out.println("21 - Listar podcasts por apresentador");
        System.out.println("0  - Sair");
    }

    // -------------------- Cadastros --------------------

    public static void cadastrarMusica(Scanner scan, Plataforma plataforma) {
        System.out.println("--- Cadastro de música ---");
        String titulo = lerTexto(scan, "Título: ");
        String artista = lerTexto(scan, "Artista: ");
        String album = lerTexto(scan, "Álbum: ");
        int duracao = lerInteiroPositivo(scan, "Duração em segundos: ");

        try {
            Musica musica = new Musica(titulo, artista, album, duracao);
            if (plataforma.cadastrarMusica(musica)) {
                System.out.println("Música cadastrada com sucesso. ID: " + musica.getId());
            } else {
                System.out.println("A música não foi cadastrada. O título pode já estar no acervo ou o limite foi atingido.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Dados da música inválidos: " + exception.getMessage());
        }
    }

    public static void cadastrarPodcast(Scanner scan, Plataforma plataforma) {
        System.out.println("--- Cadastro de podcast ---");
        String titulo = lerTexto(scan, "Título do episódio: ");
        int duracao = lerInteiroPositivo(scan, "Duração em segundos: ");
        String apresentador = lerTexto(scan, "Apresentador: ");
        int numeroEpisodio = lerInteiroPositivo(scan, "Número do episódio: ");

        try {
            Podcast podcast = new Podcast(titulo, duracao, apresentador, numeroEpisodio);
            if (plataforma.cadastrarPodcast(podcast)) {
                System.out.println("Podcast cadastrado com sucesso. ID: " + podcast.getId());
            } else {
                System.out.println("O podcast não foi cadastrado. O título pode já estar no acervo ou o limite foi atingido.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Dados do podcast inválidos: " + exception.getMessage());
        }
    }

    public static void cadastrarUsuario(Scanner scan, Plataforma plataforma) {
        System.out.println("--- Cadastro de usuário ---");
        String nome = lerTexto(scan, "Nome: ");
        String email = lerTexto(scan, "E-mail: ");

        try {
            Usuario usuario = new Usuario(nome, email);
            if (plataforma.cadastrarUsuario(usuario)) {
                System.out.println("Usuário cadastrado com sucesso. ID: " + usuario.getId());
            } else {
                System.out.println("Não foi possível cadastrar. Verifique se nome/e-mail já foram utilizados ou se o limite foi atingido.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Dados do usuário inválidos: " + exception.getMessage());
        }
    }

    public static void criarPlaylist(Scanner scan, Plataforma plataforma) {
        System.out.println("--- Criar playlist ---");
        String nomeUsuario = lerTexto(scan, "Nome do usuário dono da playlist: ");
        Usuario dono = plataforma.buscarUsuario(nomeUsuario);
        if (dono == null) {
            return;
        }

        String nomePlaylist = lerTexto(scan, "Nome da playlist: ");
        try {
            Playlist playlist = new Playlist(nomePlaylist, dono);
            if (dono.adicionarPlaylist(playlist)) {
                System.out.println("Playlist '" + playlist.getNome() + "' criada para " + dono.getNome() + ".");
                System.out.println("Use a opção 5 para adicionar músicas ou podcasts depois.");
            } else {
                System.out.println("Não foi possível adicionar a playlist ao usuário.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Não foi possível criar a playlist: " + exception.getMessage());
        }
    }

    public static void cadastrarAnuncio(Scanner scan, Plataforma plataforma) {
        System.out.println("--- Cadastro de anúncio ---");
        String anunciante = lerTexto(scan, "Nome do anunciante: ");
        String titulo = lerTexto(scan, "Título do anúncio: ");
        int duracao = lerInteiroPositivo(scan, "Duração em segundos: ");
        double valorPorMil = lerDoublePositivo(scan, "Valor por mil impressões (R$): ");

        try {
            Anuncio anuncio = new Anuncio(anunciante, titulo, duracao, valorPorMil);
            if (plataforma.cadastrarAnuncio(anuncio)) {
                System.out.println("Anúncio cadastrado com sucesso.");
            } else {
                System.out.println("Não foi possível cadastrar. O título pode já estar em uso ou o limite foi atingido.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Dados do anúncio inválidos: " + exception.getMessage());
        }
    }

    // -------------------- Playlists --------------------

    public static void adicionarConteudoNaPlaylist(Scanner scan, Plataforma plataforma) {
        System.out.println("--- Adicionar conteúdo à playlist ---");
        Playlist playlist = selecionarPlaylist(scan, plataforma);
        if (playlist == null) {
            return;
        }

        System.out.println("Qual tipo de conteúdo deseja adicionar?");
        System.out.println("1 - Música");
        System.out.println("2 - Podcast");
        System.out.println("3 - Qualquer conteúdo");
        int tipo = lerInteiro(scan, "Opção: ");
        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo inválido.");
            return;
        }

        String titulo = lerTexto(scan, "Título do conteúdo: ");
        Conteudo conteudo = buscarConteudoPorTipo(plataforma, titulo, tipo);
        if (conteudo == null) {
            System.out.println("Não foi encontrado conteúdo desse tipo com esse título.");
            return;
        }

        if (playlist.adicionar(conteudo)) {
            System.out.println("'" + conteudo.getTitulo() + "' adicionado à playlist '" + playlist.getNome() + "'.");
        } else {
            System.out.println("Não foi possível adicionar o conteúdo à playlist.");
        }
    }

    public static void listarPlaylistsDeUsuario(Scanner scan, Plataforma plataforma) {
        Usuario usuario = selecionarUsuario(scan, plataforma, "Nome do usuário: ");
        if (usuario == null) {
            return;
        }

        ArrayList<Playlist> playlists = usuario.getPlaylists();
        if (playlists.isEmpty()) {
            System.out.println(usuario.getNome() + " ainda não possui playlists.");
            return;
        }

        System.out.println("--- Playlists de " + usuario.getNome() + " ---");
        for (int i = 0; i < playlists.size(); i++) {
            Playlist playlist = playlists.get(i);
            System.out.printf("%d - %s | %d conteúdo(s) | duração total: %s%n",
                    i + 1, playlist.getNome(), playlist.getQuantidade(),
                    formatarDuracao(playlist.getDuracaoTotalSegundos()));
        }
    }

    public static void reproduzirPlaylist(Scanner scan, Plataforma plataforma) {
        Playlist playlist = selecionarPlaylist(scan, plataforma);
        if (playlist == null) {
            return;
        }
        if (playlist.getQuantidade() == 0) {
            System.out.println("Esta playlist está vazia.");
            return;
        }

        System.out.println("Reproduzindo playlist: " + playlist.getNome());
        playlist.reproduzirTudo();
    }

    public static void removerConteudoDaPlaylist(Scanner scan, Plataforma plataforma) {
        Playlist playlist = selecionarPlaylist(scan, plataforma);
        if (playlist == null) {
            return;
        }
        if (playlist.getQuantidade() == 0) {
            System.out.println("Esta playlist está vazia.");
            return;
        }

        listarConteudosDaPlaylist(playlist);
        int posicao = lerInteiro(scan, "Número do conteúdo a remover (0 para cancelar): ");
        if (posicao == 0) {
            System.out.println("Operação cancelada.");
            return;
        }

        try {
            if (playlist.removerNaPosicao(posicao)) {
                System.out.println("Conteúdo removido da playlist.");
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Posição inválida. Escolha um número entre 1 e " + playlist.getQuantidade() + ".");
        }
    }

    private static Playlist selecionarPlaylist(Scanner scan, Plataforma plataforma) {
        Usuario usuario = selecionarUsuario(scan, plataforma, "Nome do usuário dono da playlist: ");
        if (usuario == null) {
            return null;
        }

        ArrayList<Playlist> playlists = usuario.getPlaylists();
        if (playlists.isEmpty()) {
            System.out.println("Esse usuário ainda não possui playlists. Use a opção 4 para criar uma.");
            return null;
        }

        System.out.println("Playlists de " + usuario.getNome() + ":");
        for (int i = 0; i < playlists.size(); i++) {
            Playlist playlist = playlists.get(i);
            System.out.printf("%d - %s (%d conteúdo(s))%n", i + 1, playlist.getNome(), playlist.getQuantidade());
        }

        int escolha = lerInteiro(scan, "Escolha a playlist (0 para cancelar): ");
        if (escolha == 0) {
            return null;
        }
        if (escolha < 1 || escolha > playlists.size()) {
            System.out.println("Número de playlist inválido.");
            return null;
        }
        return playlists.get(escolha - 1);
    }

    private static void listarConteudosDaPlaylist(Playlist playlist) {
        System.out.println("--- Conteúdos da playlist: " + playlist.getNome() + " ---");
        for (int i = 1; i <= playlist.getQuantidade(); i++) {
            System.out.println(i + " - " + playlist.getNaPosicao(i));
        }
    }

    // -------------------- Busca e reprodução --------------------

    public static void buscarConteudoPorId(Scanner scan, Plataforma plataforma) {
        int id = lerInteiroPositivo(scan, "ID do conteúdo: ");
        Conteudo conteudo = plataforma.buscarConteudoPorId(id);
        exibirDetalhesConteudo(conteudo);
    }

    public static void buscarConteudoPorTitulo(Scanner scan, Plataforma plataforma) {
        String titulo = lerTexto(scan, "Título do conteúdo: ");
        exibirDetalhesConteudo(plataforma.buscarConteudo(titulo));
    }

    public static void reproduzirConteudo(Scanner scan, Plataforma plataforma) {
        String titulo = lerTexto(scan, "Título da música ou do episódio de podcast: ");
        Conteudo conteudo = plataforma.buscarConteudo(titulo);
        if (conteudo != null) {
            conteudo.reproduzir();
        }
    }

    public static void listarAcervo(Plataforma plataforma) {
        ArrayList<Conteudo> acervo = plataforma.getConteudos();
        System.out.println("--- Acervo Sonora ---");
        if (acervo.isEmpty()) {
            System.out.println("O acervo está vazio.");
            return;
        }
        for (Conteudo conteudo : acervo) {
            System.out.println(conteudo);
        }
    }

    private static Conteudo buscarConteudoPorTipo(Plataforma plataforma, String titulo, int tipo) {
        for (Conteudo conteudo : plataforma.getConteudos()) {
            boolean tipoCorreto = tipo == 3
                    || (tipo == 1 && conteudo instanceof Musica)
                    || (tipo == 2 && conteudo instanceof Podcast);
            if (tipoCorreto && conteudo.getTitulo().equalsIgnoreCase(titulo)) {
                return conteudo;
            }
        }
        return null;
    }

    private static void exibirDetalhesConteudo(Conteudo conteudo) {
        if (conteudo == null) {
            System.out.println("Conteúdo não encontrado.");
            return;
        }
        System.out.println(conteudo);
        System.out.println(conteudo.getCreditos());
    }

    // -------------------- Usuários e seguidores --------------------

    public static void seguirUsuario(Scanner scan, Plataforma plataforma) {
        String nomeSeguidor = lerTexto(scan, "Nome do usuário que irá seguir: ");
        String nomeSeguido = lerTexto(scan, "Nome do usuário que deseja seguir: ");
        try {
            if (plataforma.seguir(nomeSeguidor, nomeSeguido)) {
                System.out.println(nomeSeguidor + " agora está seguindo " + nomeSeguido + ".");
            } else {
                System.out.println("Não foi possível seguir. Confira se os dois usuários estão cadastrados.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Não foi possível seguir o usuário: " + exception.getMessage());
        }
    }

    public static void deixarDeSeguirUsuario(Scanner scan, Plataforma plataforma) {
        String nomeSeguidor = lerTexto(scan, "Nome do usuário: ");
        String nomeSeguido = lerTexto(scan, "Nome do usuário que deseja deixar de seguir: ");
        try {
            if (plataforma.deixarDeSeguir(nomeSeguidor, nomeSeguido)) {
                System.out.println(nomeSeguidor + " deixou de seguir " + nomeSeguido + ".");
            } else {
                System.out.println("Não foi possível concluir. Confira se os usuários estão cadastrados.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Não foi possível deixar de seguir: " + exception.getMessage());
        }
    }

    public static void consultarQuantidadeSeguindo(Scanner scan, Plataforma plataforma) {
        Usuario usuario = selecionarUsuario(scan, plataforma, "Nome do usuário: ");
        if (usuario != null) {
            System.out.println(usuario.getNome() + " segue " + usuario.getQuantidadeSeguindo() + " usuário(s).");
        }
    }

    // -------------------- Anúncios --------------------

    public static void listarOuReproduzirAnuncio(Scanner scan, Plataforma plataforma) {
        ArrayList<Anuncio> anuncios = plataforma.getAnuncios();
        if (anuncios.isEmpty()) {
            System.out.println("Não há anúncios cadastrados.");
            return;
        }

        System.out.println("--- Anúncios cadastrados ---");
        for (int i = 0; i < anuncios.size(); i++) {
            Anuncio anuncio = anuncios.get(i);
            System.out.printf("%d - %s | Anunciante: %s | Duração: %ds | Impressões: %d%n",
                    i + 1, anuncio.getTitulo(), anuncio.getAnunciante(),
                    anuncio.getDuracaoSegundos(), anuncio.getImpressoes());
        }

        int escolha = lerInteiro(scan, "Digite o número do anúncio para reproduzir (0 para voltar): ");
        if (escolha == 0) {
            return;
        }
        if (escolha < 1 || escolha > anuncios.size()) {
            System.out.println("Número de anúncio inválido.");
            return;
        }

        Anuncio anuncio = anuncios.get(escolha - 1);
        anuncio.reproduzir();
        System.out.printf("Valor estimado de veiculação até agora: R$ %.2f%n", anuncio.calcularMensalidade());
    }

    // -------------------- Planos --------------------

    public static void alterarPlanoUsuario(Scanner scan, Plataforma plataforma) {
        Usuario usuario = selecionarUsuario(scan, plataforma, "Nome do usuário: ");
        if (usuario == null) {
            return;
        }

        System.out.println("Escolha o plano:");
        System.out.println("1 - Gratuito");
        System.out.println("2 - Individual");
        System.out.println("3 - Família");
        int opcaoPlano = lerInteiro(scan, "Opção: ");
        Plano novoPlano;

        try {
            switch (opcaoPlano) {
                case 1:
                    novoPlano = new PlanoGratuito();
                    break;
                case 2:
                    double precoIndividual = lerDoublePositivo(scan, "Preço mensal do plano individual (R$): ");
                    novoPlano = new PlanoIndividual(precoIndividual);
                    break;
                case 3:
                    double precoFamilia = lerDoublePositivo(scan, "Preço mensal base do plano família (R$): ");
                    int membros = lerInteiroPositivo(scan, "Quantidade de membros (1 a 6): ");
                    novoPlano = new PlanoFamilia(precoFamilia, membros);
                    break;
                default:
                    System.out.println("Plano inválido.");
                    return;
            }
            usuario.assinar(novoPlano);
            System.out.println("Plano de " + usuario.getNome() + " alterado para " + novoPlano.getNome() + ".");
            System.out.println(novoPlano.resumo());
        } catch (IllegalArgumentException exception) {
            System.out.println("Não foi possível alterar o plano: " + exception.getMessage());
        }
    }

    public static void consultarPlanoUsuario(Scanner scan, Plataforma plataforma) {
        Usuario usuario = selecionarUsuario(scan, plataforma, "Nome do usuário: ");
        if (usuario == null) {
            return;
        }
        System.out.println("--- Plano atual ---");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println(usuario.getPlanoUsuario().resumo());
        System.out.println("Possui anúncios: " + (usuario.getPlanoUsuario().temAnuncios() ? "Sim" : "Não"));
    }

    public static void listarPodcastsPorApresentador(Scanner scan, Plataforma plataforma) {
        String apresentador = lerTexto(scan, "Nome do apresentador: ");
        System.out.println("--- Podcasts de " + apresentador + " ---");
        plataforma.listarEpisodiosDe(apresentador);
    }

    // -------------------- Entrada e auxiliares --------------------

    private static Usuario selecionarUsuario(Scanner scan, Plataforma plataforma, String mensagem) {
        String nome = lerTexto(scan, mensagem);
        return plataforma.buscarUsuario(nome);
    }

    private static String lerTexto(Scanner scan, String mensagem) {
        System.out.print(mensagem);
        return scan.nextLine().trim();
    }

    private static int lerInteiro(Scanner scan, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scan.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException exception) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static int lerInteiroPositivo(Scanner scan, String mensagem) {
        while (true) {
            int valor = lerInteiro(scan, mensagem);
            if (valor > 0) {
                return valor;
            }
            System.out.println("O valor deve ser maior que zero.");
        }
    }

    private static double lerDoublePositivo(Scanner scan, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scan.nextLine().trim().replace(',', '.');
            try {
                double valor = Double.parseDouble(entrada);
                if (Double.isFinite(valor) && valor > 0) {
                    return valor;
                }
                System.out.println("Digite um valor positivo válido.");
            } catch (NumberFormatException exception) {
                System.out.println("Entrada inválida. Exemplo de valor válido: 19,90.");
            }
        }
    }

    private static String formatarDuracao(int totalSegundos) {
        int horas = totalSegundos / 3600;
        int minutos = (totalSegundos % 3600) / 60;
        int segundos = totalSegundos % 60;
        if (horas > 0) {
            return String.format("%02d:%02d:%02d", horas, minutos, segundos);
        }
        return String.format("%02d:%02d", minutos, segundos);
    }
}
