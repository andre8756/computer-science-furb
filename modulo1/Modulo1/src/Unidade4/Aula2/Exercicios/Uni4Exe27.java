import java.util.Scanner;

public class Uni4Exe27{
    Scanner scan = new Scanner(System.in);
    int horaChegada, minutoChegada, horaSaida, minutoSaida, horaPagar, minutoPagar;
    float preco;

    public Uni4Exe27(){
        iniciar();
    }

    public void iniciar(){
        System.out.println("Digite apenas a hora de chegada (hh): ");
        horaChegada = scan.nextInt();
        System.out.println("Digite o minuto de chegada(mm): ");
        minutoChegada = scan.nextInt();

        System.out.println("Digite apenas a hora de saída(hh): ");
        horaSaida = scan.nextInt();
        System.out.println("Digite o minuto de saída(mm): ");
        minutoSaida = scan.nextInt();

        calcularEstacionamento();
    }

    public int calcularEstacionamento(){

        horaPagar = horaSaida - horaChegada;
        minutoPagar = minutoSaida - minutoChegada;

        if (minutoPagar < 0) {
        minutoPagar += 60;
        horaPagar--;
        }
        
        if(horaChegada > horaSaida){
            System.out.println("A hora de chegada não pode ser maior que a hora de saída!");
            return 1;
        } else if(horaChegada > 23 || horaSaida > 23 || minutoChegada > 59 || minutoSaida > 59){
            System.out.println("Hora ou minuto inválidos!!!");
            return 2;
        }

        if (horaPagar == 0 && minutoPagar < 30) {
            horaPagar = 1;
        } else if (minutoPagar >= 30) {
            horaPagar++;
        }

        if(horaPagar < 3){
            preco = horaPagar * 5;
        } else if(horaPagar < 5){
            preco = (horaPagar - 2) * 7.5f + 10;
        } else {
            preco = (horaPagar - 4) * 10 + 25;
        }

        System.out.printf("Preço cobrado: %.2f \n", preco);

        return 0;
    }

    public static void main(String[] args) {
        new Uni4Exe27();
    }
}