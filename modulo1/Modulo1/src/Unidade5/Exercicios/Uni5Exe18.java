package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int canal = 1;
        float totalAssistindo = 0;
        int pessoasAssistindo;
        float media;

        int pessoasCanal4 = 0;
        int pessoasCanal5 = 0;
        int pessoasCanal9 = 0;
        int pessoasCanal12 = 0;

        while (canal != 0) {
            System.out.println("Canal: ");
            canal = scan.nextInt();

            if (canal == 0) {
                break;
            } else if (canal != 4 && canal != 5 && canal != 9 && canal != 12) {
                System.out.println("Número inválido! Tente novamente");
                continue;
            }

            System.out.println("Pessoas Assistindo: ");
            pessoasAssistindo = scan.nextInt();

            if (canal == 4) {
                pessoasCanal4 += pessoasAssistindo;
            } else if(canal == 5){
                pessoasCanal5 += pessoasAssistindo;
            } else if(canal == 9){
                pessoasCanal9 += pessoasAssistindo;
            } else{
                pessoasCanal12 += pessoasAssistindo;
            }

            totalAssistindo += pessoasAssistindo;
        }

<<<<<<< HEAD
=======
        System.out.println("Percentual de audiência do canal 4: "+((100*pessoasCanal4) / totalAssistindo)+" %");
        System.out.println("Percentual de audiência do canal 5: "+((100*pessoasCanal5) / totalAssistindo)+" %");
        System.out.println("Percentual de audiência do canal 9: "+((100*pessoasCanal9) / totalAssistindo)+" %");
        System.out.println("Percentual de audiência do canal 12: "+((100*pessoasCanal12) / totalAssistindo)+" %");

>>>>>>> b3d5b1508118ed928a63710a5a0ad0b99b44fb76
    }
}
