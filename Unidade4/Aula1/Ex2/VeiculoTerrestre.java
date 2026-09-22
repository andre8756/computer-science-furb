public class VeiculoTerrestre extends Veiculo{
    public VeiculoTerrestre(int anoTerrestre, String modeloTerrestre, String marcaTerrestre, int valorTerrestre){
        super(valorTerrestre);
        setAnoFabricacao(anoTerrestre);
        setModelo(modeloTerrestre);
        setMarca(marcaTerrestre);
    }
}