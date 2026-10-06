public class Violao extends InstrumentoDeCorda {
    public Violao(int cordas){
        super(cordas);
    }

    @Override
    public String emitirSom(){
        return "chalalalam";
    }
}
