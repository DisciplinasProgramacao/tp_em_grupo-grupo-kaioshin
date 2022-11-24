import java.util.Date;

public class Compra {
    private Data dataDaCompra;
    private Bilhete bilhete = new Bilhete();
    
    public void buyToTicket(Bilhete bilhete, int[] data) {
        this.bilhete = bilhete;
        this.dataDaCompra = new Data(data[0],data[1],data[2]);
    }

    public double getValue() {
        return bilhete.getValue();
    }

    public Data getData() {
        return this.dataDaCompra;
    }
}
