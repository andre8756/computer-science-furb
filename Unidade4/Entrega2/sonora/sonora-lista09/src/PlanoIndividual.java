public class PlanoIndividual extends PlanoPago{
    // Se o método calcularMensalidade() fosse movido para PlanoPago, 
    // Então o PalnoIndividual poderia deixar de existir, e o PlanoPago
    // poderia deixar de ser abstrato, pois poderia ser utilizado normalmente
    // como um plano individual e o PlanoFamilia heradira PlanoPago diretamente.

    public PlanoIndividual(double precoMensal) {
        super("Pago Individual", 1, precoMensal);
    }

    @Override
    public double calcularMensalidade() {
        return getPrecoMensal();
    }
}