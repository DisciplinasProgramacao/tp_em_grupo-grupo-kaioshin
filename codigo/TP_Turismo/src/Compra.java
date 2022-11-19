import java.sql.Date;

public class Compra {
    private Date dataDaCompra;
    private Bilhete bilhete = new Bilhete();
    
    public void buyToTicket(Bilhete bilhete, Date dataDaCompra) {
        this.bilhete = bilhete;
        this.dataDaCompra = dataDaCompra;
    }
}
