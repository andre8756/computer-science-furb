public class Baixo extends InstrumentoDeCorda implements Eletronico{
    public Baixo(int cordas){
        super(cordas);
    }

    @Override
    public String emitirSom(){
        return "Boom Bauum Baauum";
    }

    @Override
    public String plugarTomada(){
        return "Plufite - plugado na tomada com sucesso";
    }
}
