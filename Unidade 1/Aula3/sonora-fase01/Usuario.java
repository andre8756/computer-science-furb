public class Usuario {
    private final int id;
    private String nome;
    private String email;
    private static int contadorId = 0;

    public Usuario(String nome, String email){
        contadorId++;
        id = contadorId;
        this.nome = nome;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    private void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
