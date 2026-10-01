
import java.util.ArrayList;

public class Usuario {
    private final int id;
    private String nome;
    private String email;
    private static int contadorId = 0;
    private ArrayList<Playlist> playLists = new ArrayList<>();
    private ArrayList<Usuario> seguindo = new ArrayList<>();

    public Usuario(String nome, String email) {
        contadorId++;
        id = contadorId;
        setNome(nome);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {

        if (nome.isBlank() || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário deve estar preenchido!");
        }

        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {

        if (email.isBlank() || email.isEmpty()) {
            throw new IllegalArgumentException("O emiail do usuário deve estar preenchido!");
        }

        int posicaoArroba = email.indexOf('@');

        if (posicaoArroba <= 0 || posicaoArroba >= email.length() - 1) {
            throw new IllegalArgumentException("O email do usuário deve ser válido!");
        }

        this.email = email;

    }

    public boolean adicionarPlaylist(Playlist playlist) {
        if (playlist != null) {
            playLists.add(playlist);
            return true;
        }

        return false;
    }

    public boolean removerPlaylist(Playlist playlist) {
        if (playlist != null) {
            playLists.remove(playlist);
            return true;
        }

        return false;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playLists;
    }

    // Seguindo

    public boolean seguir(Usuario outro) {
        if(outro == null){
            throw new IllegalArgumentException("O usuário a seguir não pode ser nulo!");
        }

        if (outro.getId() == getId()) {
            throw new IllegalArgumentException("Um usuário não pode seguir a sí mesmo!");
        }

        for (Usuario seguindoAgora : seguindo) {
            if (outro.getId() == seguindoAgora.getId()) {
                throw new IllegalArgumentException("O usuário " + getNome() + " já segue " + outro.getNome());
            }
        }

        seguindo.add(outro);
        return true;
    }

    public boolean deixarDeSeguir(Usuario outro) {
        if(outro == null){
            throw new IllegalArgumentException("O usuário a deixar de seguir não pode ser nulo!");
        }

        if (outro.getId() == getId()) {
            throw new IllegalArgumentException("Um usuário não pode deixar de seguir a sí mesmo!");
        }

        for (Usuario seguindoAgora : seguindo) {
            if (outro.getId() == seguindoAgora.getId()) {
                seguindo.remove(outro);
                return true;
            }
        }

        throw new IllegalArgumentException("O usuário " + getNome() + " já segue " + outro.getNome());
    }

    public int getQuantidadeSeguindo(){
        return seguindo.size();
    }

}
