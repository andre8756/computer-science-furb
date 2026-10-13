import java.util.ArrayList;
import Interfaces.Faturavel;
import Interfaces.Reproduzivel;

public class Plataforma {
    private final int MAX = 500;
    private ArrayList<Conteudo> conteudos = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Anuncio> anuncios = new ArrayList<>();

    // ------- Cadastros

    public boolean cadastrarMusica(Musica musica) {

        if (musica == null) {
            throw new IllegalArgumentException(
                    "Erro em cadastrarMusica() da Plataforma! Não foi possível cadastrar a música.");
        }

        if (conteudos.size() >= MAX) {
            return false;
        }

        if (!conteudoNovo(musica)) {
            return false;
        }

        conteudos.add(musica);
        return true;
    }

    public boolean cadastrarPodcast(Podcast podcast) {

        if (podcast == null) {
            throw new IllegalArgumentException(
                    "Erro em cadastrarPodcast() da Plataforma! Não foi possível cadastrar o Podcast.");
        }

        if (conteudos.size() >= MAX) {
            return false;
        }

        if (!conteudoNovo(podcast)) {
            return false;
        }

        conteudos.add(podcast);
        return true;

    }

    public boolean cadastrarUsuario(Usuario usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Erro em cadastrarUsuario() da Plataforma! Não foi possível cadastrar o usuário.");
        }

        if (usuarios.size() >= MAX) {
            return false;
        }

        if (!usuarioNovo(usuario)) {
            return false;
        }

        usuarios.add(usuario);
        return true;
    }

    public boolean cadastrarAnuncio(Anuncio anuncio) {

        if (anuncio == null) {
            throw new IllegalArgumentException(
                    "Erro em cadastrarAnuncio() da Plataforma! Não foi possível cadastrar o anúncio.");
        }

        if (anuncios.size() >= MAX) {
            return false;
        }

        if (!anuncioNovo(anuncio)) {
            return false;
        }

        anuncios.add(anuncio);
        return true;
    }

    // -------- Métodos de busca

    public Conteudo buscarConteudoPorId(int id) {
        for (Conteudo conteudo : conteudos) {
            if (conteudo.getId() == id) {
                return conteudo;
            }
        }

        System.out.println("conteúdo não encontrada!");
        return null;
    }

    public Conteudo buscarConteudo(String titulo) {
        for (Conteudo conteudo : conteudos) {
            if (conteudo.getTitulo().equalsIgnoreCase(titulo)) {
                return conteudo;
            }
        }

        System.out.println("Conteúdo não encontrada!");
        return null;
    }

    public int getTotalConteudos() {
        return conteudos.size();
    }

    public Usuario buscarUsuario(String nome) {

        for (Usuario usuario : usuarios) {

            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }

        System.out.println("Usuário não encontrado!");
        return null;
    }

    public int getTotalUsuarios() {
        return usuarios.size();
    }

    public double calcularReceitaMensal() {
        ArrayList<Faturavel> faturaveis = new ArrayList<>();

        faturaveis.addAll(
                usuarios.stream()
                        .map(Usuario::getPlanoUsuario)
                        .toList());

        faturaveis.addAll(anuncios);

        double total = 0;

        for (Faturavel faturavel : faturaveis) {
            total += faturavel.calcularMensalidade();
        }

        return total;
    }

    public void listarEpisodiosDe(String apresentador) {
        if (apresentador == null || apresentador.isBlank()) {
            throw new IllegalArgumentException("O nome do apresentador deve ser preenchido.");
        }

        boolean encontrou = false;
        for (Conteudo conteudo : conteudos) {
            if (conteudo instanceof Podcast
                    && ((Podcast) conteudo).getApresentador().equalsIgnoreCase(apresentador)) {
                System.out.println(conteudo);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum episódio encontrado para o apresentador " + apresentador + ".");
        }
    }

    public void tocarPlaylist(Usuario ouvinte, Playlist playlist) {
        if (ouvinte == null) {
            throw new IllegalArgumentException("O usuário ouvinte não pode ser nulo.");
        }
        if (playlist == null) {
            throw new IllegalArgumentException("A playlist não pode ser nula.");
        }
        if (playlist.getConteudos().isEmpty()) {
            throw new IllegalArgumentException("A playlist não possui conteúdos para reproduzir.");
        }

        ArrayList<Reproduzivel> reproduziveis = new ArrayList<>();

        boolean inserirAnuncios = ouvinte.getPlanoUsuario().temAnuncios()
                && !anuncios.isEmpty();

        int indiceAnuncio = 0;

        for (int i = 0; i < playlist.getConteudos().size(); i++) {
            Conteudo conteudo = playlist.getConteudos().get(i);
            reproduziveis.add(conteudo);

            if (inserirAnuncios && (i + 1) % 2 == 0) {
                reproduziveis.add(anuncios.get(indiceAnuncio));
                indiceAnuncio = (indiceAnuncio + 1) % anuncios.size();
            }
        }

        for (Reproduzivel reproduzivel : reproduziveis) {
            System.out.println(reproduzivel.getDuracaoFormatada());
            reproduzivel.reproduzir();
        }
    }

    // -------- Métodos de seguir

    public boolean seguir(String nomeSeguidor, String nomeSeguido) {

        Usuario seguidor = buscarUsuario(nomeSeguidor);
        Usuario seguido = buscarUsuario(nomeSeguido);

        if (seguidor == null || seguido == null) {
            return false;
        }

        return seguidor.seguir(seguido);
    }

    public boolean deixarDeSeguir(String nomeSeguidor, String nomeSeguido) {

        Usuario seguidor = buscarUsuario(nomeSeguidor);
        Usuario seguido = buscarUsuario(nomeSeguido);

        if (seguidor == null || seguido == null) {
            return false;
        }

        return seguidor.deixarDeSeguir(seguido);
    }

    // --------------- Métodos Auxiliares:

    private boolean conteudoNovo(Conteudo musica) {
        for (Conteudo outroConteudo : conteudos) {
            if (outroConteudo.getTitulo().equalsIgnoreCase(musica.getTitulo())) {
                return false;
            }
        }

        return true;
    }

    private boolean usuarioNovo(Usuario usuario) {

        for (Usuario outroUsuario : usuarios) {

            if (usuario.getNome().equalsIgnoreCase(outroUsuario.getNome())) {
                System.out.println("Nome de usuário já utilizado");
                return false;
            }

            if (usuario.getEmail().equalsIgnoreCase(outroUsuario.getEmail())) {
                System.out.println("E-mail de usuário já utilizado");
                return false;
            }
        }

        return true;
    }

    private boolean anuncioNovo(Anuncio anuncio) {

        for (Anuncio outroAnuncio : anuncios) {

            if (anuncio.getTitulo().equalsIgnoreCase(outroAnuncio.getTitulo())) {
                System.out.println("Nome de usuário já utilizado");
                return false;
            }
        }

        return true;
    }

    public ArrayList<Conteudo> getMusicas() {
        return conteudos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Conteudo> getConteudos() {
        return conteudos;
    }

    public ArrayList<Anuncio> getAnuncios() {
        return anuncios;
    }

}
