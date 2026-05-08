package Unidade5.Exercicios;

public class Uni5Exe10 {
    public static void main(String[] args) {
        int termo = 0;

        for (int i = 0; i <= 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                int soma = i + j;
                int total = (int) Math.pow(soma, 2);
                String termo1 = i + "" + j;
                String termo2 = "" + total;

                if (termo1.equals(termo2)) {
                    System.out.println(i + " + " + j + " = " + soma + " --> " + soma + "² = " + termo2);
                    termo++;
                }

                if (termo >= 10) {
                    break;
                }
            }
        }
    }
}
