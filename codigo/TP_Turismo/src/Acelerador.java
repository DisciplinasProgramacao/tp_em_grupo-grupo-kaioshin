/**
 * Temos dois tipos de aceleradores: prata, com multiplicador 1.25 e preto, com multiplicador 1.5
 * Cada acelerador tem um custo mensal e pode ser trocado ou desativado a qualquer momento.
 */
public abstract class Acelerador {
    protected boolean ativo;

    /**
     * Multiplica os pontos de acordo com a regra do plano contratado Prata ou Preto
     */
    public abstract double multiplicator(double pontos);

    /**
     * Torna o plano do acelerador ativo
     */
    public abstract void activate();

    /**
     * Torna o plano do acelerador inativo
     */
    public abstract void cancelAcelerator();
}
