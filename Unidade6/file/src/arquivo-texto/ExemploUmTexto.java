
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ExemploUmTexto {

    public static void main(String[] args) {

        File arquivo = new File("textop.txt");

        try (PrintWriter arquivoTexto = new PrintWriter(arquivo, StandardCharsets.UTF_8)) {

            arquivoTexto.println("");
            arquivoTexto.println(true);
            arquivoTexto.println("");

            System.out.println("Arquivo criado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }
}
