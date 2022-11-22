/**
 * Preto, com multiplicador 1.5
 */
public class Preto extends Acelerador {
    final static double CUSTO = 19.99;

    @Override
    public double multiplicator(double pontos) {
        return pontos * 1.5;
    }

    @Override
    public void activate() {
        this.ativo = true;
    }

    @Override
    public void cancelAcelerator() {
        this.ativo = false;
    }

    public double getCusto() {
        return Preto.CUSTO;
    }
}
