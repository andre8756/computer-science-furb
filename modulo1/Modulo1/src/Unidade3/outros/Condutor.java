package Unidade3.outros;

public class Condutor extends Pessoa {

    private String cnh;
    private String crv;

    public Condutor(String nome, String cpf, String cnh, String crv) {
        super(nome, cpf);
        this.cnh = cnh;
        this.crv = crv;
    }

    public String getCnh() {
        return this.cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCrv() {
        return crv;
    }

    public void setCrv(String crv) {
        this.crv = crv;
    }

}
