public class App {
    public static void main(String args[]){
        Musica musica = new Musica("teste", "andre", 65);

        System.out.println(musica.getTitulo());
        System.out.println(musica.getArtista());
        System.out.println(musica.getDuracaoSegundos());
        System.out.println(musica.getReproducoes());
        System.out.println(musica.getDuracaoFormatada());
    }
}
