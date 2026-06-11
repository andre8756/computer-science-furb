import java.util.Scanner;

public class Uni6Exe07 {
    Scanner scan = new Scanner(System.in);
    int tamanho;
    int[] array;

    public Uni6Exe07(){
        iniciar();
    }

    public void iniciar(){
        boolean passouTamanho = false;
        while(!passouTamanho){
            System.out.print("Digite o tamanho do vetor: ");
            tamanho = scan.nextInt();

            if(tamanho > 20){
                System.out.println("Digite um número menor que 20!");
            } else{
                array = new int[tamanho];
                passouTamanho = true;
            }
        }

        ler();
        ordenar();
        escrever();
    }

    public void ler() {
        int n;
        boolean igual;

        int i = 0;
        while(i < tamanho) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            n = scan.nextInt();
            igual = false;

            for(int j= 0; j < i; j++){
                if(n == array[j]){
                    igual = true;
                    break;
                }
            }

            if(!igual){
                array[i] = n;
                i++;
            } else{
                System.out.println("Número já existe, digite outro!");
                continue;
            }
        }   

        System.out.print("Vetor origem: ");
        for(int j = 0; j < tamanho; j++){
            System.out.print("["+array[j]+"] ");
        }
    }

    public void ordenar(){
        boolean troca = true;
        while(troca){
            troca = false;
            for(int i = 0; i < (tamanho - 1); i++){
                if(array[i] > array[i+1]){
                    troca = true;
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }

    public void escrever(){
        System.out.println();
        System.out.print("Vetor ordenado: ");
        for(int i = 0; i < tamanho; i++){
            System.out.print("["+array[i]+"] ");
        }
    }

    public static void main(String[] args) {
        new Uni6Exe07();
    }

}
