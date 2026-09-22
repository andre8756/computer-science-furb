public class Moto extends VeiculoTerrestre{
        public Moto(int anoTerrestre, String modeloTerrestre, String marcaTerrestre, int valorTerrestre){
        super(anoTerrestre, modeloTerrestre, marcaTerrestre, valorTerrestre);
    }

    @Override
    public String toString(){
        return "Moto " + super.toString();
    }
}
