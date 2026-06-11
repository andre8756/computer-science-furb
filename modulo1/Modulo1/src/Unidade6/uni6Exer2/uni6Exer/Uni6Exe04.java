import java.util.Scanner;

public class Uni6Exe04 {
    Scanner scan = new Scanner(System.in);
    int tamanho;
    int[] array1;
    int[] array2;
    int[] somas;
    
    public Uni6Exe04(int tamanho){
        this.tamanho = tamanho;
        array1 = new int[tamanho];
        array2 = new int[tamanho];
        somas = new int[tamanho];
    }

    public void ler(){
        System.out.println("Vetor 1:");
        for(int i = 0; i < tamanho; i++){
            System.out.print("    Número "+(i+1)+": ");
            array1[i] = scan.nextInt();
        }

        System.out.println("Vetor 2:");
        for(int i = 0; i < tamanho; i++){
            System.out.print("    Número "+(i+1)+": ");
            array2[i] = scan.nextInt();
        }
    }

    public void calcula(){
        for(int i = 0; i < tamanho; i++){
            somas[i] = array1[i] + array2[i];
        }
    }

    public void escrever(){
        System.out.println();
        System.out.println("Vetor 1:");
        for(int i = 0; i < tamanho; i++){
            System.out.println("    Número "+(i+1)+": "+array1[i]);
        }

        System.out.println();
        System.out.println("Vetor 2:");
        for(int i = 0; i < tamanho; i++){
            System.out.println("    Número "+(i+1)+": "+array2[i]);
        }

        System.out.println();
        System.out.println("Vetor 3:");
        for(int i = 0; i < tamanho; i++){
            System.out.println("    Número "+(i+1)+": "+somas[i]);
        }
    }

    public static void main(String[] args) {
        Uni6Exe04 exe04 = new Uni6Exe04(10);
        exe04.ler();
        exe04.calcula();
        exe04.escrever();
    }
}
