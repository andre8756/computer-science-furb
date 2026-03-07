
import java.util.Scanner;

public class Uni2Exe18{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        float altura, comprimento, preco;
        float precoUnitario = 12.5f;

        System.out.print("Digite o comprimento da parede em metros: ");
        comprimento = scan.nextFloat();
        System.out.print("Digite a altura da parede em metros: ");
        altura = scan.nextFloat();

        preco = ((comprimento * altura) * 9) * precoUnitario;

        System.out.printf("O valor gasto com a compra de azulejos é um total de R$ %.2f", preco);
        scan.close();
    }
}