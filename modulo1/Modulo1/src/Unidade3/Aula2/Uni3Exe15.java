package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe15 {

    private int n1;
    private int centenas;
    private int dezenas;
    private int unidades;
    private int resto;

    public Uni3Exe15(int n1) {
        this.n1 = n1;
    }

    public void getLer() {
        centenas = n1 / 100;
        resto = n1 % 100;
        dezenas = resto / 10;
        resto = resto % 10;
        unidades = resto;

        System.out.printf("%d centena(s) %d dezena(s) %d unidade(s)", centenas, dezenas, unidades);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo de até 3 dígitos: ");
        int n1 = scan.nextInt();

        if (n1 > 999 || n1 < 0) {
            System.out.println("Número inválido!");
        } else {
            Uni3Exe15 lerNumero = new Uni3Exe15(n1);
            lerNumero.getLer();
        }

        scan.close();
    }

}
