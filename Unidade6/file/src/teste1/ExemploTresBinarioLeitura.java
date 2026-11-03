import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ExemploTresBinarioLeitura {
    public static void main(String[] args) {

        File f;
        FileInputStream fis;

        try {
            f = new File("dados.dat");
            fis = new FileInputStream(f);
            int dado;

            while (true) {
                dado = fis.read();

                if (dado != -1) {
                    System.out.print((char)dado); // realiza a conversão de binario para char
                } else {
                    break;
                }
            }

            fis.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        System.out.println("");
        System.out.println("Terminou");

    }
}
