package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe07 {

    private float lata = 0.35f;
    private float garrafa600 = 0.6f;
    private float garrafa2L = 2;

    private int latasCompradas;
    private int garrafas600Compradas;
    private int garrafas2LCompradas;

    public Uni3Exe07() {
    }

    public Uni3Exe07(int latasCompradas, int garrafas600Compradas, int garrafas2LCompradas) {
        this.latasCompradas = latasCompradas;
        this.garrafas600Compradas = garrafas600Compradas;
        this.garrafas2LCompradas = garrafas2LCompradas;
    }

    public float calcularLitros() {
        return (latasCompradas * lata) +
                (garrafas600Compradas * garrafa600) +
                (garrafas2LCompradas * garrafa2L);
    }

    public float calcularLitros(int latasCompradas, int garrafas2LCompradas, int garrafas600Compradas) {
        return (latasCompradas * lata) +
                (garrafas600Compradas * garrafa600) +
                (garrafas2LCompradas * garrafa2L);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o número de latas compradas: ");
        int latas = scan.nextInt();
        System.out.print("Digite o número de garrafas de 600ml compradas: ");
        int garrafas600 = scan.nextInt();
        System.out.print("Digite o número de garrafas de 2 litros compradas: ");
        int garrafas2L = scan.nextInt();

        Uni3Exe07 fabrica = new Uni3Exe07(latas, garrafas600, garrafas2L);

        System.out.printf("O cliente comprou um total de %.2f litros", fabrica.calcularLitros());
    }

}
