import java.util.Date;

public class Compra {
    private Date dataDaCompra;
    private Bilhete bilhete = new Bilhete();
    
    public void buyToTicket(Bilhete bilhete, String data) {
        this.bilhete = bilhete;
        this.dataDaCompra = new Date(data);
    }

    public double getValue() {
        return bilhete.getValue();
    }

    public Date getData() {
        return this.dataDaCompra;
    }
}
