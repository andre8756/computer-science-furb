public class App {
    public static void main(String[] args){
        Veiculo v = new Veiculo(1000);
        
        v.setAnoFabricacao(1900);
        v.setModelo("Chevrole");
        v.setMarca("Errei");
        System.out.println(v.getValor());
        System.out.println(v.getModelo());
        System.out.println(v.getMarca());
        System.out.println(v.getAnoFabricacao());


        VeiculoTerrestre vt = new VeiculoTerrestre(1900, "Vei TErres", "Marca terrestre", 1900090);

        System.out.println(vt.getValor());
        System.out.println(vt.getModelo());
        System.out.println(vt.getMarca());
        System.out.println(vt.getAnoFabricacao());

        Veiculo moto = new Moto(1900, "Vei TErres", "Marca terrestre", 1900090);

        System.out.println(moto.toString());

    }
}
