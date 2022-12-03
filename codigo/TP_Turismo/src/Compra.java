import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private Data dataDaCompra;
    private Bilhete bilhete = null;
   
    public void buyToTicket(Bilhete bilhete, int[] data) {
        this.bilhete = bilhete.pontos >= 10.500 ?  new BilheteFidelidade() :  bilhete;
        this.dataDaCompra = new Data(data[0],data[1],data[2]);
        
    }

    public String toString() {
        String s;
		
        StringBuilder str = new StringBuilder("Compra: " + this.dataDaCompra.toString() + "\n");
        str.append(bilhete.showVoo());
        s = str.toString();
        return s;
    }

    public String getDescBilhete() {
        return bilhete.toString();
    }

    public double getValue() {
        return bilhete.getValue();
    }

    public Data getData() {
        return this.dataDaCompra;
    }

    public Bilhete getBilhete(){
        return this.bilhete;
    }
}
