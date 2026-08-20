public class Usuario {
    private int id;
    private String nome;
    private String email;
    private static int contadorId = 0;

    public Usuario(String nome, String email){
        contadorId++;
        
    }
}
