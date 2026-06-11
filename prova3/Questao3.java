package prova3;

import java.util.Scanner;

public class Questao3 {
    Scanner scan = new Scanner(System.in);
    int pesoMax;
    int espacoMax;
    int[] pesos;
    String[] mochila;

    String tempString;
    int tempInt;

    public Questao3(int espacoMax, int pesoMax) {
        this.espacoMax = espacoMax;
        this.pesoMax = pesoMax;
        this.pesos = new int[espacoMax];
        this.mochila = new String[espacoMax];

        popular();
        int opcao;

        try {
            do {
                menu();

                System.out.print("Ecolha uma opção: ");
                opcao = scan.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do objeto: ");
                        tempString = scan.next();
                        System.out.print("Digite o peso do objeto: ");
                        tempInt = scan.nextInt();
                        inserir(tempString, tempInt);
                        System.out.println();
                        break;

                    case 2:
                        imprimirMochihla();
                        System.out.println();
                        break;

                    case 3:
                        System.out.println();
                        System.out.println("Item mais pesado: " + valorItemMaisPesado());
                        System.out.println();
                        break;

                    case 4:
                        ordenarMochila();
                        System.out.println();
                        break;

                    case 5:
                        System.out.print("Digite o nome do objeto que você deseja excluir: ");
                        tempString = scan.next();
                        excluirItemMochila(tempString);
                        System.out.println();
                        break;

                    case 6:
                        break;

                    default:
                        System.out.println("Opção inválida!!! Tente novamente....");
                        System.out.println();
                        break;
                }
            } while (opcao != 6);
        } catch (Exception exception) {
            System.out.println("Opss... Parece que você fez algo que não devia!!");
            System.out.println(".... Programa finalizado");
        }

    }

    // Inicializacao
    // -----------------------------------------------------------------

    public void popular() {
        for (int i = 0; i < espacoMax; i++) {
            pesos[i] = 0;
        }
    }

    public void menu() {
        System.out.println("-----------Menu-----------");
        System.out.println("1 - Inserir");
        System.out.println("2 - Imprimir Mochila");
        System.out.println("3 - Item mais pesado");
        System.out.println("4 - Ordenar mochila");
        System.out.println("5 - Excluir item da mochila");
        System.out.println("6 - Sair do sistema");
        System.out.println();
    }

    // Métodos Principais
    // -----------------------------------------------------------------

    // Insere um item na mochila
    public boolean inserir(String objetoNovo, int peso) {
        // Verifica se excedeu o peso ou o tamanho da mochila
        if ((calcularPeso() + peso) > pesoMax || !espaçoDisponivel()) {
            printarDadosMaximos();
            return false;
        }

        // Insere o objeto no lugar vazio
        for (int i = 0; i < espacoMax; i++) {
            if (mochila[i] == null || mochila[i] == "") {
                mochila[i] = objetoNovo;
                pesos[i] = peso;
                break;
            }
        }

        return true;
    }

    public void imprimirMochihla() {
        System.out.println();
        System.out.print("Mochila atual:");
        for (int i = (espacoMax - 1); i >= 0; i--) {
            System.out.printf(" [%s] ", mochila[i]);
        }
        System.out.printf("\nPesos: ");
        for (int i = (espacoMax - 1); i >= 0; i--) {
            System.out.printf(" [%d] ", pesos[i]);
        }
        System.out.println();
    }

    public int valorItemMaisPesado() {
        int maior = Integer.MIN_VALUE;
        for (int peso : pesos) {
            if (peso > maior) {
                maior = peso;
            }
        }

        return maior;
    }

    public void ordenarMochila() {
        boolean troca = true;
        int pesoTemp;
        String mochilaTemp;

        while (troca) {
            troca = false;
            for (int i = (espacoMax - 1); i < 0; i++) {
                if (pesos[i] > pesos[i + 1]) {
                    troca = true;
                    pesoTemp = pesos[i];
                    pesos[i] = pesos[i + 1];
                    pesos[i + 1] = pesoTemp;

                    mochilaTemp = mochila[i];
                    mochila[i] = mochila[i + 1];
                    mochila[i + 1] = mochilaTemp;
                }
            }
        }
    }

    public boolean excluirItemMochila(String objeto) {
        System.out.println();

        for (int i = 0; i < espacoMax; i++) {
            if (objeto.equals(mochila[i])) {
                mochila[i] = null;
                pesos[i] = 0;
                System.out.println("Item excluído com sucesso!");

                return true;
            }
        }

        System.out.println("Item não encontrado!");
        return false;
    }

    // Métodos Secundários
    // -----------------------------------------------------------------

    // Valida através de um forEach se tem algum espaço desocupado na mochila
    public boolean espaçoDisponivel() {
        for (String objeto : mochila) {
            if (objeto == null || objeto == "") {
                return true;
            }
        }

        return false;
    }

    // Printa os dados máximos e atuais da mochila
    public void printarDadosMaximos() {
        System.out.println();
        System.out.println("Tamanho da mochila: " + espacoMax);
        System.out.printf("Capacidade Máxima da mochila (kg): %d \n", pesoMax);

        System.out.println();

        System.out.print("Mochila atual:");
        for (String objeto : mochila) {
            System.out.printf(" [%s] ", objeto);
        }
        System.out.printf("\nPesos: ");
        for (int peso : pesos) {
            System.out.printf(" [%d] ", peso);
        }
    }

    // Calcula o peso atual da mochila
    public float calcularPeso() {
        float peso = 0;
        for (int i = 0; i < espacoMax; i++) {
            peso += pesos[i];
        }

        return peso;
    }

    // Main
    // -----------------------------------------------------------------

    public static void main(String[] args) {
        new Questao3(5, 15);
    }

}
