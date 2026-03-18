package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe11 {

    private float celcios;

    public Uni3Exe11() {
    }

    public Uni3Exe11(float celcios) {
        this.celcios = celcios;
    }

    public float converterF() {
        return (celcios * 9 / 5) + 32;
    }

    public float converterF(float celcios) {
        return (celcios * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite a temperatura em °C: ");
        float celcios = scan.nextFloat();
        Uni3Exe11 temperatura = new Uni3Exe11(celcios);
        System.out.printf("Temperatura em %.2f °F", temperatura.converterF());

        scan.close();
    }

}
