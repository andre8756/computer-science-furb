package prova;

import java.util.Scanner;

public class Questao2 {

    public static void main() {
        Scanner scan = new Scanner(System.in);

        Integer[] mochila = new Integer[10];
        // mochila[0] = 10;
        // mochila[1] = 20;
        // mochila[2] = 10;
        // em kg
        int pesoMaximo = 10;
        String iniciar;
        char opcao = 'g';
        String opcao2;
        int valor;
        do {
            iniciar = scan.next();

        } while (!iniciar.equals("INICIAR"));

        do {
            System.out.println();
            System.out.println("a - Adicionar peso na mochila");
            System.out.println("b - Remover peso da mochila");
            System.out.println("c - Listar pesos da mochila");
            System.out.println("d - Ordenar mochila em ordem decrescente");
            System.out.println("e - Verificar se um peso existe na mochila");
            System.out.println("f - Sair");
            System.out.println();
            System.out.print("Digite uma opção válida: ");
            opcao2 = scan.next();
            opcao = opcao2.charAt(0);

            switch (opcao) {
                case 'a':
                    System.out.println("Digite um valor:");
                    valor = scan.nextInt();

                    mochila = addPesoMochila(mochila, valor);
                    break;

                case 'b':
                    break;

                case 'c':
                    System.out.println(getPesoMochila(mochila));
                    break;

                case 'd':
                    break;

                case 'e':
                    System.out.println("Digite um valor:");
                    valor = scan.nextInt();

                    if (isInMochila(mochila, valor)) {
                        System.out.println("A mochila possui este valor!!");
                    } else {
                        System.out.println("A mochila não possui este valor!!");
                    }
                    break;

                case 'f':
                    System.out.println("Saindo!!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 'f');

        System.out.println("Saiu");

        scan.close();

    }

    public static float getPesoMochila(Integer[] mochila) {
        int i = 0;
        float pesoMochila = 0;

        do {

            if (mochila[i] != null) {
                pesoMochila = mochila[i] + pesoMochila;
            }
            i++;
        } while (mochila[i] != null);

        return pesoMochila;
    }

    public static Integer[] addPesoMochila(Integer[] mochila, int valor) {
        int i = 0;
        int add = 0;

        do {
            if (mochila[i] == null) {
                if ((getPesoMochila(mochila) + valor) >= 10) {
                    System.out.println("Peso Excedido!!!");
                } else {
                    mochila[i] = valor;
                }
                add = 1;
            } else {
                System.out.println("Limite de espaço excedido!!!");
            }
            i++;
        } while (add != 1);

        return mochila;
    }

    public static Integer findInMochila(Integer[] mochila, int valor) {
        int i = 0;
        Integer id = null;

        do {
            if (isInMochila(mochila, valor)) {
                if (mochila[i] == valor) {
                    id = i;
                }
            }
            i++;
        } while (mochila[i] != null);

        return id;
    }

    public static boolean isInMochila(Integer[] mochila, int valor) {
        int i = 0;
        boolean possuiValor = false;

        do {

            if (mochila[i] == valor) {
                possuiValor = true;
            }
            i++;
        } while (mochila[i] != null);

        return possuiValor;
    }

    public static Integer[] removerPesoMochila(Integer[] mochila, int valor) {
        Integer id = findInMochila(mochila, valor);
        Integer[] newMochila = new Integer[10];

        if (id != null && mochila[id] == valor) {
            mochila[id] = null;
        } else {
            System.out.println("Item não encontrado ao excluir!");
        }

        return mochila;
    }

}
