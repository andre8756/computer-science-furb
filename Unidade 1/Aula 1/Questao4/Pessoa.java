
package Questao4;

public class Pessoa {
    double altura;
    double peso;
    String nome;

    public double calcularImc(){
        return peso / (altura * altura);
    }
}
