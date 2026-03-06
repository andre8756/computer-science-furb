import java.util.Scanner;

public class Uni2Exe15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int centavos;
        int notas100, notas50, notas20, notas10, notas5, notas2, notas1;
        int moeda05, moeda025, moeda010, moeda005, moeda001;
        double valor;

        System.out.print("Digite o valor desejado para troco: ");
        valor = scan.nextDouble();
        
        centavos = (int) Math.round(valor * 100);

        // Contagem das notas
        notas100 = centavos / 10000;
        centavos %= 10000;
        notas50 = centavos / 5000;
        centavos %= 5000;
        notas20 = centavos/2000;
        centavos %= 2000;
        notas10 = centavos/10000;
        centavos %= 1000;
        notas5 = centavos / 500;
        centavos %= 500;
        notas2 = centavos / 200;
        centavos %= 200;
        notas1 = centavos / 100;
        centavos %= 100;

        // Contagem das moedas
        moeda05 = centavos/50;
        centavos %= 50;
        moeda025 = centavos/25;
        centavos %= 25;
        moeda010 = centavos / 10;
        centavos %= 10;
        moeda005 = centavos / 5;
        centavos %= 5;
        moeda001 = centavos;

        // printando notas
        System.out.println("------Cedulas de troco: ");
        System.out.printf("Notas de R$100,00 - %d%n", notas100);
        System.out.printf("Notas de R$50,00 - %d%n", notas50);
        System.out.printf("Notas de R$20,00 - %d%n", notas20);
        System.out.printf("Notas de R$10,00 - %d%n", notas10);
        System.out.printf("Notas de R$5,00 - %d%n", notas5);
        System.out.printf("Notas de R$02,00 - %d%n", notas2);
        System.out.println("");
        
        // printando moedas
        System.out.println("-----Moedas:");
        System.out.printf("Moedas de R$01,00 - %d%n", notas1);
        System.out.printf("Moedas de R$00,50 - %d%n", moeda05);
        System.out.printf("Moedas de R$00,25 - %d%n", moeda025);
        System.out.printf("Moedas de R$00,10 - %d%n", moeda010);
        System.out.printf("Moedas de R$00,05 - %d%n", moeda005);
        System.out.printf("Moedas de R$00,01 - %d%n", moeda001);

        

        scan.close();
    }
}
