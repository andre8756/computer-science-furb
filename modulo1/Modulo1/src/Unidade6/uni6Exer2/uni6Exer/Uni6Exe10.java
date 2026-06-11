import java.util.Scanner;

public class Uni6Exe10 {
    Scanner scan = new Scanner(System.in);
    int tamanho;
    int [] array;

    public Uni6Exe10(int tamanho){
        this.tamanho = tamanho;
        this.array = new int[tamanho];
        iniciar();
    }

    public void iniciar(){
        int opcao;

        do{
            menu();
            System.out.print("Digite uma opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        }while(opcao != 8);

    }

    public void popular(){
        for(int i = 0; i < tamanho; i++){
            array[i] = 0;
        }
    }

    public void menu(){
        System.out.println("------Menu--------");
        System.out.println("1 - Incluir valor");
        System.out.println("2 - Pesquisar valor");
        System.out.println("3 - Alterar valor");
        System.out.println("4 - Excluir valor");
        System.out.println("5 - Mostrar valores");
        System.out.println("6 - Ordenar valores");
        System.out.println("7 - Inverter valores");
        System.out.println("8 - Sair do sistema");

    }


    public static void main(String[] args){
        new Uni6Exe10(5);
    }
}
