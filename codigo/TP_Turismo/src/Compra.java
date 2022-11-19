import java.sql.Date;

public class Compra {
    private Date dataDaCompra;
    private Bilhete bilhete = new Bilhete();
    
    public void buyToTicket(Bilhete bilhete, Date data) {
        this.bilhete = bilhete;
        this.dataDaCompra = data;
    }

    public double getValue() {
        return bilhete.getValue();
    }
}
