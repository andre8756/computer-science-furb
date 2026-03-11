
import java.util.Scanner;


public class Uni2Exe16{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int latas350, garrafa600, garrafa2l;
        float refrigeranteTotal;

        System.out.println("Digite a quantidade de latas de 350ml: ");
        latas350 = scan.nextInt();
        System.out.println("Digite a quantidade de garrafas de 600ml: ");
        garrafa600 = scan.nextInt();
        System.out.println("Digite a quantidade de latas de 2l: ");
        garrafa2l = scan.nextInt();

        refrigeranteTotal = (latas350*0.35f) + (garrafa600*0.6f) + garrafa2l*2;

        System.out.printf("Foi comprado %.2f litros de refrigerante no total!", refrigeranteTotal);

        scan.close();

    }
}