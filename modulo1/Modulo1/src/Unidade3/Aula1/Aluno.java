package Unidade3.Aula1;

public class Aluno {
    private int numeroMatricula;
    private String nome;
    private char sexo;

    // funcao sincrona
    public int informarNumerDeMatricula() {
        return this.numeroMatricula;
    }

    // funcao assincrona
    public void estudar() {
        System.out.println("Estudando");
    }
}
