import java.util.Scanner;

public class Uni6Exe08 {
    Scanner scan = new Scanner(System.in);
    int tamanho;
    float[] arrayOrigem;
    
    public Uni6Exe08(){
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
                arrayOrigem = new float[tamanho];
                passouTamanho = true;
            }
        }

        ler();
        numerosDiferentes();
    }

    // outro método para printar a quantidade de cada número;
    public void ler() {
        for (int i = 0; i < (tamanho); i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            arrayOrigem[i] = scan.nextFloat();
        }
    }

    public void numerosDiferentes(){
        System.out.println();
        System.out.println("Valor\tFrequência");

        for(int i = 0; i < tamanho; i++){
            boolean repetido = false;
            
            for(int j = 0; j < i; j++){
                if(arrayOrigem[i] == arrayOrigem[j]){
                    repetido = true;
                    break;
                }
            }

            if(!repetido){
                int frequencia = 0;

                for(int j = 0; j < tamanho; j++){
                    if (arrayOrigem[i] == arrayOrigem[j]){
                        frequencia++;
                    }
                }

                System.out.printf("%.2f\t%d\n", arrayOrigem[i], frequencia);
            }
        }
    }

    public static void main(String[] args){
        new Uni6Exe08();
    }
}
