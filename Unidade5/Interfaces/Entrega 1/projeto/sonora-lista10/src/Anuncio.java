import Interfaces.Faturavel;
import Interfaces.Reproduzivel;

public class Anuncio implements Faturavel, Reproduzivel{
    private String anunciante;
    private String titulo;
    private int duracaoSegundos;
    private double valorPorMilImpressoes;
    private int impressoes;

    public Anuncio(String anunciante, String titulo, int duracaoSegundos, double valorPorMilImpressoes){
        setAnunciante(anunciante);
        setTitulo(titulo);
        setDuracaoSegundos(duracaoSegundos);
        setValorPorMilImpressoes(valorPorMilImpressoes);
        this.impressoes = 0;
    }

    @Override
    public final void reproduzir() {
        impressoes++;
        System.out.println("[ANUNCIO] - "+getTitulo()+" - oferecimento de - "+getAnunciante());
    }

    @Override
    public double calcularMensalidade(){
        return (impressoes / 1000.0) * getValorPorMilImpressoes();
    }

    public String getAnunciante(){
        return anunciante;
    }

    public void setAnunciante(String anunciante){
        if(anunciante.isBlank() || anunciante.isEmpty()){
            throw new IllegalArgumentException("O anunciante deve ser preenchido corretamente!");
        }

        this.anunciante = anunciante;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        if(titulo.isBlank() || titulo.isEmpty()){
            throw new IllegalArgumentException("O título deve ser preenchido corretamente!");
        }
        this.titulo = titulo;
    }

    @Override
    public int getDuracaoSegundos(){
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos){
        if(duracaoSegundos <= 0){
            throw new IllegalArgumentException("A duração mínima de um anúncio é 1 segundo!");
        }

        this.duracaoSegundos = duracaoSegundos;
    }

    public double getValorPorMilImpressoes(){
        return valorPorMilImpressoes;
    }

    public void setValorPorMilImpressoes(double valorPorMilImpressoes){
        if(valorPorMilImpressoes <= 0){
            throw new IllegalArgumentException("O valor por mil impressões mínimo de um anúncio é R$ 0,1 reais!");
        }

        this.valorPorMilImpressoes = valorPorMilImpressoes;
    }

    public int getImpressoes(){
        return impressoes;
    }

}
