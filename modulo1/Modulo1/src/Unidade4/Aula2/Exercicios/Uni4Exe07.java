package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe07 {
    Scanner scan = new Scanner(System.in);
    private float pesoCarta, pesoExcedido, valorPagar, qntAdicional;

    public Uni4Exe07() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Entre com o peso da carta: ");
        pesoCarta = scan.nextFloat();
        conferirPeso();

        System.out.println("Custo do selo: " + valorPagar);
    }

    public void conferirPeso() {
        if (pesoCarta <= 50) {
            valorPagar = 0.45f;
        } else {
            pesoExcedido = pesoCarta - 50;
            qntAdicional = (pesoExcedido / 20) + 1;
            valorPagar = 0.45f + 0.45f * qntAdicional;
        }
    }

    public static void main(String[] args) {
        new Uni4Exe07();
    }
}
