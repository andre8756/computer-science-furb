package Aquecimento;

public class Senha {
    private static int totalEmitidas = 0;
    private int numero;
    private String setor;

    Senha(String setor){
        if(setor == null || setor.isBlank()){throw new IllegalArgumentException("Setor obrigatório");}
        this.setor = setor;

        numero = ++totalEmitidas;
    }

    public int getNumero(){
        return numero;
    }

    public String getSetor(){
        return setor;
    }

    public static int getTotalEmitidas(){
        return totalEmitidas;
    }

    @Override
    public String toString(){
        return String.format("%d - %s", numero, setor);
    }
}
