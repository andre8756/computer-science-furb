public class MediaPonderada {
    public static void main(String[] args) {

        float prova1 = 0;
        float prova2 = 9;
        float trabalhoFinal = 9.7f;
        float mediaTrabalhos = (10 + 8.5f + 0 + 5 + 10 + 9.8f + 9.5f) / 7;

        float media = prova1 * 0.2f +
                prova2 * 0.3f +
                trabalhoFinal * 0.3f +
                mediaTrabalhos * 0.2f;

        System.out.println("A media é " + media);
    }

}
