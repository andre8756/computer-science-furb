import java.util.Scanner;

public class Uni6Exe06 {
    Scanner scan = new Scanner(System.in);
    int tamanho;
    float[] array;

    public Uni6Exe06(){
        iniciar();
    }

    public void iniciar(){
        float n;
        System.out.print("Digite o tamanho do vetor: ");
        tamanho = scan.nextInt();
        array = new float[tamanho];

        ler();
        System.out.print("Digite o número que deseja ser encontrado: ");
        n = scan.nextFloat();
        findInArray(n);
    }

    public void ler() {
        for (int i = 0; i < (tamanho); i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            array[i] = scan.nextFloat();
        }
    }

    public void findInArray(float a){
        for(int i = 0; i < tamanho; i++){
            if(a == array[i]){
                System.out.println("Verdadeiro");
                break;
            } else if(i == (tamanho-1)){
                System.out.println("Falso");
            }
        }
    }

    public static void main(String[] args) {
        new Uni6Exe06();
    }


}
