package objetos;

import java.io.File;
import

public class ExemploUmObjetos {
    public static void main(String[] args){
        File f;
        try{
            f = new File("Ibjetos.bin");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(fos);
        } catch(IOException e){

        }

    }
}
