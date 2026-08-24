import java.util.Scanner;

public class App {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        boolean hasInt;
        int opcao = 0;

        do{
            System.out.println("=== Sonora ===");
            System.out.println("1 - Cadastrar música manualmente");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Criar playlist e adicionar músicas");
            System.out.println("4 - Buscar música por id");
            System.out.println("5 - Buscar música por título");
            System.out.println("6 - Reproduzir uma música");
            System.out.println("7 - Listar acervo");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print(">> ");
            hasInt = scan.hasNextInt();

            while(!scan.hasNextInt()) { 
                System.out.println("Dígito inválido, tente novamente!");
                scan.nextInt();
            }

            opcao = scan.nextInt();

            switch(opcao){
                case 1: cadastrarMusicaManualmente();
            }

        }while(opcao != 0);

        scan.close();

    }

    public static void cadastrarMusicaManualmente(){
        System.out.println();  //testee reewrwer
    }
}
