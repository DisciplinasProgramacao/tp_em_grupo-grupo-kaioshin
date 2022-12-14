import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private Data dataDaCompra;
    private Bilhete bilhete = null;
    private double preco;
    private boolean freeTicket = false;

    public void buyToTicket(Bilhete bilhete, int[] data) {
        this.dataDaCompra = new Data(data[0],data[1],data[2]);
        this.freeTicket = bilhete.getType().equals("Fidelidade") ? true : false;
        this.preco = bilhete.getValue();
    }

    public String toString() {
        String s;
		
        StringBuilder str = new StringBuilder("Compra: " + this.dataDaCompra.dataFormatada() + "\n");
        str.append(bilhete.showVoo());
        s = str.toString();
        return s;
    }

    public void setPreco(double preco) {
        this.preco += this.getValue() + preco;
    }

    public String getDescBilhete() {
        return bilhete.toString();
    }

    public double getValue() {
        return this.preco;
    }

    public Data getData() {
        return this.dataDaCompra;
    }
    public boolean getFreeTicket() {
        return this.freeTicket;
    }

    public Bilhete getBilhete() {
        return this.bilhete;
    }
}
