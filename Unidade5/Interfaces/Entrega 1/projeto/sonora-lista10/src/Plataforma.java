
import java.util.ArrayList;

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
        double soma = 0;

        for (Usuario usuario : usuarios) {
            soma += usuario.getPlanoUsuario().calcularMensalidade();
        }

        return soma;
    }

    public void listarEpisodiosDe(String apresentador) {
        for (Conteudo conteudo : conteudos) {
            if (conteudo instanceof Podcast && ((Podcast) conteudo).getApresentador().equalsIgnoreCase(apresentador)) {
                System.out.println(conteudo);
            }
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

}
