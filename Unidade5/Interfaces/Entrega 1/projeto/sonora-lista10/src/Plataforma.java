
import java.util.ArrayList;

public class Plataforma {
    private final int MAX = 500;
    private ArrayList<Conteudo> conteudos = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

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

    public double calcularReceitaMensal(){
        double soma = 0;

        for(Usuario usuario: usuarios){
            soma += usuario.getPlanoUsuario().calcularMensalidade();
        }
        
        return soma;
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

    public ArrayList<Conteudo> getMusicas() {
        return conteudos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

}
