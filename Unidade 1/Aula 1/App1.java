public class App1 {
    public static void main(String[] args){
        Carro carro1 = new Carro();

        carro1.ano = 1979;
        carro1.marca = "VW";
        carro1.modelo = "Fusca";
        carro1.cor = "Azul";

        Carro carro2 = new Carro();
        carro2.ano = 2026;
        carro2.marca = "BYD";
        carro2.modelo= "Dolphin";

        Carro carro3 = carro1;  

        System.out.println("Modelo carro 1: " + carro1.modelo);
        System.out.println("O carro 2 está com a situação: " + carro2.situacaoAtual);
        System.out.println("O ano do carro 3 é:" + carro3.ano);
    }
}
