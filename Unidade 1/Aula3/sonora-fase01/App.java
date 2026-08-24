import java.util.Scanner;

public class App {
    public static void main(String args[]){
        Plataforma plataforma = new Plataforma();

        //  ----- Apenas testando
        
        Musica musica1 = new Musica("titulo1", "artista1", 65);
        Musica musica2 = new Musica("titulo2", "artista2", 70);
        Musica musica3 = new Musica("titulo3", "artista3", 75);

        plataforma.cadastrarMusica(musica1);
        plataforma.cadastrarMusica(musica2);
        plataforma.cadastrarMusica(musica3);

        //  ----- Tela inicial

        Scanner scan = new Scanner(System.in);
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

            while(!scan.hasNextInt()) { 
                System.out.println("Dígito inválido, tente novamente!");
                System.out.print(">> ");
                scan.nextInt();
            }

            opcao = scan.nextInt();

            switch(opcao){
                case 0: System.out.println("Saindo do sonora... "); break;
                case 1: plataforma.cadastrarMusicaManualmente(); break;
                case 2: plataforma.cadastrarUsuarioManualmente(); break;
                case 3: plataforma.criarPlaylistEAdicionarMusicas(); break;
                
                default:System.out.println("Dígito inválido, tente novamente!");

            }

        }while(opcao != 0);

        scan.close();

    }
}
