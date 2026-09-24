public class Conteudo {
    private static int contadorId = 0;
    private final int id;
    private String titulo;
    private int duracaoSegundos;
    private int reproducoes;

    public Conteudo(String titulo, int duracaoSegundos) {
        contadorId++;
        this.id = contadorId;
        setTitulo(titulo);
        setDuracaoSegundos(duracaoSegundos);
        reproducoes = 0;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("O título não pode estar em branco!");
        }
        this.titulo = titulo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0) {
            throw new IllegalArgumentException("A música não pode ter menos de 1 segundo!");
        }

        this.duracaoSegundos = duracaoSegundos;
    }

    public int getReproducoes(){
        return reproducoes;
    }

    public void reproduzir() {
        System.out.println("Reproduzindo: " + toString());
        reproducoes++;
    }

    @Override
    public String toString() {
        return "[" + getId() + "] " + titulo
                + " (" + duracaoSegundos + "s)";
    }

}
