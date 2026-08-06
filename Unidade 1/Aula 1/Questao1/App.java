package Questao1;

public class App {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();

        pessoa1.altura = 1.75;
        pessoa1.peso = 78;
        System.out.printf("IMC da pessoa: %.2f",pessoa1.calcularImc());
    }
}
