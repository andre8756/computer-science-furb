package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe10 {

    private double cateto1;
    private double cateto2;

    public Uni3Exe10() {
    }

    public Uni3Exe10(double cateto1, double cateto2) {
        this.cateto1 = cateto1;
        this.cateto2 = cateto2;
    }

    public double calcularHipotenusa() {
        return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
    }

    public double calcularHipotenusa(double cateto1, double cateto2) {
        return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Cateto oposto: ");
        double cateto1 = scan.nextDouble();
        System.out.print("Cateto adjacente: ");
        double cateto2 = scan.nextDouble();

        Uni3Exe10 calcular = new Uni3Exe10(cateto1, cateto2);
        System.out.printf("A hipotenusa é: %.2f", calcular.calcularHipotenusa());

        scan.close();
    }

}
