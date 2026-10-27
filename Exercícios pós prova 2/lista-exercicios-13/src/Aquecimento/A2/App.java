package Aquecimento.A2;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Midia f = new Filme("Interestelar", 20.0);
        Midia s = new Serie("Dark", 15.0, 3);
        Midia d = new Documentario("Leões na Savana", 18);
        ArrayList<Midia> catalogo = new ArrayList<>();
        catalogo.add(f);
        catalogo.add(s);
        catalogo.add(d);
        double totalLegenda = 0;

        for (Midia m : catalogo) {
            if (m instanceof Legendavel) {
                totalLegenda += ((Legendavel) m).calcularCustoLegenda();
            }
        }

        System.out.println("Total Legendados: " + totalLegenda);
    }


    // Ao reescrever as variáveis para o tipo midia, isso permite
    //  coleções genéricas e código reutilizável para todas as mídias.


    // O custo de legenda do documentário entrou no total? Sim, entrou;

    // Como o intuito é pegar todas as midiais legendáveis, até mesmo
    // as que ainda não existem, devemos fazer o downcasting com a interface
    // legendavel, e o mesmo vai para o instanceof

 }
