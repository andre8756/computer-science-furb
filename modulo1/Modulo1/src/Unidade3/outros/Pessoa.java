package Unidade3.outros;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private char sexo;

    public Pessoa(String nome, String cpf, int idade, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa() {

    }

    public void andar() {
        System.out.println("Andando..");
    }

    public String toString() {
        return "nome: " + nome + "\ncpf: " + cpf + "\nidade: " + idade + "\nsexo: " + sexo + "cnh: ";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
