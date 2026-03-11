import java.util.Scanner;

public class Uni2Exe13{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double distancia, posicaoY, tempo;

        System.out.println("Dois carros (X e Y) partem em uma mesma direção. O carro X sai com velocidade constante de 60 Km/h e o carro Y sai com velocidade constante de 90 Km/h.");
        System.out.println();
        System.out.print("Digite a distancia do carro Y em relação ao carro X (Km): ");
        distancia = scan.nextInt();

        tempo = (distancia / 30) * 60;

        System.out.printf("Para o carro Y tomar essa distância do outro carro, levaria %.0f minutos",tempo);

        scan.close();
    }
}