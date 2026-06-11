import java.util.Scanner;

public class Uni5Exe20 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        float pesoInicial, pesoFinal;
        int tempo;

        System.out.print("Digite o peso em Kg: ");
        pesoInicial = scan.nextFloat();

        pesoFinal = pesoInicial;

        int contador = 0;
        while (pesoFinal >= 0.5){
            pesoFinal /= 2;
            contador++;
        }

        tempo = contador*50;

        System.out.printf("Massa inicial: %.2f \n", pesoInicial);
        System.out.printf("Massa final: %.2f \n", pesoFinal);
        System.out.printf("Tempo: %d segundos\n", tempo);

        scan.close();
    }
}
