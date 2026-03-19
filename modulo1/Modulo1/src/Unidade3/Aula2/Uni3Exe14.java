package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe14 {

    private float distancia;
    private float tempo;

    private float consumo = 12;

    public Uni3Exe14(float distancia, float tempo) {
        this.distancia = distancia;
        this.tempo = tempo;
    }

    public float calcularVelocidade() {
        return distancia / tempo;
    }

    public float calcularGasolina() {
        return distancia / consumo;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Distância (km): ");
        float distancia = scan.nextFloat();
        System.out.print("Tempo (horas): ");
        float horas = scan.nextFloat();

        Uni3Exe14 calcular = new Uni3Exe14(distancia, horas);
        System.out.printf("A velocidade média foi de %.2f km/h e a quantidade de combustível usado foi %.2f litros.",
                calcular.calcularVelocidade(), calcular.calcularGasolina());

        scan.close();
    }

}
