package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe09 {

    private double raio;
    private double altura;

    public Uni3Exe09() {
    }

    public Uni3Exe09(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    public double calculcarVolume() {
        return Math.PI * Math.pow(raio, 2) * altura;
    }

    public double calculcarVolume(double raio, double altura) {
        return Math.PI * Math.pow(raio, 2) * altura;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Raio: ");
        double raio = scan.nextDouble();
        System.out.print("Altura: ");
        double altura = scan.nextDouble();

        Uni3Exe09 calcular = new Uni3Exe09(raio, altura);
        System.out.printf("O volume da lata de óleo é: %.2f", calcular.calculcarVolume());
        scan.close();
    }

}
