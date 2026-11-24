package file.revisaoProva.Ex1;

import java.io.File;
import java.io.FileOutputStream;

public class Main {
    // Lista o conteúdo de um diretório, indicando o que é diretório e o que é
    // arquivo
    public static void main(String[] args) {
        File diretorio = new File("PastaCriada");

        File arquivo1;
        FileOutputStream fos;

        try{
            arquivo1 = new File("PastaCriada/este1.txt");
            fos = new FileOutputStream(arquivo1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if(!diretorio.exists()) {
            diretorio.mkdir();
            System.out.println("diretorio criado");
        } else {
            System.out.println("nao deu 1");
        }

        File[] conteudoDiretorio = diretorio.listFiles();

        if(conteudoDiretorio == null){
            System.out.println("nao deu");
            return;
        }

        for (File item : conteudoDiretorio) {
            if (item.isDirectory()) {
                System.out.println("Diretório: " + item.getName());
            } else {
                System.out.println("Arquivo " + item.getName() +
                        " tem " + item.length() + " bytes");
            }
        }
    }
}
