import Planos.Plano;
import Planos.PlanoGratuito;

public class App3 {
    public static void main(String[] args) {

        // Tipo estático = Conteudo ---- Tipo dinâmico Podcast
        Conteudo c = new Podcast("titulo1", 45, "artista1", 1);

        // c.getApresentador();
        // Este comando não compila, pois o Java vai verificar se
        // a classe Conteudo possui o método getApresentador(),
        // pois Conteudo é o tipo estático da nossa variável c.
        // Porém, o método getApresentador() pertence à classe Podcast.
        
        Plano p = new PlanoGratuito();
        System.out.println(p.resumo());
    }
}
