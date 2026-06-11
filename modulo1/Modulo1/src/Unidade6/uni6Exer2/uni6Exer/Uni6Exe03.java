import java.util.Scanner;

public class Uni6Exe03 {
    Scanner scan = new Scanner(System.in);
    int tamanho;
    float[] array;

    public Uni6Exe03(int tamanho){
        this.tamanho = tamanho;
        array = new float[tamanho];
    }

    public void ler() {
        for (int i = 0; i < (tamanho); i++) {
            System.out.print("Numero: ");
            array[i] = scan.nextFloat();
        }
    }

    public void calcula(){
        for(int i = 0; i < tamanho; i++){
            if(i % 2 == 0){
                array[i] *= 1.02f;
            } else{
                array[i] *= 1.05f;
            }
        }
    }

    public void escrever(){
        for (int i = 0; i < (tamanho); i++) {
            System.out.printf("Final: %.2f \n", array[i]);
        }
    }

    public static void main(String[] args) {
        Uni6Exe03 exe03 = new Uni6Exe03(4);
        exe03.ler();
        exe03.calcula();
        exe03.escrever();
    }

}
