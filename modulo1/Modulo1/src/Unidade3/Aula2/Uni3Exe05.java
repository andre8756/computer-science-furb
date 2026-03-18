package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe05 {

    private float anelId = 4;
    private float anelAlimento = 3.5f * 2;
    private float totalAnel = anelAlimento + anelId;
    private int frangos;

    public Uni3Exe05() {
    }

    public Uni3Exe05(int frangos) {
        this.frangos = frangos;
    }

    public float calcularGasto(int frangos) {
        return frangos * totalAnel;
    }

    public float calcularGasto() {
        return frangos * totalAnel;
    }

    public int getFrangos() {
        return frangos;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o número de frangos: ");
        int galinhas = scan.nextInt();
        Uni3Exe05 granja = new Uni3Exe05(galinhas);

        System.out.printf("O gasto total para marcar %d é R$ %.2f", granja.getFrangos(), granja.calcularGasto());

        scan.close();
    }

}
