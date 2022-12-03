import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private Data dataDaCompra;
    private Bilhete bilhete = null;
    private double preco;
   
    public void buyToTicket(Bilhete bilhete, int[] data) {
        this.bilhete = bilhete.pontos >= 10.500 ?  new BilheteFidelidade() :  bilhete;
        this.dataDaCompra = new Data(data[0],data[1],data[2]);
        
    }

    public String toString() {
        String s;
		
        StringBuilder str = new StringBuilder("Compra: " + this.dataDaCompra.dataFormatada() + "\n");
        str.append(bilhete.showVoo());
        s = str.toString();
        return s;
    }

    public void setPreco(double preco) {
        preco += this.getValue() + preco;
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

    public Bilhete getBilhete(){
        return this.bilhete;
    }
}
