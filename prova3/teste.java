package prova3;

public class teste {

    int[] vetor = { 10, 5, 3, 8, 9 };

    public teste() {
        outroTeste(vetor, 5, vetor.length);
        for (int vet : vetor) {
            System.out.println(vet);
        }
    }

    private void outroTeste(int vetor[], int tamaho, int numero) {
        int aux = 0;
        for (int i = 0; i < tamaho; i++) {
            for (int j = 0; j < i; j++) {
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }
            numero++;
        }
        System.out.println(numero);
    }

    public static void main(String[] args) {
        new teste();
    }
}
