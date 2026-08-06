
package Questao3;

public class Pessoa {
    double altura;
    double peso;

    public double calcularImc(){
        return peso / (altura * altura);
    }
}
