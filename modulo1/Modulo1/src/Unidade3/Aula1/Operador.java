package Unidade3.Aula1;

public class Operador {
    public static void main(String[] args) {
        int numero = 10;
        numero++;
        numero--;

        int x = 10;
        int y = 23;

        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;

        String texto = "Amanhã é quinta-feira";
        System.out.println(texto.toUpperCase());
        System.out.println(texto.toLowerCase());

        boolean ehPalavra = false;
        ehPalavra = texto.equals("Amanhã é quinta-feira");
        ehPalavra = texto.toUpperCase().equals(
                "Amanhã é quinta-feira".toUpperCase());
    }
}
