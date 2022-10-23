/**
 * Utilização de interface para caso no futuro outras classes precise implementar promoções como por exemplo a classe voo.
 */
public interface IPromocao {
    /**
     * BILHETE DESCONTO
     */
    public void ticketDiscount();
    /**
     * BILHETE FIDELIDADE
     */
    public void ticketFaithfulness();
}
