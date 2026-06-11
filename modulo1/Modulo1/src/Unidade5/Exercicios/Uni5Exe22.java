public class Uni5Exe22 {
    public static void main(String[] args) {
        float salario = 2000;
        float aumento = 0.015f;
        int ano = 1995;

        salario += (salario * aumento);
        ano++;

        while(ano < 2026){
            aumento *= 2;
            salario += (salario*aumento);
            ano++;
        }

        System.out.printf("Salário atual: %.2f", salario);
        System.out.println("O salário é muito grande e pode dar erro ao printar");


    }
}
