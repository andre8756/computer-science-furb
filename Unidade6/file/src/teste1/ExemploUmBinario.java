import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ExemploUmBinario {

    public static void main(String[] args) {

        File arquivo;
        FileOutputStream fos;
        try {
            arquivo = new File("dados.dat");
            fos = new FileOutputStream(arquivo);
            fos.write(79);
            fos.write(105);
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (IOException e) {

        }

    }
}
