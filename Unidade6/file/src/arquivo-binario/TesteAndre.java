import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TesteAndre {
    public void main(String[] args){
        File arquivo;
        FileOutputStream fos;
        try {
            arquivo = new File("dados.dat");
            int fileLenght = (int) arquivo.length();

            byte[] bt

            fos = new FileOutputStream(arquivo, true);
            fos.write(8);
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (IOException e) {

        }
    }
}
