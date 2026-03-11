package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numero;
        float horas, valor, recebeHora;

        System.out.print("Digite o seu número de usuário: ");
        numero = scan.nextInt();

        System.out.print("Digite o total de horas trabalhadas: ");
        horas = scan.nextFloat();

        System.out.print("Digite o valor que você recebe por horas: ");
        valor = scan.nextFloat();
        recebeHora = horas * valor;

        System.out.printf("O funcionário %d deve receber %.2f", numero, recebeHora);

        scan.close();
    }
}
