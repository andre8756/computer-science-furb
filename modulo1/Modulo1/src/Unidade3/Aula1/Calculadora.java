package Unidade3.Aula1;

public class Calculadora {
    private int n1;
    private int n2;
    private int resultado;

    public Calculadora(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int somar() {
        return this.n1 + this.n2;
    }

    public int somarDoisNumeros(int n1, int n2) {
        return n1 + n2;
    }

    public void obterNumeros() {
        System.out.println(n1);
        System.out.println(n2);
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(1, 2);
        int valor = calculadora.somarDoisNumeros(10, 5);
        System.out.println(valor);

        valor = calculadora.somar();
        System.out.println(valor);

    }

}
