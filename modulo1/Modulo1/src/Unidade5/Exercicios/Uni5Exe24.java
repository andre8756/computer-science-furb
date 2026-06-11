import java.util.Scanner;

public class Uni5Exe24 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Limite diário em kg: ");
        double limiteKg = scan.nextDouble();

        double limiteGramas = limiteKg * 1000;
        double total = 0;
        char continuar = 's';

        while (continuar == 's') {

            System.out.print("Peso do peixe em gramas: ");
            double peso = scan.nextDouble();

            total = total + peso;
            System.out.println("Peso total: " + total + " gramas");

            if (total > limiteGramas) {
                System.out.println("Limite diário excedido!");
                break;
            }

            System.out.print("Deseja informar o peso de mais um peixe: s/n? ");
            continuar = scan.next().charAt(0);
        }
        scan.close();
    }
}