/**
 * Temos dois tipos de aceleradores: prata, com multiplicador 1.25
 * Cada acelerador tem um custo mensal e pode ser trocado ou desativado a qualquer momento.
 */
public class Prata extends Acelerador{
    final static double CUSTO = 12.99;

    @Override
    public double multiplicator(double pontos) {
        return pontos * 1.25;
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
        return Prata.CUSTO;
    }
}
