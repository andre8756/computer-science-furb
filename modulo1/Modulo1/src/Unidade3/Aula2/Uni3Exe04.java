package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe04 {
    private int n1;
    private int n2;
    private int n3;

    public Uni3Exe04(int n1, int n2, int n3) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public float mediaPonderada() {
        return n1 * 0.5f + n2 * 0.3f + n3 * 0.2f;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        int n1 = scan.nextInt();
        System.out.print("Digite a segunda nota: ");
        int n2 = scan.nextInt();
        System.out.print("Digite a terceira nota: ");
        int n3 = scan.nextInt();

        Uni3Exe04 notas = new Uni3Exe04(n1, n2, n3);

        System.out.printf("A media poderada é: %.2f", notas.mediaPonderada());

        scan.close();
    }
}
