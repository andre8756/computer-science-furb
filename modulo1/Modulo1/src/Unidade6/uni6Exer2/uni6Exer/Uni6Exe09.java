import java.util.Scanner;

public class Uni6Exe09 {
    Scanner scan = new Scanner(System.in);
    int tamanho;
    float[][] array;
    String[] perguntas = {"Sexo (1=M/2=F): ", "Nota (0/10): ", "Idade: "};
    float media;

    public Uni6Exe09(int tamanho){
        this.tamanho = tamanho;
        this.array = new float[tamanho][perguntas.length];
        iniciar();
    }

    public void iniciar(){
        ler();
        notaMedia();
        System.out.println();
        notaMediaHomens();
        System.out.println();
        notaMulherJovem();
        System.out.println();
        Nota50Mulheres();
    }

    public void ler() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println();
            System.out.println("Pessoa "+(i+1)+": ");
            for(int j = 0; j < perguntas.length; j++){
                System.out.print("   "+perguntas[j]);
                array[i][j] = scan.nextFloat();
            }
        }
    }

    public void notaMedia(){
        float soma = 0;

        for (int i = 0; i < tamanho; i++) {
            soma += array[i][1];
        }

        media = soma/tamanho;
        System.out.printf("Média: %.2f", media);
    }

    public void notaMediaHomens(){
        float soma = 0;
        float media;
        int qntHomens = 0;

        for (int i = 0; i < tamanho; i++) {
            if(array[i][0] == 2){
                soma += array[i][1];
                qntHomens++;
            }
        }

        if(qntHomens > 0){
            media = soma / qntHomens;
            System.out.printf("Média homens: %.2f", media);
        } else {
            System.out.println("Não há homens na pesquisa.");
        }
    }

    public void notaMulherJovem(){
        float menor = Integer.MAX_VALUE;
        float nota = 0;

        for (int i = 0; i < tamanho; i++) {
            if(array[i][0] == 1 && array[i][2] < menor){
                menor = (int) array[i][2];
                nota = array[i][1];
            }
        }

        System.out.printf("Nota mulher mais jovem: %.2f", nota);
    }

    public void Nota50Mulheres(){
        int qnt = 0;

        for (int i = 0; i < tamanho; i++) {
            if(array[i][0] == 1 && array[i][2] > 50 && array[i][1] > media){
                qnt++;
            }
        }

        System.out.printf("Mulheres com mais de 50 anos deram nota superior a média recebida pelo cinema: %d", qnt);
    }

    public static void main(String[] args){
        new Uni6Exe09(30);
    }
}
