
package Questao1;

public class Pessoa {
    double altura;
    double peso;

    public double calcularImc(){
        return peso / (altura * altura);
    }
}
