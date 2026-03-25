package Unidade4.Aula2;

import java.util.Scanner;

public class Calculadora {

    Scanner scan = new Scanner(System.in);
    float n1, n2, resultado;
    char operador;

    public Calculadora() {
        obterValores();
        executarOperacao();
        exibirResultado();
    }

    private void exibirResultado() {
        System.out.printf("O resultado é %.2f", resultado);
    }

    private void executarOperacao() {
        if (operador == 43) {
            resultado = somar(n1, n2);
        } else if (operador == 45) {
            resultado = subtrair(n1, n2);
        } else if (operador == 42) {
            resultado = multiplicar(n1, n2);
        } else if (operador == 47) {
            resultado = dividir(n1, n2);
        } else if (operador == '^') {
            resultado = exponenciar(n1, n2);
        } else if (operador == 45) {
            resultado = restoDivisao(n1, n2);
        } else {
            System.out.printf("Operação inválida!! \n");
        }
    }

    private void obterValores() {
        System.out.print("Digite o primeiro valor: ");
        n1 = scan.nextInt();
        System.out.print("Digite o segundo valor: ");
        n2 = scan.nextInt();
        System.out.println("Digite a opecação: \n" +
                "   + para somar\n" +
                "   - para subtrair\n" +
                "   * para multiplicar\n" +
                "   / para dividir\n" +
                "   ^ para exponenciação\n" +
                "   % para resto da divisão\n");
        operador = scan.next().charAt(0);
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
    }

    public float somar(float n1, float n2) {
        return n1 + n2;
    }

    public float subtrair(float n1, float n2) {
        return n1 - n2;
    }

    public float multiplicar(float n1, float n2) {
        return n1 * n2;
    }

    public float dividir(float n1, float n2) {
        if (n2 > 0) {
            return n1 / n2;
        } else {
            System.out.println("O segundo valor precisa ser maior que zero para dividir!");
            return 0;
        }
    }

    public float exponenciar(float n1, float n2) {
        return (float) Math.pow(n1, n2);
    }

    public float restoDivisao(float n1, float n2) {
        return n1 % n2;
    }

}
