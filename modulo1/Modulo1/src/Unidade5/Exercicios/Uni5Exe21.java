public class Uni5Exe21 {
    public static void main(String[] args) {
        float alturaChico = 1.5f;
        float alturaZe = 1.1f;

        int anos = 0;

        while(alturaZe <= alturaChico){
            alturaChico += 0.02f;
            alturaZe += 0.03f;
            anos++;
        }

        System.out.printf("São necessários %d anos para Zé ter %.2f m de altura e Chico ter %.2f m \n", anos, alturaZe, alturaChico);
        System.out.println("E então Zé ser maior que Chico");


    }
}
