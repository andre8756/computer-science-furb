

public class Pessoa {
    private String nome;
    private double peso;
    private double altura;

    public double calcularImc(){
        return peso / (altura * altura);
    }

    public void exibirPessoa(){
        System.out.printf("Nome: %s\n", nome );
        System.out.printf("Peso: %.2f\n", peso);
        System.out.printf("Altura: %.2f\n", altura );
        System.out.printf("IMC: %.2f\n", calcularImc());
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPeso(){
        return peso;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public double getAltura(){
        return altura;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

}
