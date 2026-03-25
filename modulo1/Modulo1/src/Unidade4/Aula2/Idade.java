package Unidade4.Aula2;

import java.util.Scanner;

public class Idade {

    private int idade;

    public Idade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = scan.nextInt();

        if (idade >= 80) {
            System.out.println("Idosoo!!!");
        } else if (idade >= 60) {
            System.out.println("Terceira idade");
        } else if (idade >= 18) {
            System.out.println("Você já é adulto!!");
        } else if (idade >= 6) {
            System.out.println("Você é criança!!");
        } else {
            System.out.println("Você é neném!!");
        }

        scan.close();
    }
}
