import java.util.Scanner;

public class Uni6Exe05 {
    Scanner scan = new Scanner(System.in);
    int perguntas = 5;
    char[] rapaz = new char[perguntas];
    char[] moça = new char[perguntas];
    int pontos = 0;
    
    public void ler(){
        System.out.println("Reponder com: S (sim) / N (Não) / I (Indiferente)");
        System.out.println("");

        System.out.println("----Rapaz:");
        System.out.print("Gosta de música sertaneja? ");
        rapaz[0] = scan.next().toLowerCase().charAt(0);
        System.out.print("Gosta de futebol? ");
        rapaz[1] = scan.next().toLowerCase().charAt(0);
        System.out.print("Gosta de seriados? ");
        rapaz[2] = scan.next().toLowerCase().charAt(0);
        System.out.print("Gosta de redes sociais? ");
        rapaz[3] = scan.next().toLowerCase().charAt(0);
        System.out.print("Gosta da Oktoberfest? ");
        rapaz[4] = scan.next().toLowerCase().charAt(0);

        System.out.println("----Moça:");
        System.out.print("Gosta de música sertaneja? ");
        moça[0] = scan.next().toLowerCase().charAt(0);
        System.out.print("Gosta de futebol? ");
        moça[1] = scan.next().toLowerCase().charAt(0);
        System.out.print("Gosta de seriados? ");
        moça[2] = scan.next().toLowerCase().charAt(0);
        System.out.print("Gosta de redes sociais? ");
        moça[3] = scan.next().toLowerCase().charAt(0);
        System.out.print("Gosta da Oktoberfest? ");
        moça[4] = scan.next().toLowerCase().charAt(0);
    }

    public void calcula(){
        for(int i = 0; i < perguntas; i++){
            if(rapaz[i] == moça[i]){
                pontos += 3;
            } else if(rapaz[i] == 'i' || moça[i] == 'i'){
                pontos += 1;
            } else{
                pontos -= 2;
            }
        }

        if(pontos >= 15){
            System.out.println("Casem!");
        } else if(pontos >= 10){
            System.out.println("Vocês têm muita coisa em comum!");
        } else if(pontos >= 5){
            System.out.println("Talvez não dê certo :(");
        } else if(pontos >= 0){
            System.out.println("Vale um encontro.");
        } else if(pontos >= -9){
            System.out.println("Melhor não perder tempo");
        } else{
            System.out.println("Vocês se odeiam!");
        }
    }

    public static void main(String[] args) {
        Uni6Exe05 exe05 = new Uni6Exe05();
        exe05.ler();
        exe05.calcula();
    }

}
