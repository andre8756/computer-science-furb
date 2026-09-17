package src;

import java.util.ArrayList;

public class Plataforma {
    private final int MAX = 500;
    private ArrayList<Musica> musicas = new ArrayList<>();
    private Usuario usuarios[] = new Usuario[MAX];

    // ------- Cadastros

    public boolean cadastrarMusica(Musica musica) {

        if (musica == null) {
            throw new IllegalArgumentException(
                    "Erro em cadastrarMusica() da Plataforma! Não foi possível cadastrar a música.");
        }

        if (musicas.size() >= MAX) {
            return false;
        }

        if (!musicaNova(musica)) {
            return false;
        }

        musicas.add(musica);
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Erro em cadastrarUsuario() da Plataforma! Não foi possível cadastrar o usuaŕio.");
        }

        if (!usuarioNovo(usuario)) {
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

        if (playlist == null) {
            throw new IllegalArgumentException(
                    "Erro em cadastrarPlaylist() da Plataforma! Playlist inválida.");
        }

        if (!playlistNova(playlist)) {
            return false;
        }

        Usuario usuario = playlist.getDono();

        return usuario.adicionarPlaylist(playlist);
    }

    // -------- Métodos de busca

    public Musica buscarMusicaPorId(int id) {
        for (Musica musica : musicas) {
            if (musica.getId() == id) {
                return musica;
            }
        }

        System.out.println("Música não encontrada!");
        return null;
    }

    public Musica buscarMusica(String titulo) {
        for (Musica musica : musicas) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }

        System.out.println("Música não encontrada!");
        return null;
    }

    public int getTotalMusicas() {
        return musicas.size();
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

    // --------------- Métodos Auxiliares:

    private boolean musicaNova(Musica musica) {
        for (Musica outraMusica : musicas) {
            if (outraMusica.getTitulo().equalsIgnoreCase(musica.getTitulo())) {
                return false;
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
        for (Playlist outraPlaylist : playlist.getDono().getPlaylists()) {
            if (outraPlaylist.getNome().equalsIgnoreCase(playlist.getNome())) {
                System.out.println("Já existe uma playlist com este nome!!");
                return false;
            }
        }

        return true;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

}
