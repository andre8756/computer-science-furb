public class Cachorro implements EmitirSom, TemSentimento{

    @Override
    public String getSentimento(){
        return "Alegria";
    }

    @Override
    public String emitirSom(){
        return "Au au";
    }
}
