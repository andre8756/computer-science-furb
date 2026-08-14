

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Produto produto = new Produto();
        produto.setNome("Bola");
        produto.setPreco(50.00);
        produto.repor(20);

        System.out.println("Nome: "+produto.getNome());
        System.out.println("Valor unitário:: "+produto.getPreco());
        System.out.println("Estoque: "+produto.getEstoque());
        
        produto.vender(2);
        System.out.println("2 produtos vendidos!");

        System.out.println();
        System.out.println("------ Produto atualizado:");
        System.out.println("Nome: "+produto.getNome());
        System.out.println("Valor unitário:: "+produto.getPreco());
        System.out.println("Estoque: "+produto.getEstoque());

    }
}
