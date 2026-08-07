
package Questao4;

public class Pessoa {
    double altura;
    double peso;
    String nome;

    public double calcularImc(){
        return peso / (altura * altura);
    }

    public void exibirPessoa(){
        System.out.printf("Nome: %s\n", nome );
            System.out.printf("Peso: %.2f\n", peso);
            System.out.printf("Altura: %.2f\n", altura );
            System.out.printf("IMC: %.2f\n", calcularImc());
    }
}
