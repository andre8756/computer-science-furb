package Unidade5.Aula1;

public class ExemploForMatriz {

    public int teste(int i) {
        if (i <= 1) {
            return 1;
        }

        return i * teste(i);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print("|");
                }

                System.out.print("0");
                System.out.print("|");
            }
            System.out.println();
            System.err.println("--------");
        }
    }

}
