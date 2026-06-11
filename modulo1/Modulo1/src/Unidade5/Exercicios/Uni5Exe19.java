
import java.util.Scanner;

public class Uni5Exe19{

    public Uni5Exe19(){
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float valor = 1;
        float valorTotal = 0;
        
        while(valor != 0){
            System.out.println("Valor da compra: ");
            valor = scan.nextFloat();

            if(valor <= 0){
                break;
            } else if(valor <= 500){
                valor -= valor * 0.15f;
            } else{
                valor -= valor * 0.2f;
            }

            valorTotal += valor;

            System.out.printf("Valor a pagar: %.2f \n", valor);
        }

        System.out.printf("O valor total recebido foi de R$ %.2f \n", valorTotal);
    }

}