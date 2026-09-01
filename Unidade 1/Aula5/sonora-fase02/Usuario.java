public class Usuario {
    private final int id;
    private String nome;
    private String email;
    private static int contadorId = 0;

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

        if(posicaoArroba <= 0 || posicaoArroba >= email.length() - 1){
            throw new IllegalArgumentException("O email do usuário deve ser válido!");
        }

        this.email = email;

    }
}
