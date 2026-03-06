import java.util.Scanner;

public class Uni2Exe15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int notas100, notas50, notas20, notas10, notas5, notas2, notas1;
        int moeda05, moeda025, moeda010, moeda005, moeda001;
        float valor;

        System.out.print("Digite o valor desejado para troco: ");
        valor = scan.nextFloat();

        notas100 = 0;
        notas50 = 0;
        notas20 = 0;
        notas10 = 0;
        notas5 = 0;
        notas2 = 0;
        notas1 = 0;

        

        notas100 = (int)(valor / 100);
        valor = valor - (notas100*100);
        notas50 = (int)(valor / 50);
        valor = valor - (notas50*50);
        notas20 = (int)(valor/20);
        valor = valor - (notas20*20);
        notas10 = (int)(valor/10);
        valor = valor - (notas10*10);
        notas5 = (int)(valor / 5);
        valor = valor - (notas5*5);
        notas2 = (int)(valor / 2);
        valor = valor - (notas2*2);
        notas1 = (int)(valor / 1);
        valor = valor - (notas1*1);

        valor = valor*100;

        System.out.println("------Cedulas de troco: ");
        System.out.printf("Notas de R$100,00 - %d%n", notas100);
        System.out.printf("Notas de R$50,00 - %d%n", notas50);
        System.out.printf("Notas de R$20,00 - %d%n", notas20);
        System.out.printf("Notas de R$10,00 - %d%n", notas10);
        System.out.printf("Notas de R$5,00 - %d%n", notas5);
        System.out.printf("Notas de R$02,00 - %d%n", notas2);
        
        System.out.println("-----Moedas:");
        System.out.println(valor);

        

        scan.close();
    }
}
