package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe01 {

    private int comprimento;
    private int largura;

    public Uni3Exe01(int comprimento, int largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public int calcularArea() {
        return comprimento * largura;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o comprimento: ");
        int comprimento = scan.nextInt();
        System.out.print("Digite a altura: ");
        int altura = scan.nextInt();

        Uni3Exe01 uni3Exe01 = new Uni3Exe01(comprimento, altura);

        System.out.println(uni3Exe01.calcularArea());

        scan.close();
    }
}
