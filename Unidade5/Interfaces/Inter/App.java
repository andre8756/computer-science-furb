import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        Bateria bateria = new Bateria();
        Cachorro cachorro = new Cachorro();

        ArrayList<EmitirSom> array = new ArrayList();

        array.add(bateria);
        array.add(cachorro);

        for(EmitirSom obj : array){
            System.out.println(obj.emitirSom());
        }



    }
}
