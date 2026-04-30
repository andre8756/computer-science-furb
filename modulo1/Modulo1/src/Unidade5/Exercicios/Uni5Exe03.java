package Unidade5.Exercicios;

public class Uni5Exe03 {
    public static void main(String[] args) {
        double n1 = 1;
        for (int i = 2; i <= 101; i++) {
            n1 = n1 + 1.0 / i;
        }

        System.out.println(n1);
    }
}
